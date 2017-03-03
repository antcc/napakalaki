# encoding: utf-8

# class BadConsequence: representa el mal rollo de un monstruo
class BadConsequence
  attr_reader :text                      # texto del mal rollo
  attr_reader :levels                    # niveles perdidos
  attr_reader :nVisibleTreasures         # tesoros visibles perdidos
  attr_reader :nHiddenTreasures          # tesoros ocultos perdidos
  attr_reader :specificVisibleTreasures  # tesoros visibles específicos
  attr_reader :specificHiddenTreasures   # teosoros ocultos específicos
  attr_reader :death                     # representa si el jugador muere
  
  ALL_TREASURES = 20   # simboliza todos los tesoros
  
  private def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures,
      someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @specificVisibleTreasures = someSpecificVisibleTreasures
    @specificHiddenTreasures = someSpecificHiddenTreasures
    @death = death
  end
  
  def self.newLevelNumberOfTreasures(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
    self.new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, nil, nil, false)
  end
  
  def self.newLevelSpecificTreasures(aText, someLevels,
      someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    self.new(aText, someLevels, nil, nil, someSpecificVisibleTreasures,
        someSpecificHiddenTreasures, false)
  end
  
  def self.newDeath(aText)
    self.new(aText, 0, nil, nil, nil, nil, true)
  end
  
  def to_s
    text = "Texto: #{@text}"
    text << "\nMuerte: " << if @death 
                            "SI" 
                          else
                            "NO"
                          end
    text << "\nNiveles perdidos: #{@levels}"
    text << "\nTesoros visibles perdidos: " << if @nVisibleTreasures == ALL_TREASURES
                                                 "Todos los tesoros"
                                               else
                                                 "#{@nVisibleTreasures}"
                                               end
    text << "\nTesoros ocultos perdidos: " << if @nHiddenTreasures == ALL_TREASURES
                                                 "Todos los tesoros"
                                               else
                                                 "#{@nHiddenTreasures}"
                                               end
    text << "\nTesoros específicos visibles perdidos: \
            #{@specificVisibleTreasures.to_s}"
    text << "\nTesoros específicos ocultos perdidos: \
            #{@specificHiddenTreasures.to_s}"
  end
end
