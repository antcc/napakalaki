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
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.badConsequence = badConsequence;
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
               "\nPrize: " + prize.toString() + "\nBad consequence: " +
               badConsequence.toString();
    }
    
}
