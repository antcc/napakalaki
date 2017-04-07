# encoding: utf-8

module NapakalakiGame

  # class BadConsequence: representa el mal rollo de un monstruo
  class BadConsequence
    attr_reader :levels                    # niveles perdidos
    attr_reader :nVisibleTreasures         # tesoros visibles perdidos
    attr_reader :nHiddenTreasures          # tesoros ocultos perdidos
    attr_reader :specificVisibleTreasures  # tesoros visibles específicos perdidos
    attr_reader :specificHiddenTreasures   # teosoros ocultos específicos perdidos

    @@MAXTREASURES = 10                    # simboliza todos los tesoros

    def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures,
        someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
      @text = aText
      @levels = someLevels
      @nVisibleTreasures = someVisibleTreasures
      @nHiddenTreasures = someHiddenTreasures
      @specificVisibleTreasures = someSpecificVisibleTreasures
      @specificHiddenTreasures = someSpecificHiddenTreasures
      @death = death
    end

    # establecemos 'new' como método privado
    private_class_method :new

    # comprueba si el mal rollo no implica pérdida de tesoros
    def isEmpty
      # aprovechamos que nil == obj es false salvo que obj = nil, y la forma en la
      # que inicializamos instancias de BadConsequence.
      (nVisibleTreasures == 0 and nHiddenTreasures == 0) or
        (specificVisibleTreasures == [] and specificHiddenTreasures == [])
    end

    def substractVisibleTreasure(t)
      if specificVisibleTreasures != nil
        specificVisibleTreasures.delete(t)
      else
        nVisibleTreasures -= 1 unless nVisibleTreasures < 1
      end
    end

    # devuelve la constante que simboliza todos los tesoros
    def self.getMaxTreasures
      @@MAXTREASURES
    end

    def substractHiddenTreasure(t)
      if specificHiddenTreasures != nil
        specificHiddenTreasures.delete(t)
      else
        nHiddenTreasures -= 1 unless nHiddenTreasures < 1
      end
    end

    # constructor para tesoros generales
    def self.newLevelNumberOfTreasures(t, l, nVisible, nHidden)
      new(t, l, nVisible, nHidden, nil, nil, false)
    end

    # constructor para tesoros específicos
    def self.newLevelSpecificTreasures(t,l,v,h)
      new(t, l, nil, nil, v, h, false)
    end

    # constructor para mal rollo de muerte
    def self.newDeath(t)
      new(t, 0, nil, nil, nil, nil, true);
    end

    def adjustToFitTreasureLists(v,h)

    end

    def to_s
      text = "Texto: #{@text}"
      text << "\nMuerte: " << if @death 
                                "SI" 
                              else
                                "NO"
                              end
      text << "\nNiveles perdidos: #{@levels}"
      text << "\nTesoros visibles perdidos: " << if @nVisibleTreasures == @@MAXTREASURES
                                                   "Todos los tesoros"
                                                 else
                                                   "#{@nVisibleTreasures}"
                                                 end
      text << "\nTesoros ocultos perdidos: " << if @nHiddenTreasures == @@MAXTREASURES
                                                  "Todos los tesoros"
                                                else
                                                  "#{@nHiddenTreasures}"
                                                end
      text << "\nTesoros específicos visibles perdidos: \
              #{@specificVisibleTreasures}"
      text << "\nTesoros específicos ocultos perdidos: \
              #{@specificHiddenTreasures}"
    end

  end # BadConsequence
  
end # NapakalakiGame
