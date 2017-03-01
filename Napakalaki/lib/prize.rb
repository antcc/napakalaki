#encoding: utf-8

# class Prize: representa la recompensa obtenida al derrotar a un monstruo
class Prize
  attr_reader :treasures
  attr_reader :level
  
  def initialize(treasures, level)
    @treasures = treasures
    @level = level
  end
  
  def to_s
    "Tesoros ganados: #{@treasures} \nNiveles ganados: #{@level}"
  end
end
