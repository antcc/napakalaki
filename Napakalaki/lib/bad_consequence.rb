# encoding: utf-8

require_relative 'player'

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
    
    # devuelve la constante que simboliza todos los tesoros
    def self.getMaxTreasures
      @@MAXTREASURES
    end

    def getLevels
      @levels
    end

    def substractVisibleTreasure(t)
      type = t.type
      if (not @specificVisibleTreasures.nil?) and (not @specificVisibleTreasures.empty?) \
            and @specificVisibleTreasures.include?(type)
        @specificVisibleTreasures.delete_at(@specificVisibleTreasures.index(type))
      else
        if (@nVisibleTreasures > 0)
          @nVisibleTreasures -= 1
        end
      end
    end
    
    def substractHiddenTreasure(t)
      type = t.type
      if (not @specificHiddenTreasures.nil?) and (not @specificHiddenTreasures.empty?) \
            and @specificHiddenTreasures.include?(type)
        @specificHiddenTreasures.delete_at(@specificHiddenTreasures.index(type))
      else
        if @nHiddenTreasures > 0
          @nHiddenTreasures -= 1
        end
      end
    end

    # constructor para tesoros generales
    def self.newLevelNumberOfTreasures(t, l, nVisible, nHidden)
      new(t, l, nVisible, nHidden, nil, nil, false)
    end

    # constructor para tesoros específicos
    def self.newLevelSpecificTreasures(t, l, v, h)
      new(t, l, nil, nil, v, h, false)
    end

    # constructor para mal rollo de muerte
    def self.newDeath(t)
      new(t, Player.getMaxLevel, @@MAXTREASURES, @@MAXTREASURES, nil, nil, true);
    end

    def adjustToFitTreasureLists(v, h)
      if @nVisibleTreasures.nil? and @nHiddenTreasures.nil?

        # El array que nos pasan es de tesoros pero lo necesitamos de TIPOS de tesoros
        vTypes = []
        v.each do |t|
          vTypes << t.type
        end
        
        newSpecificVisibleTreasures = @specificVisibleTreasures & vTypes
        if @specificVisibleTreasures.count(TreasureKind::ONEHAND) == 2 and \
           vTypes.count(TreasureKind::ONEHAND) >= 2
          newSpecificVisibleTreasures << TreasureKind::ONEHAND
        end

        # Igual que antes, necesitamos los TIPOS de los tesoros
        hTypes = []
        h.each do |t|
          hTypes << t.type
        end
        
        # Intersección, manteniendo duplicados (flat_map concatena)
        newSpecificHiddenTreasures = (@specificHiddenTreasures & hTypes).flat_map { |n| [n]*[@specificHiddenTreasures.count(n), hTypes.count(n)].min }

        bc = BadConsequence::newLevelSpecificTreasures(@text, @levels, newSpecificVisibleTreasures, newSpecificHiddenTreasures)
      else
        newNVisibleTreasures = [@nVisibleTreasures, v.count].min
        newNHiddenTreasures = [@nHiddenTreasures, h.count].min
        bc = BadConsequence::newLevelNumberOfTreasures(@text, @levels, newNVisibleTreasures, newNHiddenTreasures)
      end
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
                                                   "TODOS LOS TESOROS"
                                                 else
                                                   "#{@nVisibleTreasures}"
                                                 end
      text << "\nTesoros ocultos perdidos: " << if @nHiddenTreasures == @@MAXTREASURES
                                                  "TODOS LOS TESOROS"
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
