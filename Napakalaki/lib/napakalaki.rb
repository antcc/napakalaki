# encoding: utf-8

# TODO: revisar los 'require' cuando se hayan implementado todos los métodos
#require_relative 'combat_result'
require_relative 'card_dealer'
require 'singleton'

module NapakalakiGame

  # class Napakalaki: representa una instancia del juego
  class Napakalaki
    include Singleton  # la clase es <<singleton>>

    attr_reader :currentMonster  # monstruo actual
    attr_reader :currentPlayer   # jugador actual

    def initialize
      @currentMonster = nil
      @currentPlayer = nil
      @players = Array.new
      @dealer = CardDealer.instance
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
    
    def to_s
      "Jugadores: #{@players} \nJugador acutal: #{@currentPlayer}" +
        "\nMonstruo actual: #{@currentMonster}"
    end

  end # Napakalaki

end # NapakalakiGame
