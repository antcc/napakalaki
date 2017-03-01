# encoding: utf-8

# class Monster: representa un monstruo
class Monster
  attr_reader :name             # nombre del monstruo
  attr_reader :combatLevel      # nivel del monstruo
  attr_reader :bad_consequence  # mal rollo
  attr_reader :prize            # recompensa
  
  def initialize(name, level, bc, prize)
    @name = name
    @combatLevel = level
    @bad_consequence = bc
    @prize = prize
  end
  
  def to_s
    "Nombre: #{@name} \nNivel: #{@combatLevel} \n" + \
    @bad_consequence.to_s + @prize.to_s
  end
end
