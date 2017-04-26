# encoding: utf-8

require_relative 'combat_result'
require_relative 'card_dealer'
require_relative 'player'
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

    def getCurrentPlayer
      @currentPlayer
    end

    def getCurrentMonster
      @currentMonster
    end

    private
    
    def initPlayers(names)
      names.each { |n| @players << Player.new(n) }
    end

    def nextPlayer
      num_players = @players.length
      if @currentPlayer.nil? 
        nextP = rand(num_players)
      else
        nextP = (@players.index(@currentPlayer) + 1) % num_players
      end
      @currentPlayer = @players[nextP]
    end

    def nextTurnAllowed
      @currentPlayer.nil? or @currentPlayer.validState
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
      combatResult = @currentPlayer.combat(@currentMonster)

      if combatResult == CombatResult::LOSEANDCONVERT
        c = @dealer.nextCultist
        p = CultistPlayer.new(@currentPlayer, c)
        @players.at(@players.index(@currentPlayer)) = p

        @players.each do |player|
          if player.getEnemy == @currentPlayer
            player.enemy = p
          end
        end
        
        @currentPlayer = p
      end
      
      @dealer.giveMonsterBack(@currentMonster)
      return combatResult
    end

    # @pre: treasures no vacío
    def discardVisibleTreasures(treasures)
      treasures.each do |t|
        @currentPlayer.discardVisibleTreasure(t)
        @dealer.giveTreasureBack(t)
      end
    end

    # @pre: treasures no vacío
    def discardHiddenTreasures(treasures)
      treasures.each do |t|
        @currentPlayer.discardHiddenTreasure(t)
        @dealer.giveTreasureBack(t)
      end
    end

    # @pre: treasures no vacío
    def makeTreasuresVisible(treasures)
      treasures.each do |t|
        @currentPlayer.makeTreasureVisible(t)
      end
    end

    def initGame(players)
      initPlayers(players)
      setEnemies
      @dealer.initCards
      nextTurn
    end

    def nextTurn
      stateOK = nextTurnAllowed
      
      if stateOK
        @currentMonster = @dealer.nextMonster
        @currentPlayer = nextPlayer

        if @currentPlayer.isDead
          @currentPlayer.initTreasures
        end
      end
      
      return stateOK
    end

    def endOfGame(result)
      result == CombatResult::WINGAME
    end
    
    def to_s
      text = "Jugadores: " + @players.map(&:name).join(", ") + "\nJugador actual: "
      
      text << "#{@currentPlayer.name}" unless @currentPlayer.nil?
      text << "\nMonstruo actual: "
      text << "#{@currentMonster.name}" unless @currentMonster.nil?
      text
    end

  end # Napakalaki

end # NapakalakiGame
