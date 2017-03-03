#encoding: utf-8

require_relative 'treasure_kind'
require_relative 'prize'
require_relative 'monster'
require_relative 'bad_consequence'

# class PruebaNapakalaki: programa de prueba
class PruebaNapakalaki 
  
  def initialize
    @@monsters = Array.new

    # Byakhees de bonanza
    prize = Prize.new(2,1)
    badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible ' \
        'y otra oculta.', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
    @@monsters << Monster.new('Byakhees de bonanza', 8, prize, badConsequence)

    # Tenochtitlan
    prize = Prize.new(1,1)
    badConsequence = BadConsequence.newLevelSpecificTreasures('Embobados con el lindo ' \
        'primigenio te descartas de tu casco visible.', 0, [TreasureKind::HELMET], [])
    @@monsters << Monster.new('Tenochtitlan', 2, prize, badConsequence)

    # El sopor de Dunwich
    prize = Prize.new(1,1)
    badConsequence = BadConsequence.newLevelSpecificTreasures('El primordial bostezo ' \
        'contagioso. Pierdes el calzado visible.', 0, [TreasureKind::SHOES], [])
    @@monsters << Monster.new('El sopor de Dunwich', 2, prize, badConsequence)

    # Demonios de Magaluf
    prize = Prize.new(4,1)
    badConsequence = BadConsequence.newLevelSpecificTreasures('Te atrapan para llevarte ' \
        'de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.',
        0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
    @@monsters << Monster.new('Demonios de Magaluf', 2, prize, badConsequence)

    # El gorrón en el umbral
    prize = Prize.new(3,1)
    badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes todos tus tesoros visibles.',
        0, BadConsequence::ALL_TREASURES, 0)
    @@monsters << Monster.new('El gorrón en el umbral', 13, prize, badConsequence)

    # H.P Munchcraft
    prize = Prize.new(2,1)
    badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes la armadura visible.',
      0, [TreasureKind::ARMOR], [])
    @@monsters << Monster.new('H.P Munchcraft', 6, prize, badConsequence)

    # Necrófago
    prize = Prize.new(1,1)
    badConsequence = BadConsequence.newLevelSpecificTreasures('Sientes bichos bajo la ' \
        'ropa. Descarta la armadura visible.', 0, [TreasureKind::ARMOR], [])
    @@monsters << Monster.new('Necrófago', 13, prize, badConsequence)

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

    # Los hondos
    prize = Prize.new(2, 1)
    badConsequence = BadConsequence.newDeath('Estos monstruos resultan bastante superficiales ' \
        'y te aburren mortalmente. Estás muerto.')
    @@monsters << Monster.new('Los hondos', 8, prize, badConsequence)

    # Semillas Cthulhu
    prize = Prize.new(2, 1)
    badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 2 niveles y 2 tesoros ' \
        'ocultos.', 2, 0, 2)
    @@monsters << Monster.new('Semillas Cthulhu', 4, prize, badConsequence)
    
    # Dameargo
    prize = Prize.new(2, 1)
    badConsequence = BadConsequence.newLevelSpecificTreasures('Te intentas escaquear. ' \
        'Pierdes una mano visible.', 0, [TreasureKind::ONEHAND], [])
    @@monsters << Monster.new('Dameargo', 1, prize, badConsequence)
    
    # Pollipólipo volante
    prize = Prize.new(2, 1)
    badConsequence = BadConsequence.newLevelNumberOfTreasures('Da mucho asquito. Pierdes ' \
      '3 niveles.', 3, 0, 0)
    @@monsters << Monster.new('Pollipólipo volante', 3, prize, badConsequence)
   
    # Yskhtihyssg-Goth
    prize = Prize.new(3, 1)
    badConsequence = BadConsequence.newDeath('No le hace gracia que pronuncien mal su nombre. ' \
        'Estás muerto.')
    @@monsters << Monster.new('Yskhtihyssg-Goth', 14, prize, badConsequence)
    
    # Familia feliz
    prize = Prize.new(3, 1)
    badConsequence = BadConsequence.newDeath('La familia te atrapa. Estás muerto.')
    @@monsters << Monster.new('Familia feliz', 1, prize, badConsequence)
    
    # Roboggoth
    prize = Prize.new(2, 1)
    badConsequence = BadConsequence.newLevelSpecificTreasures('La quinta directiva primaria te ' \
        'obliga a perder 2 niveles y un tesoro de 2 manos visible.', 2, [TreasureKind::BOTHHANDS], [])
    @@monsters << Monster.new('Roboggoth', 8, prize, badConsequence)
    
    # El espía sordo
    prize = Prize.new(1, 1)
    badConsequence = BadConsequence.newLevelSpecificTreasures('Te asusta en la noche. Pierdes ' \
        'un casco visible.', 0, [TreasureKind::HELMET], [])
    @@monsters << Monster.new('El espia sordo', 5, prize, badConsequence)
    
    # Tongue
    prize = Prize.new(2, 1)
    badConsequence = BadConsequence.newLevelNumberOfTreasures('Menudo susto te llevas. Pierdes ' \
        '2 niveles y 5 tesoros visibles.', 2, 5, 0)
    @@monsters << Monster.new('Tongue', 19, prize, badConsequence)
    
    # Bicéfalo
    prize = Prize.new(2, 1)
    badConsequence = BadConsequence.newLevelSpecificTreasures('Te faltan manos para tanta ' \
        'cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.', 3,
        [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS], [])
    @@monsters << Monster.new('Bicéfalo', 21, prize, badConsequence)
  end
   
  def self.print_monsters(some_monsters)
    some_monsters.each { |m| puts m }
  end
  
  def self.level_higher_than_ten
    @@monsters.select { |monster| monster.combatLevel > 10 }
  end
  
  def self.bad_consequence_only_levels
    @@monsters.select do |monster| 
      (monster.bad_consequence.nVisibleTreasures == 0 and
      monster.bad_consequence.nHiddenTreasures == 0) or
      (monster.bad_consequence.specificHiddenTreasures == [] and
      monster.bad_consequence.specificVisibleTreasures == [])
    end  
  end
  
  def self.prize_level_higher_than_one
    @@monsters.select { |monster| monster.prize.level > 1 }
  end
  
  def self.bad_consequence_specific_treasure(treasure)
    @@monsters.select do |monster|
      (not monster.bad_consequence.specificVisibleTreasures.nil? and
      monster.bad_consequence.specificVisibleTreasures.include?(treasure)) or
      (not monster.bad_consequence.specificHiddenTreasures.nil? and
      monster.bad_consequence.specificHiddenTreasures.include?(treasure))
    end
  end
    
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
  
  # ---- Segunda prueba ----
  
  PruebaNapakalaki.new
  self.print_monsters(PruebaNapakalaki.level_higher_than_ten)
  puts
  self.print_monsters(PruebaNapakalaki.bad_consequence_only_levels)
  puts
  self.print_monsters(PruebaNapakalaki.prize_level_higher_than_one)
  puts
  self.print_monsters(self.bad_consequence_specific_treasure(TreasureKind::ONEHAND))
  puts
  self.print_monsters(self.bad_consequence_specific_treasure(TreasureKind::BOTHHANDS))
  puts
  self.print_monsters(self.bad_consequence_specific_treasure(TreasureKind::ARMOR))
  puts
  self.print_monsters(self.bad_consequence_specific_treasure(TreasureKind::SHOES))
  puts
  self.print_monsters(self.bad_consequence_specific_treasure(TreasureKind::HELMET))

end