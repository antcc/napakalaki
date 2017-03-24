/**
 * Prize.java
 */

package NapakalakiGame;

/**
 * Representa el buen rollo de un monstruo.
 */
public class Prize {
    
    private int treasures;
    private int levels;
    
    public Prize(int t, int l) {
        treasures = t;
        levels = l;
    }
    
    public int getTreasures() {
        return this.treasures;
    }
    
    public int getLevels() {
        return this.levels;
    }

    @Override
    public String toString() {
        return "Treasures: " + Integer.toString(treasures) +
                "\nLevel: " + Integer.toString(levels);
    
    }
    
}
