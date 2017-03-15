#encoding: utf-8

# class Monster: representa un monstruo
class Monster
  attr_reader :name             # nombre del monstruo
  attr_reader :combatLevel      # nivel del monstruo
  attr_reader :badConsequence  # mal rollo
  
  def initialize(n, l, b, p)
    @name = n
    @combatLevel = l
    @badConsequence = b
    @prize = p
  end
  
  def getLevelsGained
    @prize.levels
  end
  
  def getTreasuresGained
    @prize.treasures
  end
  
  def to_s
    "Nombre: #{@name} \nNivel: #{@combatLevel} \n" + \
    "Mal rollo:\n" + @badConsequence.to_s + "\nRecompensa:\n" + @prize.to_s
  end
  
end
