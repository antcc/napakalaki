#encoding: utf-8

require_relative 'card_dealer'
require_relative 'dice'
require_relative 'combat_result'

#class Player: representa un jugador
class Player
  attr_reader :name
  attr_reader :level
  attr_reader :hiddenTreasures
  attr_reader :visibleTreasures
  attr_writer :pendingBadConsequence
  attr_writer :enemy
  
  def initialize(name)
    
  end
  
  private
  def bringToLife
    
  end
  
  def getCombatLevel
    
  end
  
  def incrementLevels(l)
    
  end
  
  def decrementLevels(l)
    
  end
  
  def applyPrize(m)
    
  end
  
  def applyBadConsequence(m)
    
  end
  
  def canMakeTreasureVisible(t)
    
  end
  
  def howManyVisibleTreasures(tKind)
    
  end
  
  def dieIfNoTreasures
    
  end
  
  public
  def isDead
    
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
    
  end
  
  def initTreasures
    
  end
  
  def stealTreasure
    
  end
  
  private
  def giveMeATreasure
    
  end
  
  public
  def canISteal
    
  end
  
  private
  def canYouGiveMeATreasure
    
  end
  
  def haveStolen
    
  end
  
  public
  def discardAllTreasures
    
  end
  
end
