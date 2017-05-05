# encoding: utf-8

module NapakalakiGame

  # class Prize: representa el buen rollo de un monstruo
  class Prize
    attr_reader :treasures  # tesoros ganados
    attr_reader :levels     # niveles ganados

    def initialize(t, l)
      @treasures = t
      @levels = l
    end

    def to_s
      "    * Tesoros ganados: #{@treasures} \n    * Niveles ganados: #{@levels}"
    end

  end # Prize

end # NapakalakiGame