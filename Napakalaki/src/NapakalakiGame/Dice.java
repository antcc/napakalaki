/**
 * Dice.java
 */

package NapakalakiGame;

import java.util.Random;

/**
 * Representa el dado. 
 * Singleton.
 */
public class Dice {
    
    private static Dice instance = null;
    private final Random random;
    
    private Dice() {
        random = new Random();
    }
    
    public static Dice getInstance() {
        if (instance == null) {
            instance = new Dice();
        }
         
        return instance;    
    }
    
    public int nextNumber() {
        return 1 + random.nextInt(6);
    }
    
}
