# encoding: utf-8

module Test

  # module Command: class Option y constantes que representan las opciones
  module Command
    
    # class Option: representa una opción del menú
    class Option
      attr_reader :menu, :text
      
      def initialize (aValue, aText)
        @menu = aValue
        @text = aText
      end
      
    end # Option
    
    Exit = Option.new(0, "Salir")
    GoBack = Option.new(-1, "Menú anterior")
    Combat = Option.new(69, "¡¡ C O M B A T I R !!")
    ShowMonster = Option.new(10, "Mostrar monstruo")
    ShowVisibleTreasure = Option.new(11, "Mostrar tesoros visibles")
    ShowHiddenTreasure = Option.new(12, "Mostrar tesoros ocultos") 
    DiscardVisibleTreasure = Option.new(21, "Descartar tesoro visible")
    DiscardHiddenTreasure = Option.new(22, "Descartar tesoro oculto")
    DiscardAll = Option.new(23, "Descartar TODOS los tesoros")
    MakeTreasureVisible = Option.new(31, "Equipar tesoro")
    StealTreasure = Option.new(32, "Robar tesoro")
    NextTurn = Option.new(1, "Siguiente turno")
    NextTurnAllowed = Option.new(2, "Siguiente turno permitido")
    
  end # Command
  
end # Test
