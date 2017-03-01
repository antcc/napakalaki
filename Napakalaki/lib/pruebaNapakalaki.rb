#encoding: utf-8

require_relative 'treasure_kind'
require_relative 'prize'
require_relative 'monster'

# class PruebaNapakalaki: programa de prueba
class PruebaNapakalaki 
  # Listar los tipos de tesoros
  puts "Tipos de tesoros: "
  TreasureKind.constants.each do |tesoro|
    puts "#{TreasureKind.const_get(tesoro)}"
  end
  puts
  
  # construir dos monstruos
  prize1 = Prize::new(2,1)
  prize2 = Prize::new(1,1)
  monster1 = Monster::new("Pollipólipo volante", 3, nil, prize1)
  monster2 = Monster::new("El espía sordo", 5, nil, prize2)
  
  # acceder a algunos miembros
  print "Niveles ganados en la recompensa 1: "
  puts prize1.level
  puts
  puts "Recompensa del monstruo 2: "
  puts monster2.prize
  
  # imprimir los monstruos
  puts "\nMonstruo 1."
  puts monster1.to_s
  puts "\nMonstruo 2."
  puts monster2.to_s
end

