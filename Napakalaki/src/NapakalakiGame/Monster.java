/**
 * Monster.java
 */

package NapakalakiGame;

/**
 * Representa un monstruo.
 */
public class Monster {
    
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    
    public Monster(String n, int l, BadConsequence b, Prize p) {
        name = n;
        combatLevel = l;
        badConsequence = b;
        prize = p;
    } 
    
    public String getName() {
        return name;
    }
    
    public int getCombatLevel() {
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence() {
        return badConsequence;
    }
    
    public int getLevelsGained() {
        return prize.getLevels();
    }
    
    public int getTreasuresGained() {
        return prize.getTreasures();
    }
    
    @Override
    public String toString() {
        return "Name: " + name + "\nLevel: " + Integer.toString(combatLevel) +
               "\nPrize:\n" + prize.toString() + "\nBad consequence:\n" +
               badConsequence.toString();
    }
    
}
