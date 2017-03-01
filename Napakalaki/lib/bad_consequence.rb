# encoding: utf-8

# class BadConsequence: representa el mal rollo de un monstruo
class BadConsequence
  attr_reader :text                      # texto del mal rollo
  attr_reader :levels                    # niveles perdidos
  attr_reader :nVisibleTreasures         # tesoros visibles perdidos
  attr_reader :nHiddenTreasures          # tesoros ocultos perdidos
  attr_reader :death                     # representa si el jugador muere
  attr_reader :specificVisibleTreasures  # tesoros visibles específicos
  attr_reader :specificHiddenTreasures   # teosoros ocultos específicos
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures,
      someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    # siguiente sesión
  end
  
  def to_s
    text = "Mal rollo: #{@text}"
    text << "\nTesoros visibles perdidos: #{@nVisibleTreasures}"
    text << "\nTesoros ocultos perdidos: #{@nHiddenTreasures}"
    text << "\nTesoros específicos visibles perdidos: \
            #{@specificVisibleTreasures}"
    text << "\n Tesoros específicos ocultos perdidos: \
            #{@specificHiddenTreasures}"
  end
end
