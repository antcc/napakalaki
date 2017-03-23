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
      names.each { |n| @players << Player.new(n) }
    end

    def nextPlayer
      num_players = @players.legth
      if @currentPlayer.nil? 
        nextP = rand(num_players)
      else
        nextP = (@players.index(@currentPlayer) + 1) % num_players
      end
      @currentPlayer = @players[nextP]
    end

    def nextTurnAllowed
      @currentPlayer.nil? or (@currentPlayer.validState == true)
    end

    def setEnemies
      @players.each do |p|
        begin
          enemy = rand(@players.length) 
        end while @players[enemy] == p
        p.enemy = @players[enemy]
      end
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
      result == CombatResult::WINGAME
    end
    
    def to_s
      "Jugadores: #{@players} \nJugador acutal: #{@currentPlayer}" +
        "\nMonstruo actual: #{@currentMonster}"
    end

  end # Napakalaki

end # NapakalakiGame
