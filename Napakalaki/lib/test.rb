# encoding: utf-8

require_relative 'prize'
require_relative 'bad_consequence'
require_relative 'treasure_kind'
require_relative 'monster'

module NapakalakiGame
  
  # class Test: prueba de entrega de proyecto en PRADO
  class Test
    # método de clase
    def self.testClase
      # Byakhees de bonanza
      prize = Prize.new(2,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible ' \
          'y otra oculta.', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
      monster = Monster.new('Byakhees de bonanza', 8, prize, badConsequence)
      puts monster
    end

    # método de instancia
    def testInstancia
      # Byakhees de bonanza
      prize = Prize.new(2,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible ' \
          'y otra oculta.', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
      monster = Monster.new('Byakhees de bonanza', 8, prize, badConsequence)
      puts monster
    end

  end # Test
  
end # NapakalakiGame
