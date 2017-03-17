# encoding: utf-8

# TODO: revisar los 'require' cuando se hayan implementado todos los métodos
#require_relative 'combat_result'

module NapakalakiGame

  # class Napakalaki: representa una instancia del juego
  class Napakalaki
    include Singleton  # La clase es <<singleton>>

    attr_reader :currentMonster  # monstruo actual
    attr_reader :currentPlayer   # jugador actual

    def initialize

    end

    private
    
    def initPlayers(names)

    end

    def nextPlayer

    end

    def nextTurnAllowed

    end

    def setEnemies

    end

    public
    
    def developCombat

    end

    # @pre: treasures no vacío
    def discardVisibleTreasures(treasures)

    end

    # @pre: treasures no vacío
    def discardHiddenTreasures(treasures)

    end

    # @pre: treasures no vacío
    def makeTreasuresVisible(treasures)

    end

    def initGame(players)

    end

    def nextTurn

    end

    def endOfGame(result)

    end
    
    # TODO: implementar
    def to_s
      
    end

  end # Napakalaki

end # NapakalakiGame
