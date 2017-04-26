/**
 * Cultist.java
 */

package NapakalakiGame;

/**
 * Representa una carta de sectario.
 */
public class Cultist {
    
    private String name;
    private int gainedLevels;
    
    public Cultist(String name, int gainedLevels) {
        this.name = name;
        this.gainedLevels = gainedLevels;
    }
    
    public int getGainedLevels() {
        return gainedLevels;
    }
    
    @Override
    public String toString() {
        return name + ", niveles ganados: " + Integer.toString(gainedLevels);
    }
    
}
