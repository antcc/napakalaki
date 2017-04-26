# encoding: utf-8

require_relative 'card_dealer'
require_relative 'dice'
require_relative 'combat_result'
require_relative 'treasure_kind'

module NapakalakiGame
  
  #class Player: representa un jugador
  class Player
    attr_reader :name                     # nombre del jugador
    attr_reader :level                    # nivel del jugador
    attr_reader :hiddenTreasures          # tesoros ocultos
    attr_reader :visibleTreasures         # tesoros visibles
    attr_reader :canISteal                # representa si ha robado a su archienemigo
    attr_writer :pendingBadConsequence    # mal rollo pendiente de aplicar
    attr_writer :enemy                    # jugador archienemigo asignado
    
    @@MAXLEVEL = 10                       # máximo nivel que puede alcanzar un jugador
    
    # Para poder implementar el constructor de copia
    protected 
    attr_reader :pendingBadConsequence
    
    public

    def initialize(name)
      @name = name
      @level = 1  # el nivel mínimo es 1
      @hiddenTreasures = Array.new
      @visibleTreasures = Array.new
      @canISteal = true
      @pendingBadConsequence = nil
      @enemy = nil
      @dead = true  # cuando el jugador se crea, está muerto
    end

    private

    def copy_const(p)
      @name = p.name
      @level = p.level
      @hiddenTreasures = p.hiddenTreasures
      @visibleTreasures = p.visibleTreasures
      @canISteal = p.canISteal
      @pendingBadConsequence = p.pendingBadConsequence
      @enemy = p.getEnemy
      @dead = p.isDead
    end

    public

    def getVisibleTreasures
      @visibleTreasures
    end

    def getHiddenTreasures
      @hiddenTreasures
    end

    def getName
      @name
    end
    
    # obtener el máximo nivel del jugador
    def self.getMaxLevel
      @@MAXLEVEL
    end

    private
    
    # revivir al jugador
    def bringToLife
      @dead = false
    end
    
    # Es public para poder acceder desde la clase Napakalaki en el método developCombat
    public 

    def getEnemy
      @enemy
    end
    
    protected
    
    # obtener nivel de combate
    def getCombatLevel
      combatLevel = 0
      @visibleTreasures.each { |vt| combatLevel += vt.bonus }
      combatLevel += level
    end

    def getOponentLevel(m)
      m.getCombatLevel
    end

    def shouldConvert
      Dice.instance.nextNumber == 6
    end
    
    private

    def setPendingBadConsequence(p)
      @pendingBadConsequence = p
    end

    # incrementa el nivel del jugador en l niveles, sin pasarse del máximo
    def incrementLevels(l)
      @level = [@level + l, @@MAXLEVEL].min
    end
    
    # decrementa el nivel del jugador en l niveles, sin pasarse del mínimo
    def decrementLevels(l)
      @level = [@level - l, 1].max
    end

    def applyPrize(m)
      nLevels = m.getLevelsGained
      incrementLevels(nLevels)

      nTreasures = m.getTreasuresGained

      if nTreasures > 0
        dealer = CardDealer.instance
        nTreasures.times do
          @hiddenTreasures << dealer.nextTreasure
        end
      end
    end

    def applyBadConsequence(m)
      badConsequence = m.getBadConsequence
      nLevels = badConsequence.getLevels

      decrementLevels(nLevels)
      pendingBad = badConsequence.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
      setPendingBadConsequence(pendingBad)
    end

    def canMakeTreasureVisible(t)
      case t.type
        when TreasureKind::ONEHAND then
          howManyVisibleTreasures(t.type) < 2 and howManyVisibleTreasures(TreasureKind::BOTHHANDS) < 1
        when TreasureKind::BOTHHANDS then
          howManyVisibleTreasures(t.type) < 1 and howManyVisibleTreasures(TreasureKind::ONEHAND) < 1
        else
          howManyVisibleTreasures(t.type) < 1
      end
    end

    # devuelve cuántos tesoros visibles de tipo tKind tiene el jugador
    def howManyVisibleTreasures(tKind)
      @visibleTreasures.count { |vt| vt.type == tKind }
    end

    # el jugador muere si no tiene tesoros
    def dieIfNoTreasures
      if @visibleTreasures.empty? and @hiddenTreasures.empty?
        @dead = true
      end
    end

    public
    
    # comprueba si el jugador está muerto
    def isDead
      @dead
    end

    # combate contra el enemigo m
    def combat(m)
      myLevel = getCombatLevel
      monsterLevel = getOponentLevel(m)
      
      if !@canISteal
        dice = Dice.instance
        number = dice.nextNumber
        if number < 3
          enemyLevel = @enemy.getCombatLevel
          monsterLevel += enemyLevel
        end
      end

      if myLevel > monsterLevel
        applyPrize(m)
        if @level >= @@MAXLEVEL
          combatResult = CombatResult::WINGAME
        else
          combatResult = CombatResult::WIN
        end
      else
        applyBadConsequence(m)
        if shouldConvert
          combatResult = CombatResult::LOSEANDCONVERT
        else
          combatResult = CombatResult::LOSE
        end
      end
    end

    def makeTreasureVisible(t)
      canI = canMakeTreasureVisible(t)
      if canI
        @visibleTreasures << t
        @hiddenTreasures.delete(t)
      end
    end

    def discardVisibleTreasure(t)
      @visibleTreasures.delete(t)
      if !@pendingBadConsequence.nil? and !@pendingBadConsequence.isEmpty
        @pendingBadConsequence.substractVisibleTreasure(t)
      end

      dieIfNoTreasures
    end

    def discardHiddenTreasure(t)
      @hiddenTreasures.delete(t)
      if !@pendingBadConsequence.nil? and !@pendingBadConsequence.isEmpty
        @pendingBadConsequence.substractHiddenTreasure(t)
      end

      dieIfNoTreasures
    end

    # comprueba si el jugador está en estado válido
    def validState
      (@pendingBadConsequence.nil? or @pendingBadConsequence.isEmpty) and \
        @hiddenTreasures.length <= 4
    end

    def initTreasures
      dealer = CardDealer.instance
      dice = Dice.instance

      bringToLife

      treasure = dealer.nextTreasure
      @hiddenTreasures << treasure

      number = dice.nextNumber

      if number > 1
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
      end

      if number == 6
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
      end
    end

    def stealTreasure
      treasure = nil
      if @canISteal
        if @enemy.canYouGiveMeATreasure
          treasure = @enemy.giveMeATreasure
          @hiddenTreasures << treasure
          haveStolen
        end
      end
      treasure
    end

    private

    # actualiza la información del jugador para reflejar que ha robado a su enemigo
    def haveStolen
      @canISteal = false
    end

    # Los dos siguientes métodos no pueden ser privados, porque necesitamos llamarlos tal que
    # así: @enemy.giveMeATreasure, por ejemplo. Los ponemos protected como solución temporal.
    protected

    # comprueba si el jugador puede ser robado por su enemigo
    def canYouGiveMeATreasure
      not @hiddenTreasures.empty?
    end

    def giveMeATreasure
      @hiddenTreasures.delete_at(rand(@hiddenTreasures.length))
    end
    
    public
    
    def discardAllTreasures
      vTreasures = visibleTreasures.dup
      hTreasures = hiddenTreasures.dup

      vTreasures.each do |t|
        discardVisibleTreasure(t)
      end

      hTreasures.each do |t|
        discardHiddenTreasure(t)
      end
    end

    def to_s
      text = "#{@name} (nivel #{@level}, nivel de combate #{getCombatLevel})" +
        "\n - Muerto: " + (@dead ? "Sí" : "No") +
        "\n - Puede robar: " + (@canISteal ? "Sí" : "No") +
        "\n - Enemigo: #{@enemy.name}" +
        "\n - Mal rollo pendiente: "
    
      if @pendingBadConsequence != nil and !@pendingBadConsequence.isEmpty
        text += "\n#{@pendingBadConsequence}" 
      else
        text += "NO"
      end

      #text += "\nTeosoros visibles: " + @visibleTreasures.map(&:name).join(", ") +
      #"\nTesoros ocultos: " + @hiddenTreasures.map(&:name).join(", ") 
    end

  end # Player

end # NapakalakiGame
