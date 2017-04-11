# encoding: utf-8

require 'singleton'

module NapakalakiGame
  
  # class Dice: representa el dado
  class Dice
    include Singleton  # la clase es <<singleton>>

    # devuelve un entero pseudo-aleatorio del intervalo [1,6]
    def nextNumber
      rand(1..6)                 # ruby >= 1.9
      # (rand() * 6 + 1).to_i    # ruby < 1.9
    end

  end # Dice

end # NapakalakiGame
