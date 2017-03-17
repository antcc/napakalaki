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

    def combat(m)

    end

    def makeTreasureVisible(t)

    end

    def discardVisibleTreasure(t)

    end

    def discardHiddenTreasure(t)

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
        @visibleTreasures.map { |i| "'" + i.name + "'" }.join(", ") + \
        "\nTesoros ocultos: " + @hiddenTreasures.map { |i| "'" + i.name + "'" }.join(", ") + \
        "\nMuerto: " + (@dead ? "Sí" : "No") + 
        "\nPuede robar: " + (@canISteal ? "Sí" : "No") + "\nMal rollo pendiente:\n" +
        "#{@pendingBadConsequence} \nEnemigo:\n#{@enemy}"
    end

  end # Player

end # NapakalakiGame
