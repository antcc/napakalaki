# encoding: utf-8

# class Monster: representa un monstruo
class Monster
  attr_reader :name             # nombre del monstruo
  attr_reader :combatLevel      # nivel del monstruo
  attr_reader :prize            # recompensa
  attr_reader :bad_consequence  # mal rollo
  
  def initialize(name, level, prize, bc)
    @name = name
    @combatLevel = level
    @prize = prize
    @bad_consequence = bc
  end
  
  def to_s
    "Nombre: #{@name} \nNivel: #{@combatLevel} \n" + \
    "Mal rollo:\n" + @bad_consequence.to_s + "\nRecompensa:\n" + @prize.to_s
  end
end
