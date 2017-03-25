/**
 * Napakalaki.java
 */

package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Representa una partida.
 * Singleton.
 */
public class Napakalaki {
    
    private static Napakalaki instance = null;
    
    CardDealer dealer;
    Monster currentMonster;
    Player currentPlayer;
    ArrayList<Player> players;
    
    /**
     * Constructor
     */
    private Napakalaki() {
        dealer = CardDealer.getInstance();
        currentMonster = null;
        currentPlayer = null;
        players = new ArrayList();
    }
    
    /**
     * @return instancia del singleton
     */
    public static Napakalaki getInstance() {
        if (instance == null)
            instance = new Napakalaki();
        
        return instance;
    }
    
    /**
     * 
     * @param names 
     */
    private void initPlayers(ArrayList<String> names) {

    }
    
    // TODO: implementar
    //private Player nextPlayer() {
        
    //}
    
    // TODO: implementar
    //private boolean nextTurnAllowed() {
        
    //}
    
    /**
     * 
     */
    private void setEnemies() {
        
    }
    
    // TODO: implementar
    //public CombatResult developCombat() {
        
    //}
    
    /**
     * @param treasures 
     * @pre treasures.size() >= 1
     */
    public void discardVisibleTreasures(ArrayList<Treasure> treasures) {
        
    }
    
    /**
     * @param treasures 
     * @pre treasures.size() >= 1
     */
    public void discardHiddenTreasures(ArrayList<Treasure> treasures) {
        
    }
    
    /**
     * @param treasures
     * @pre treasures.size() >= 1
     */
    public void makeTreasuresVisible(ArrayList<Treasure> treasures) {
        
    }
    
    public void initGame(ArrayList<String> players) {
        
    }

    public Monster getCurrentMonster() {
        return currentMonster;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    // TODO: implementar
    //public boolean nextTurn() {
        
    //}
    
    public boolean endOfGame(CombatResult result) {
        return result == CombatResult.WINGAME;
    }
    
    @Override
    public String toString() {
        String text = "Players: ";
        
        /**
         * Aprovechamos los streams de Java 8.
         * Player::getName hace referencia al método de instancia 'getName' de una instancia
         * arbitraria de Player.
         */
        text += players.stream().map(Player::getName).collect(Collectors.joining(", "));
        
        text += "\nCurrent player: ";
        if (currentPlayer != null)
            text += currentPlayer.getName();
        
        text += "\nCurrent monster: ";
        if (currentMonster != null)
            text += currentMonster.getName();
        
        return text;
    }
    
}
