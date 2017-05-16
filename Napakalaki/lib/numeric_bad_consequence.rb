# encoding: utf-8

require_relative 'bad_consequence'

module NapakalakiGame

  # class NumericBadConsequence: representa un mal rollo de número de tesoros
  class NumericBadConsequence < BadConsequence
    def initialize(t, l, v, h)
      super(t, l)
      @nVisibleTreasures = v
      @nHiddenTreasures = h
    end

    def getNVisibleTreasures
      @nVisibleTreasures
    end

    def getNHiddenTreasures
      @nHiddenTreasures
    end

    def isEmpty
      @nVisibleTreasures == 0 and @nHiddenTreasures == 0
    end

    def substractVisibleTreasure(t)
      if (@nVisibleTreasures > 0)
          @nVisibleTreasures -= 1
      end 
    end
    
    def substractHiddenTreasure(t)
      if @nHiddenTreasures > 0
          @nHiddenTreasures -= 1
      end
    end

    def adjustToFitTreasureLists(v,h)
      newNVisibleTreasures = [@nVisibleTreasures, v.count].min
      newNHiddenTreasures = [@nHiddenTreasures, h.count].min
      NumericBadConsequence.new(@text, @levels, newNVisibleTreasures, newNHiddenTreasures)
    end

    def to_s
      text = super
      text << "\n    * Tesoros visibles perdidos: " << if @nVisibleTreasures == @@MAXTREASURES
                                                   "TODOS LOS TESOROS"
                                                 else
                                                   "#{@nVisibleTreasures}"
                                                 end
      text << "\n    * Tesoros ocultos perdidos: " << if @nHiddenTreasures == @@MAXTREASURES
                                                  "TODOS LOS TESOROS"
                                                else
                                                  "#{@nHiddenTreasures}"
                                                end
    end

  end
  
end
