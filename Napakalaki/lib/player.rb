# encoding: utf-8

# TODO: revisar los 'require' cuando se hayan implementado todos los métodos
#require_relative 'card_dealer'
#require_relative 'dice'
#require_relative 'combat_result'

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
    
    # revivir al jugador
    def bringToLife
      @dead = false
    end
    
    # obtener nivel de combate
    def getCombatLevel
      combatLevel = 0
      @visibleTreasures.each { |vt| combatLevel += vt.bonus }
      combatLevel += level
    end

    # obtener el máximo nivel del jugador
    def self.getMaxLevel
      @@MAXLEVEL
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

    end

    def applyBadConsequence(m)

    end

    def canMakeTreasureVisible(t)
      case t.type
      when TreasureKind::ARMOR, TreasureKind::HELMET, TreasureKind::SHOE
        howManyVisibleTreasures(t.type) < 1
      when TreasureKind::ONEHAND
        howManyVisibleTreasures(t.type) < 2 and howManyVisibleTreasures(TreasureKind::BOTHHANDS) < 1
      when TreasureKind::BOTHHANDS
        howManyVisibleTreasures(t.type) < 1 and howManyVisibleTreasures(TreasureKind::ONEHAND) < 1
      end
    end

    # devuelve cuántos tesoros visibles de tipo tKind tiene el jugador
    def howManyVisibleTreasures(tKind)
      count = 0
      @visibleTreasures.each do |vt|
        if vt.type == tKind
          count += 1
        end
      end
      count
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
      monsterLevel = m.getCombatLevel
      
      if !canISteal
        dice = Dice.instance
        number = dice.nextNumber
        if number < 3
          enemyLevel = enemy.getCombatLevel
          monsterLevel += enemyLevel
        end
      end

      if myLevel > monsterLevel
        applyPrize(m)
        if level > MAXLEVEL
          combatResult = CombatResult::WINGAME
        else
          combatResult = CombatResult::WIN
        end
      else
        applyBadConsequence(m)
        combatResult = CombatResult::LOSE
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
      visibleTreasures.delete(t)
      # ¿Aplicar ley de De Morgan?
      if (!@pendingBadConsequence.nil? and !@pendingBadConsequence.empty?)
        @pendingBadConsequence.substractVisibleTreasure(t)
      end

      dieIfNoTreasures
    end

    def discardHiddenTreasure(t)
      hiddenTreasures.delete(t)
      if (!@pendingBadConsequence.nil? and !@pendingBadConsequence.empty?)
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

    end

    def stealTreasure

    end

    private
    
    def giveMeATreasure
      @hiddenTreasures[rand(@hiddenTreasures.length)]
    end

    # comprueba si el jugador puede ser robado por su enemigo
    def canYouGiveMeATreasure
      # TODO: revisar cuando implementemos jugadores sectarios
      not @hiddenTreasures.empty?
    end

    # actualiza la información del jugador para reflejar que ha robado a su enemigo
    def haveStolen
      @canISteal = false
    end

    public
    
    def discardAllTreasures

    end
    
    def to_s
      "Nombre: #{@name} \nNivel: #{@level} \nTeosoros visibles: " + 
        @visibleTreasures.map(&:name).join(", ") +
        "\nTesoros ocultos: " + @hiddenTreasures.map(&:name).join(", ") \
        + "\nMuerto: " + (@dead ? "Sí" : "No") +
        "\nPuede robar: " + (@canISteal ? "Sí" : "No") + "\nMal rollo pendiente:" +
        "\n#{@pendingBadConsequence}" + "\nEnemigo:\n" + (@enemy.nil? ? "" : "#{@enemy.name}")
    end

  end # Player

end # NapakalakiGame
