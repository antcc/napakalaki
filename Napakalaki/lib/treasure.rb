# encoding: utf-8

module NapakalakiGame
 
  # class Treasure: representa un tesoro
  class Treasure
    attr_reader :name   # nombre del tesoro
    attr_reader :bonus  # bonus del tesoro
    attr_reader :type   # tipo del tesoro

    def initialize(n, bonus, t)
      @name = n
      @bonus = bonus
      @type = t
    end
    
    def to_s
      "Nombre: #{@name} \nBonus: #{@bonus} \nTipo: #{@type}"
    end

  end # Treasure

end # NapakalakiGame