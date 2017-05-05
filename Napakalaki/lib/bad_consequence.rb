# encoding: utf-8

require_relative 'player'

module NapakalakiGame

  # class BadConsequence: representa el mal rollo de un monstruo
  class BadConsequence

    @@MAXTREASURES = 10    # simboliza todos los tesoros

    def initialize(t, l)
      @text = t
      @levels = l
    end
    
    # devuelve la constante que simboliza todos los tesoros
    def self.getMaxTreasures
      @@MAXTREASURES
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
