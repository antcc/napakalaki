# encoding: utf-8

module NapakalakiGame
  
  # class CardDealer: representa los mazos de cartas
  class CardDealer
    include Singleton  # La clase es <<singleton>>
    
    def initialize
      
    end

    private
    
    def initTreasureCardDeck

    end

    def initMonsterCardDeck
      # Byakhees de bonanza
      prize = Prize.new(2,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible ' \
          'y otra oculta.', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
      @unusedMonsters << Monster.new('Byakhees de bonanza', 8, badConsequence, prize)

      # Tenochtitlan
      prize = Prize.new(1,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Embobados con el lindo ' \
          'primigenio te descartas de tu casco visible.', 0, [TreasureKind::HELMET], [])
      @unusedMonsters << Monster.new('Tenochtitlan', 2, badConsequence, prize)

      # El sopor de Dunwich
      prize = Prize.new(1,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('El primordial bostezo ' \
          'contagioso. Pierdes el calzado visible.', 0, [TreasureKind::SHOE], [])
      @unusedMonsters << Monster.new('El sopor de Dunwich', 2, badConsequence, prize)

      # Demonios de Magaluf
      prize = Prize.new(4,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Te atrapan para llevarte ' \
          'de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.',
          0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
      @unusedMonsters << Monster.new('Demonios de Magaluf', 2, badConsequence, prize)

      # El gorrón en el umbral
      prize = Prize.new(3,1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes todos tus tesoros visibles.',
          0, BadConsequence.getMaxTreasures, 0)
      @unusedMonsters << Monster.new('El gorrón en el umbral', 13, badConsequence, prize)

      # H.P Munchcraft
      prize = Prize.new(2,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes la armadura visible.',
        0, [TreasureKind::ARMOR], [])
      @unusedMonsters << Monster.new('H.P Munchcraft', 6, badConsequence, prize)

      # Necrófago
      prize = Prize.new(1,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Sientes bichos bajo la ' \
          'ropa. Descarta la armadura visible.', 0, [TreasureKind::ARMOR], [])
      @unusedMonsters << Monster.new('Necrófago', 13, badConsequence, prize)

      # El rey de rosado
      prize = Prize.new(3,2)
      badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 ' \
          'tesoros visibles.', 5 , 3, 0)
      @unusedMonsters << Monster.new('El rey de rosado', 11, badConsequence, prize)

      # Flecher
      prize = Prize.new(1,1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures('Toses los pulmones y ' \
          'pierdes 2 niveles.', 2 , 0, 0)
      @unusedMonsters << Monster.new('Flecher', 2, badConsequence, prize)

      # Los hondos
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newDeath('Estos monstruos resultan bastante superficiales ' \
          'y te aburren mortalmente. Estás muerto.', true)
      @unusedMonsters << Monster.new('Los hondos', 8, badConsequence, prize)

      # Semillas Cthulhu
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 2 niveles y 2 tesoros ' \
          'ocultos.', 2, 0, 2)
      @unusedMonsters << Monster.new('Semillas Cthulhu', 4, badConsequence, prize)

      # Dameargo
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Te intentas escaquear. ' \
          'Pierdes una mano visible.', 0, [TreasureKind::ONEHAND], [])
      @unusedMonsters << Monster.new('Dameargo', 1, badConsequence, prize)

      # Pollipólipo volante
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures('Da mucho asquito. Pierdes ' \
        '3 niveles.', 3, 0, 0)
      @unusedMonsters << Monster.new('Pollipólipo volante', 3, badConsequence, prize)

      # Yskhtihyssg-Goth
      prize = Prize.new(3, 1)
      badConsequence = BadConsequence.newDeath('No le hace gracia que pronuncien mal su nombre. ' \
          'Estás muerto.', true)
      @unusedMonsters << Monster.new('Yskhtihyssg-Goth', 14, badConsequence, prize)

      # Familia feliz
      prize = Prize.new(3, 1)
      badConsequence = BadConsequence.newDeath('La familia te atrapa. Estás muerto.', true)
      @unusedMonsters << Monster.new('Familia feliz', 1, badConsequence, prize)

      # Roboggoth
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('La quinta directiva primaria te ' \
          'obliga a perder 2 niveles y un tesoro de 2 manos visible.', 2, [TreasureKind::BOTHHANDS], [])
      @unusedMonsters << Monster.new('Roboggoth', 8, badConsequence, prize)

      # El espía sordo
      prize = Prize.new(1, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Te asusta en la noche. Pierdes ' \
          'un casco visible.', 0, [TreasureKind::HELMET], [])
      @unusedMonsters << Monster.new('El espia sordo', 5, badConsequence, prize)

      # Tongue
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberOfTreasures('Menudo susto te llevas. Pierdes ' \
          '2 niveles y 5 tesoros visibles.', 2, 5, 0)
      @unusedMonsters << Monster.new('Tongue', 19, badConsequence, prize)

      # Bicéfalo
      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Te faltan manos para tanta ' \
          'cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.', 3,
          [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHHANDS], [])
      @unusedMonsters << Monster.new('Bicéfalo', 21, badConsequence, prize)
    end

    def shuffleTreasures
      @unusedTreasures.shuffle!
    end

    def shuffleMonsters
      @unusedMonsters.shuffle!
    end

    public
    
    def nextTreasure

    end

    def nextMonster

    end

    def giveTreasureBack(t)
      @usedTreasures << t
    end

    def giveMonsterBack(m)
      @usedMonsters << m
    end

    def initCards

    end
    
    # TODO: implementar
    def to_s
      
    end

  end # CardDealer

end # NapakalakiGame