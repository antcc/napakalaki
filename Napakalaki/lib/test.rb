#encoding: utf-8

# class Test: prueba de entrega de proyecto en PRADO
class Test
  def initialize
    
  end
  
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
end
