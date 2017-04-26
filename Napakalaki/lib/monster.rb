# encoding: utf-8

module NapakalakiGame

  # class Monster: representa un monstruo
  class Monster
    attr_reader :name             # nombre del monstruo
    attr_reader :combatLevel      # nivel del monstruo
    attr_reader :badConsequence   # mal rollo

    def initialize(n, l, b, p, lC)
      @name = n
      @combatLevel = l
      @badConsequence = b
      @prize = p
      @levelChangeAgainstCultistPlayer = lC
    end
    
    def self.newMonster(n, l, b, p)
      new(n, l, b, p, 0)
    end

    def self.newMonsterCultist(n, l, b, p, lC)
      new(n, l, b, p, lC)
    end
    
    private_class_method :new
    
    def getName
      @name
    end

    def getCombatLevel
      @combatLevel
    end

    def getCombatLevelAgainstCultistPlayer
      @combatLevel + @levelChangeAgainstCultistPlayer
    end

    def getBadConsequence
      @badConsequence
    end

    # devuelve los niveles ganados del buen rollo
    def getLevelsGained
      @prize.levels
    end

    # devuelve los tesoros ganados del buen rollo
    def getTreasuresGained
      @prize.treasures
    end

    def to_s
      "Nombre: #{@name} \nNivel: #{@combatLevel} \n" + 
      "Cambio de nivel frente a sectarios: #{@levelChangeAgainstCultistPlayer}" +
      "\nMal rollo:\n" + @badConsequence.to_s + "\nRecompensa:\n" + @prize.to_s
    end

  end # Monster

end # NapakalakiGame
