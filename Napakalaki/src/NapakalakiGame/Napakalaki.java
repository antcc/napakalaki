/**
 * Napakalaki.java
 */

package NapakalakiGame;

import java.util.ArrayList;
import java.util.Random;
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
     * Inicializa los jugadores.
     * @param names Lista de nombres
     */
    private void initPlayers(ArrayList<String> names) {
        for (String n : names)
            players.add(new Player(n));
    }

    private Player nextPlayer() {
        int nextP;
        int numPlayers = players.size();
        Random rand = new Random();
        
        if (currentPlayer == null) {
            nextP = rand.nextInt(numPlayers);
        }
        
        else {
            nextP = (players.indexOf(currentPlayer) + 1) % numPlayers;
        }
        
        currentPlayer = players.get(nextP);
        return currentPlayer;
    }
    
    private boolean nextTurnAllowed() {
        return currentPlayer == null || currentPlayer.validState();
    }
    
    /**
     * 
     */
    private void setEnemies() {
        Random rand = new Random();
        
        for (Player p : players) {
            Player enemy;
            do {
                enemy = players.get(rand.nextInt(players.size()));
            } while (enemy == p);
            
            p.setEnemy(enemy);
        }
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
