/**
 * Treasure.java
 */

package NapakalakiGame;

/**
 * Representa un tesoro.
 */
public class Treasure {
    
    private String name;
    private int bonus;
    private TreasureKind type;
    
    public Treasure(String n, int bonus, TreasureKind t) {
        name = n;
        this.bonus = bonus;
        type = t;
    }

    public String getName() {
        return name;
    }

    public int getBonus() {
        return bonus;
    }

    public TreasureKind getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return "Name: " + name + "\nBonus: " + Integer.toString(bonus) 
               + "\nType: " + type;
    }
    
}
