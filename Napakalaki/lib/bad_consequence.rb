# encoding: utf-8

module NapakalakiGame

  # class BadConsequence: representa el mal rollo de un monstruo
  class BadConsequence

    def initialize(t, l)
      @text = t
      @levels = l
    end
    
    def getLevels
      @levels
    end
    
    def to_s
      text = "    * Texto: #{@text}"
      text << "\n    * Niveles perdidos: #{@levels}"
    end

  end # BadConsequence
  
end # NapakalakiGame
