# encoding: utf-8

require_relative 'treasure_kind'
require_relative 'bad_consequence'

module NapakalakiGame

  # class SpecificBadConsequence: representa un mal rollo de tesoros específicos
  class SpecificBadConsequence < BadConsequence
    def initialize(t, l, v, h)
      super(t, l)
      @specificVisibleTreasures = v
      @specificHiddenTreasures = h
    end

    def getSpecificVisibleTreasures
      @specificVisibleTreasures
    end

    def getNHiddenTreasures
      @specificHiddenTreasures
    end

    def isEmpty
      @specificVisibleTreasures == [] and @specificHiddenTreasures == []
    end

    def substractVisibleTreasure(t)
      type = t.type
      if (not @specificVisibleTreasures.empty?) \
            and @specificVisibleTreasures.include?(type)
        @specificVisibleTreasures.delete_at(@specificVisibleTreasures.index(type))
      end
    end
    
    def substractHiddenTreasure(t)
      type = t.type
      if (not @specificHiddenTreasures.empty?) \
            and @specificHiddenTreasures.include?(type)
        @specificHiddenTreasures.delete_at(@specificHiddenTreasures.index(type))
      end
    end

    def adjustToFitTreasureLists(v,h)
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

      SpecificBadConsequence.new(@text, @levels, newSpecificVisibleTreasures, newSpecificHiddenTreasures)
    end

    def to_s
      text = super
      text << "\n    * Tesoros específicos visibles perdidos: \
              #{@specificVisibleTreasures}"
      text << "\n    * Tesoros específicos ocultos perdidos: \
              #{@specificHiddenTreasures}"
    end

  end
  
end