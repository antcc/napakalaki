# encoding: utf-8

module NapakalakiGame
  
  class Cultist
    def initialize(name, gainedLevels)
      @name = name
      @gainedLevels = gainedLevels # Niveles adicionales que obtiene el jugador
    end

    def getGainedLevels
      @gainedLevels
    end
    
    def to_s
      @name + ", niveles ganados: #{@gainedLevels}"
    end

  end # Cultist

end # NapakalakiGame