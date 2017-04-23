/**
 * CombatResult.java
 */

package NapakalakiGame;

/**
 * Representa el resultado de un combate.
 */
public enum CombatResult {
    
    WINGAME("wingame"), WIN("win"),
    LOSE("lose"), LOSEANDCONVERT("lose and convert");
    
    private final String name;
    
    CombatResult(String n) {
        this.name = n;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
    
}
