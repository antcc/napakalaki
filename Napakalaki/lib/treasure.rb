#encoding: utf-8

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
  
end
