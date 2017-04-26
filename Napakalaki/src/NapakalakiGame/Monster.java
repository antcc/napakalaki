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
    private int levelChangeAgainstCultistPlayer;
    
    public Monster(String n, int l, BadConsequence b, Prize p, int lC) {
        name = n;
        combatLevel = l;
        badConsequence = b;
        prize = p;
        levelChangeAgainstCultistPlayer = lC;
    } 
    
    public Monster(String n, int l, BadConsequence b, Prize p) {
        this(n, l, b, p, 0);
    }
    
    public String getName() {
        return name;
    }
    
    public int getCombatLevel() {
        return combatLevel;
    }
    
    public int getCombatLevelAgainstCultistPlayer() {
        return combatLevel + levelChangeAgainstCultistPlayer;
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
        return "Nombre: " + name + "\nNivel: " + Integer.toString(combatLevel) +
               "\nCambio de nivel frente a sectarios: " + levelChangeAgainstCultistPlayer +
               "\nBuen rollo:\n" + prize.toString() + "\nMal rollo:\n" +
               badConsequence.toString();
    }
    
}
