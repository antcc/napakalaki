# encoding: utf-8

require_relative 'treasure_kind'
require_relative 'prize'
require_relative 'monster'
require_relative 'bad_consequence'
require_relative 'test'

module NapakalakiGame

  # class PruebaNapakalaki: programa de prueba
  class PruebaNapakalaki 
    def initialize
      @@monsters = Array.new

      # Byakhees de bonanza
      prize = Prize.new(2,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible ' \
          'y otra oculta.', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
      @@monsters << Monster.new('Byakhees de bonanza', 8, badConsequence, prize)

      # Tenochtitlan
      prize = Prize.new(1,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Embobados con el lindo ' \
          'primigenio te descartas de tu casco visible.', 0, [TreasureKind::HELMET], [])
      @@monsters << Monster.new('Tenochtitlan', 2, badConsequence, prize)

      # El sopor de Dunwich
      prize = Prize.new(1,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('El primordial bostezo ' \
          'contagioso. Pierdes el calzado visible.', 0, [TreasureKind::SHOE], [])
      @@monsters << Monster.new('El sopor de Dunwich', 2, badConsequence, prize)

      # Demonios de Magaluf
      prize = Prize.new(4,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Te atrapan para llevarte ' \
          'de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.',
          0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
      @@monsters << Monster.new('Demonios de Magaluf', 2, badConsequence, prize)

      # El gorrón en el umbral
      prize = Prize.new(3,1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes todos tus tesoros visibles.',
          0, BadConsequence.getMaxTreasures, 0)
      @@monsters << Monster.new('El gorrón en el umbral', 13, badConsequence, prize)

      # H.P Munchcraft
      prize = Prize.new(2,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes la armadura visible.',
        0, [TreasureKind::ARMOR], [])
      @@monsters << Monster.new('H.P Munchcraft', 6, badConsequence, prize)

      # Necrófago
      prize = Prize.new(1,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Sientes bichos bajo la ' \
          'ropa. Descarta la armadura visible.', 0, [TreasureKind::ARMOR], [])
      @@monsters << Monster.new('Necrófago', 13, badConsequence, prize)

      # El rey de rosado
      prize = Prize.new(3,2)
      badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 ' \
          'tesoros visibles.', 5 , 3, 0)
      @@monsters << Monster.new('El rey de rosado', 11, badConsequence, prize)

      # Flecher
      prize = Prize.new(1,1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures('Toses los pulmones y ' \
          'pierdes 2 niveles.', 2 , 0, 0)
      @@monsters << Monster.new('Flecher', 2, badConsequence, prize)

      # Los hondos
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newDeath('Estos monstruos resultan bastante superficiales ' \
          'y te aburren mortalmente. Estás muerto.', true)
      @@monsters << Monster.new('Los hondos', 8, badConsequence, prize)

      # Semillas Cthulhu
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 2 niveles y 2 tesoros ' \
          'ocultos.', 2, 0, 2)
      @@monsters << Monster.new('Semillas Cthulhu', 4, badConsequence, prize)

      # Dameargo
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Te intentas escaquear. ' \
          'Pierdes una mano visible.', 0, [TreasureKind::ONEHAND], [])
      @@monsters << Monster.new('Dameargo', 1, badConsequence, prize)

      # Pollipólipo volante
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures('Da mucho asquito. Pierdes ' \
        '3 niveles.', 3, 0, 0)
      @@monsters << Monster.new('Pollipólipo volante', 3, badConsequence, prize)

      # Yskhtihyssg-Goth
      prize = Prize.new(3, 1)
      badConsequence = BadConsequence.newDeath('No le hace gracia que pronuncien mal su nombre. ' \
          'Estás muerto.', true)
      @@monsters << Monster.new('Yskhtihyssg-Goth', 14, badConsequence, prize)

      # Familia feliz
      prize = Prize.new(3, 1)
      badConsequence = BadConsequence.newDeath('La familia te atrapa. Estás muerto.', true)
      @@monsters << Monster.new('Familia feliz', 1, badConsequence, prize)

      # Roboggoth
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('La quinta directiva primaria te ' \
          'obliga a perder 2 niveles y un tesoro de 2 manos visible.', 2, [TreasureKind::BOTHHANDS], [])
      @@monsters << Monster.new('Roboggoth', 8, badConsequence, prize)

      # El espía sordo
      prize = Prize.new(1, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Te asusta en la noche. Pierdes ' \
          'un casco visible.', 0, [TreasureKind::HELMET], [])
      @@monsters << Monster.new('El espia sordo', 5, badConsequence, prize)

      # Tongue
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures('Menudo susto te llevas. Pierdes ' \
          '2 niveles y 5 tesoros visibles.', 2, 5, 0)
      @@monsters << Monster.new('Tongue', 19, badConsequence, prize)

      # Bicéfalo
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Te faltan manos para tanta ' \
          'cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.', 3,
          [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS], [])
      @@monsters << Monster.new('Bicéfalo', 21, badConsequence, prize)
    end

    def self.print_monsters(some_monsters)
      some_monsters.each do |m| 
        puts m 
        puts
      end
    end

    def self.level_higher_than_ten
      @@monsters.select { |monster| monster.combatLevel > 10 }
    end

    def self.bad_consequence_only_levels
      @@monsters.select do |monster| 
        (monster.badConsequence.nVisibleTreasures == 0 and
        monster.badConsequence.nHiddenTreasures == 0) or
        (monster.badConsequence.specificHiddenTreasures == [] and
        monster.badConsequence.specificVisibleTreasures == [])
      end  
    end

    def self.prize_level_higher_than_one
      @@monsters.select { |monster| monster.getLevelsGained > 1 }
    end

    def self.bad_consequence_specific_treasure(treasure)
      @@monsters.select do |monster|
        (not monster.badConsequence.specificVisibleTreasures.nil? and
        monster.badConsequence.specificVisibleTreasures.include?(treasure)) or
        (not monster.badConsequence.specificHiddenTreasures.nil? and
        monster.badConsequence.specificHiddenTreasures.include?(treasure))
      end
    end
    
=begin
    # ---- Primera prueba ----

    # Listar los tipos de tesoros
    puts "Tipos de tesoros: "
    TreasureKind.constants.each do |tesoro|
      puts "#{TreasureKind.const_get(tesoro)}"
    end
    puts

    # Construir dos monstruos
    prize1 = Prize::new(2,1)
    prize2 = Prize::new(1,1)
    monster1 = Monster::new("Pollipólipo volante", 3, nil, prize1)
    monster2 = Monster::new("El espía sordo", 5, nil, prize2)

    # Acceder a algunos miembros
    print "Niveles ganados en la recompensa 1: "
    puts prize1.level
    puts
    puts "Recompensa del monstruo 2: "
    puts monster2.prize

    # Imprimir los monstruos
    puts "\nMonstruo 1."
    puts monster1.to_s
    puts "\nMonstruo 2."
    puts monster2.to_s
=end
    
    # ---- Segunda prueba ----

    puts "PRUEBA DE LOS MÉTODOS DE LA PRÁCTICA 1\n\n"
    PruebaNapakalaki.new
    puts "--- Monstruos con nivel mayor que 10 ---\n\n"
    print_monsters(level_higher_than_ten)
    puts "--- Monstruos cuyo mal rollo solo te hace perder niveles ---\n\n"
    print_monsters(bad_consequence_only_levels)
    puts "--- Monstruos cuyo buen rollo te da más de un nivel ---\n\n"
    print_monsters(prize_level_higher_than_one)
    puts "--- Monstruos cuyo mal rollo te hace perder tesoros de una mano ---\n\n"
    print_monsters(bad_consequence_specific_treasure(TreasureKind::ONEHAND))
    puts "--- Monstruos cuyo mal rollo te hace perder tesoros de dos manos ---\n\n"
    print_monsters(bad_consequence_specific_treasure(TreasureKind::BOTHHANDS))
    puts "--- Monstruos cuyo mal rollo te hace perder tesoros de armadura ---\n\n"
    print_monsters(bad_consequence_specific_treasure(TreasureKind::ARMOR))
    puts "--- Monstruos cuyo mal rollo te hace perder tesoros de calzado ---\n\n"
    print_monsters(bad_consequence_specific_treasure(TreasureKind::SHOE))
    puts "--- Monstruos cuyo mal rollo te hace perder tesoros de casco ---\n\n"
    print_monsters(bad_consequence_specific_treasure(TreasureKind::HELMET))

=begin  
    # --- Tercera prueba (PRADO) ---

    puts "\nPRUEBA DE ENTREGA DEL PROYECTO EN PRADO\n\n"
    puts "--- Método de clase ---\n\n"
    Test.testClase
    puts "\n---Método de instancia ---\n\n"
    test = Test.new
    test.testInstancia
=end

  end # PruebaNapakalaki
  
end # NapakalakiGame