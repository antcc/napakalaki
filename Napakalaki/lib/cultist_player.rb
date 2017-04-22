# encoding: utf-8

require_relative 'player'

class CultistPlayer < Player

  @@totalCultistPlayers = 0
  
  def initialize(p, c)
    super(p.name)

    copy_const(p)

    @@totalCultistPlayers += 1
    @myCultistCard = c
  end

  protected

  def getCombatLevel
    (@combatLevel + 0.7*@combatLevel + myCultistCard.getGainedLevels*@@totalCultistPlayers).to_i
  end

  def getOponentLevel(m)
    m.getCombatLevelAgainstCultistPlayer
  end

  def shouldConvert
    false
  end

  private

  def giveMeATreasure
    @visibleTreasures.delete_at(rand(@hiddenTreasures.length))
  end

  def canYouGiveMeATreasure
    not @visibleTreasures.empty?
  end

  public

  def getTotalCultistPlayers
    @@totalCultistPlayers
  end
  
end
