#encoding: utf-8

require_relative 'combat_result'

# class Napakalaki: representa una instancia del juego
class Napakalaki
  include Singleton
  
  attr_reader :currentMonster
  attr_reader :currentPlayer
  
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
  
end
