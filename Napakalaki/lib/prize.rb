#encoding: utf-8

# class Prize: representa la recompensa obtenida al derrotar a un monstruo
class Prize
  attr_reader :treasures
  attr_reader :levels
  
  def initialize(t, l)
    @treasures = t
    @levels = l
  end
  
  def to_s
    "Tesoros ganados: #{@treasures} \nNiveles ganados: #{@levels}"
  end
  
end
