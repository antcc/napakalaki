/**
 * Game.java
 */

package NapakalakiGame;

import GUI.NapakalakiView;
import GUI.Dice;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/**
 * Representa el juego (aplicación).
 */
public class Game {
    
    public static void main(String[] args) {
        ArrayList<String> names;
        Napakalaki game = Napakalaki.getInstance();
        NapakalakiView napakalakiView = new NapakalakiView("Napakalaki");
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        Dice.createInstance(napakalakiView);
        
        // Inicializar juego
        names = namesCapture.getNames();
        game.initGame(names);

        // Mostrar ventana
        napakalakiView.setNapakalaki(game);
        napakalakiView.pack();
        napakalakiView.showView();
    }
}
