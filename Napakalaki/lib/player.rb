#encoding: utf-8

require_relative 'card_dealer'
require_relative 'dice'
require_relative 'combat_result'

module NapakalakiGame
  
  #class Player: representa un jugador
  class Player
    attr_reader :name
    attr_reader :level
    attr_reader :hiddenTreasures
    attr_reader :visibleTreasures
    attr_reader :canISteal
    attr_writer :pendingBadConsequence
    attr_writer :enemy

    @@MAXLEVEL = 10

    def initialize(name)
      @name = name
      @level = 1
      @hiddenTreasures = Array.new
      @visibleTreasures = Array.new
      @canISteal = true
      @pendingBadConsequence = nil
      @enemy = nil
      @dead = true
    end

    private
    def bringToLife
      @dead = false
    end

    def getCombatLevel
      combatLevel = level
      @visibleTreasures.each { |vt| combatLevel += vt.bonus }
    end

    def self.getMaxLevel
      @@MAXLEVEL
    end

    def incrementLevels(l)
      @level += l
    end

    def decrementLevels(l)
      if @level - l < 1
        @level = 1
      else
        @level -= l
      end
    end

    def applyPrize(m)

    end

    def applyBadConsequence(m)

    end

    def canMakeTreasureVisible(t)

    end

    def howManyVisibleTreasures(tKind)
      count = 0
      @visibleTreasures.each do |vt|
        if vt == tkind
          count += 1
        end
      end
    end

    def dieIfNoTreasures
      if @visibleTreasures.empty? and @hiddenTreasures.empty?
        @dead = true
      end
    end

    public
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

    # Por ahora no hemos implementado los sectarios, por lo que solo consideramos tesoros ocultos.
    # TODO: revisar cuando implementemos sectarios
    def canYouGiveMeATreasure
      not @hiddenTreasures.empty?
    end

    def haveStolen
      @canISteal = false
    end

    public
    def discardAllTreasures

    end

  end # Player

end # NapakalakiGame
