# encoding: utf-8

require_relative 'player'

module NapakalakiGame
  
  class CultistPlayer < Player
    @@totalCultistPlayers = 0

    def initialize(p, c)
      copy_const(p)
      @myCultistCard = c
      
      @@totalCultistPlayers += 1
    end

    protected

    # El nivel de combate de los jugadores sectarios se obtiene con la fórmula siguiente
    def getCombatLevel
      (1.7 * super + @myCultistCard.getGainedLevels * @@totalCultistPlayers).to_i
    end

    # Algunos monstruos cambian el nivel de combate contra sectarios
    def getOponentLevel(m)
      m.getCombatLevelAgainstCultistPlayer
    end

    def shouldConvert
      false
    end

    def giveMeATreasure
      @visibleTreasures.delete_at(rand(@visibleTreasures.length))
    end

    def canYouGiveMeATreasure
      not @visibleTreasures.empty?
    end

    public

    def self.getTotalCultistPlayers
      @@totalCultistPlayers
    end
    
    def to_s
      super + "\n - Carta de sectario: " + @myCultistCard.to_s
    end

  end # CultistPlayer
  
end # NapakalakiGame
