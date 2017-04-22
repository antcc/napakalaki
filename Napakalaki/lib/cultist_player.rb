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
  end

  def getOponentLevel
  end

  def shouldConvert
  end

  private

  def giveMeATreasure
  end

  def canYouGiveMeATreasure
  end

  public

  def getTotalCultistPlayers
  end
  
end
