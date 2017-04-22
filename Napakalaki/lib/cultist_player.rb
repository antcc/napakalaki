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

  # El nivel de combate de los jugadores sectarios se obtiene con la fórmula siguiente
  def getCombatLevel
    (@combatLevel + 0.7*@combatLevel + myCultistCard.getGainedLevels*@@totalCultistPlayers).to_i
  end

  # Algunos monstruos cambian el nivel de combate contra sectarios
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
