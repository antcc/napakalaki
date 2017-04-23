# encoding: utf-8

require_relative 'treasure'
require_relative 'treasure_kind'
require_relative 'bad_consequence'
require_relative 'monster'
require_relative 'prize'
require 'singleton'

module NapakalakiGame
  
  # class CardDealer: representa los mazos de cartas
  class CardDealer
    include Singleton  # la clase es <<singleton>>
    
    def initialize
      @unusedMonsters = Array.new
      @usedMonsters = Array.new
      @unusedTreasures = Array.new
      @usedTreasures = Array.new
      @unusedCultists = Array.new
    end

    private
    
    # inicializar el mazo de tesoros no usados
    def initTreasureCardDeck
      @unusedTreasures << Treasure.new("¡Sí mi amo!", 4, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Botas de investigación", 3, TreasureKind::SHOE)
      @unusedTreasures << Treasure.new("Capucha de Cthulhu", 3, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("A prueba de babas", 2, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Botas de lluvia ácida", 1, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Casco minero", 2, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Ametralladora ACME", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Camiseta de la ETSIIT", 1, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Clavo de rail ferroviario", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Cuchillo de sushi arcano", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Fez alópodo", 3, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Hacha prehistórica", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("El aparato del Pr. Tesla", 4, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Gaita", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Insecticida", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Escopeta de 3 cañones", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Garabato místico", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("La rebeca metálica", 2, TreasureKind::ARMOR)
      @unusedTreasures << Treasure.new("Lanzallamas", 4, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Necrocomicón", 1, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Necronomicón", 5, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Linterna a dos manos", 3, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Necrognomicón", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Necrotelecom", 2, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Mazo de los antiguos", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Necroplayboycón", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Porra preternatural", 2, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Shogulador", 1, TreasureKind::BOTHHANDS)
      @unusedTreasures << Treasure.new("Varita de atizamiento", 3, TreasureKind::ONEHAND)
      @unusedTreasures << Treasure.new("Tentáculo de pega", 2, TreasureKind::HELMET)
      @unusedTreasures << Treasure.new("Zapato deja-amigos", 1, TreasureKind::SHOE)   
    end

    # inicializar el mazo de monstruos no usados
    def initMonsterCardDeck
      # 3 Byakhees de bonanza
      prize = Prize.new(2,1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible ' \
          'y otra oculta.', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
      @unusedMonsters << Monster.new('3 Byakhees de bonanza', 8, badConsequence, prize)

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
          'y te aburren mortalmente. Estás muerto.')
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
          'Estás muerto.')
      @unusedMonsters << Monster.new('Yskhtihyssg-Goth', 14, badConsequence, prize)

      # Familia feliz
      prize = Prize.new(3, 1)
      badConsequence = BadConsequence.newDeath('La familia te atrapa. Estás muerto.')
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

      prize = Prize.new(3, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes 1 mano visible', 0, \
                                                                [TreasureKind::ONEHAND], [])
      @unusedMonsters << Monster.newMonsterCultist('El mal indecible impronunciable', 10, badConsequence, \
                                                     prize, -2)

      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberTreasures('Pierdes todos tus tesoros visibles. Jajaja', \
                                                              0, BadConsequence.getMaxTreasures, 0)
      @unusedMonsters << Monster.newMonsterCultist('Testigos oculares', 6, badConsequence, \
                                                   prize, 2)

      prize = Prize.new(2, 5)
      badConsequence = BadConsequence.newDeath('Hoy no es tu día de suerte. Mueres.')
      @unusedMonsters << Monster.newMonsterCultist('El gran cthulhu', 20, badConsequence, \
                                                     prize, 4)

      prize = Prize.new(2, 1)
      badConsequence = BadConsequence.newLevelNumberTreasures('Tu gobierno te recorta 2 niveles', \
                                                              2, 0, 0)
      @unusedMonsters << Monster.newMonsterCultist('Serpiente político', 8, badConsequence, \
                                                   prize, 2)

      prize = Prize.new(1, 1)
      badConsequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu casco y tu armadura' \
                                                                'visible. Pierdes tus manos ocultas', \
                                                                0,  \
                                                                [TreasureKind::HELMET, TreasureKind::ARMOR], \
                                                                [TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::ONEHAND, TreasureKind::BOTHANDS, TreasureKind::BOTHANDS, TreasureKind::BOTHANDS, TreasureKind::BOTHANDS])
      @unusedMonsters << Monster.newMonsterCultist('Felpuggoth', 2, badConsequence, \
                                                   prize, 5)

      prize = Prize.new(4, 2)
      badConsequence = BadConsequence.newLevelNumberTreasures('Pierdes 2 niveles', \
                                                              2, 0, 0)
      @unusedMonsters << Monster.newMonsterCultist('Shoggoth', 16, badConsequence, \
                                                   prize, -4)

      prize = Prize.new(1, 1)
      badConsequence = BadConsequence.newLevelNumberTreasures('Pintalabios negro. Pierdes 2 niveles', \
                                                              2, 0, 0)
      @unusedMonsters << Monster.newMonsterCultist('Lolitagooth', 2, badConsequence, \
                                                   prize, 3)
      
    end

    def initCultistCardDeck
      4.times {@unusedCultists << Cultist.new('Sectario', 1)}
      2.times {@unusedCultists << Cultist.new('Sectario', 2)}
    end
    
    # barajar los tesoros no usados
    def shuffleTreasures
      @unusedTreasures.shuffle!
    end

    # barajar los monstruos no usados
    def shuffleMonsters
      @unusedMonsters.shuffle!
    end

    def shuffleCultists
      @unusedCultists.shuffle!
    end
    
    public

    # sacar el siguiente tesoro de la baraja
    # si está vacía, pasar la pila de descartes y barajar
    def nextTreasure
      # swap if empty
      if @unusedTreasures.empty?
        temp = @unusedTreasures
        @unusedTreasures = @usedTreasures
        @usedTreasures = temp
        
        # shuffle
        shuffleTreasures
      end
      
      @unusedTreasures.pop
    end

    def nextMonster
      # swap if empty
      if @unusedMonsters.empty?
        temp = @unusedMonsters
        @unusedMonsters = @usedMonsters
        @usedMonsters = temp
        
        # shuffle
        shuffleMonsters
      end
      
      @unusedMonsters.pop
    end

    def nextCultist
      @unusedCultists.pop
    end
    
    # introducir un tesoro en el mazo de tesoros usados
    def giveTreasureBack(t)
      @usedTreasures << t
    end
    
    # introducir un monstruo en el mazo de monstruos usados
    def giveMonsterBack(m)
      @usedMonsters << m
    end

    def initCards
      initTreasureCardDeck
      initMonsterCardDeck
      initCultistCardDeck
      shuffleTreasures
      shuffleMonsters
      shuffleCultists
    end

  end # CardDealer

end # NapakalakiGame
