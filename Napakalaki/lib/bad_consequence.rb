# encoding: utf-8

# class BadConsequence: representa el mal rollo de un monstruo
class BadConsequence
  attr_reader :levels                    # niveles perdidos
  attr_reader :nVisibleTreasures         # tesoros visibles perdidos
  attr_reader :nHiddenTreasures          # tesoros ocultos perdidos
  attr_reader :specificVisibleTreasures  # tesoros visibles específicos
  attr_reader :specificHiddenTreasures   # teosoros ocultos específicos
  
  MAXTREASURES = 10   # simboliza todos los tesoros
  
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
  
  private_class_method :new
  
  def self.newLevelNumberOfTreasures(t, l, nVisible, nHidden)
    new(t, l, nVisible, nHidden, nil, nil, false)
  end
  
  def self.newLevelSpecificTreasures(t,l,v,h)
    new(t, l, nil, nil, v, h, false)
  end
  
  def self.newDeath(t)
    new(t, 0, nil, nil, nil, nil, true)
  end
  
  def isEmpty
    
  end
  
  def substractVisibleTreasure(t)
    
  end
  
  def substractHiddenTreasure(t)
    
  end
  
  def adjustToFitTreasureLists(v,h)
  
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
