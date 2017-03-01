#encoding: utf-8

require_relative 'treasure_kind'
require_relative 'prize'
require_relative 'monster'
require_relative 'bad_consequence'

# class PruebaNapakalaki: programa de prueba
class PruebaNapakalaki 
  
  # ---- Primera prueba ----
 
  # Listar los tipos de tesoros
  #puts "Tipos de tesoros: "
  #TreasureKind.constants.each do |tesoro|
  #  puts "#{TreasureKind.const_get(tesoro)}"
  #end
  #puts
  
  # Construir dos monstruos
  #prize1 = Prize::new(2,1)
  #prize2 = Prize::new(1,1)
  #monster1 = Monster::new("Pollipólipo volante", 3, nil, prize1)
  #monster2 = Monster::new("El espía sordo", 5, nil, prize2)
  
  # Acceder a algunos miembros
  #print "Niveles ganados en la recompensa 1: "
  #puts prize1.level
  #puts
  #puts "Recompensa del monstruo 2: "
  #puts monster2.prize
  
  # Imprimir los monstruos
  #puts "\nMonstruo 1."
  #puts monster1.to_s
  #puts "\nMonstruo 2."
  #puts monster2.to_s
  
  ### Listado de monstruos
  
  @@monsters = Array.new
  
  # Byakhees de bonanza
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible ' \
      'y otra oculta.', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
  @@monsters<< Monster.new('Byakhees de bonanza', 8, prize, badConsequence)
  
  # Tenochtitlan
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures('Embobados con el lindo ' \
      'primigenio te descartas de tu casco visible.', 0, [TreasureKind::HELMET], [])
  @@monsters<< Monster.new('Tenochtitlan', 2, prize, badConsequence)
  
  # El sopor de Dunwich
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures('El primordial bostezo ' \
      'contagioso. Pierdes el calzado visible.', 0, [TreasureKind::SHOES], [])
  @@monsters<< Monster.new('El sopor de Dunwich', 2, prize, badConsequence)
  
  # Demonios de Magaluf
  prize = Prize.new(4,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures('Te atrapan para llevarte ' \
      'de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.',
      0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
  @@monsters<< Monster.new('Demonios de Magaluf', 2, prize, badConsequence)
  
  # El gorrón en el umbral
  prize = Prize.new(3,1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes todos tus tesoros visibles.',
      0, BadConsequence::ALL_TREASURES, 0)
  @@monsters<< Monster.new('El gorrón en el umbral', 13, prize, badConsequence)
  
  # H.P Munchcraft
  prize = Prize.new(2,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes la armadura visible.',
    0, [TreasureKind::ARMOR], [])
  @@monsters<< Monster.new('H.P Munchcraft', 6, prize, badConsequence)
  
  # Necrófago
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelSpecificTreasures('Sientes bichos bajo la ' \
      'ropa. Descarta la armadura visible.', 0, [TreasureKind::ARMOR], 0)
  @@monsters<< Monster.new('Necrófago', 13, prize, badConsequence)
  
  # El rey de rosado
  prize = Prize.new(3,2)
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 ' \
      'tesoros visibles.', 5 , 3, 0)
  @@monsters << Monster.new('El rey de rosado', 11, prize, badConsequence)
  
  # Flecher
  prize = Prize.new(1,1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Toses los pulmones y ' \
      'pierdes 2 niveles.', 2 , 0, 0)
  @@monsters << Monster.new('Flecher', 2, prize, badConsequence)
 
  ### Métodos de clase
  
  def self.level_higher_than_10
    monsters_high_level = []
    @@monsters.each { |monster| monsters_high_level << monster unless monster.combatLevel <= 10 }
    monsters_high_level
  end
  
  # Nota: los monstruos que solo impliquen pérdida de nivel se definen con el constructor
  # newLevelNumberOfTreasures
  def self.bad_consequence_only_levels
    monsters_only_level = []
    @@monsters.each do |monster| 
      if monster.bad_consequence.nVisibleTreasures == 0 and \
            monster.bad_consequence.nHiddenTreasures == 0
        monsters_only_level << monster 
      end
    end
    monsters_only_level
  end
  
  
  # ---- Segunda prueba ----
  
  puts self.level_higher_than_10.each { |monster| puts monster.to_s}
  puts
  puts self.bad_consequence_only_levels.each { |monster| puts monster.to_s}

end

