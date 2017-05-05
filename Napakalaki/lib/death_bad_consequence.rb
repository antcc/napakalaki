# encoding: utf-8

require_relative 'player'

module NapakalakiGame

  # class BadConsequence: representa el mal rollo de un monstruo
  class DeathBadConsequence < NumericBadConsequence
    def initialize(t)
      super(t, Player.getMaxLevel, @@MAXTREASURES, @@MAXTREASURES)
    end
  end
end
