# encoding: utf-8

require_relative 'napakalaki'
require_relative 'game_tester'

module NapakalakiGame

  # class EjemploMain: partida de ejemplo para el juego
  class EjemploMain
    def prueba
      test = Test::GameTester.instance
      game = Napakalaki.instance
      
      #Se prueba el juego con 2 jugadores
      test.play(game, 2);
    end
      
  end # EjemploMain
  
  e = EjemploMain.new
  e.prueba

end # NapakalakiGame
