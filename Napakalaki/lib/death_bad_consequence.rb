# encoding: utf-8

require_relative 'player'
require_relative 'numeric_bad_consequence'

module NapakalakiGame

  # class DeathBadConsequence: representa un mal rollo de muerte
  class DeathBadConsequence < NumericBadConsequence
    def initialize(t)
      super(t, Player.getMaxLevel, @@MAXTREASURES, @@MAXTREASURES)
    end
    
  end
  
end
