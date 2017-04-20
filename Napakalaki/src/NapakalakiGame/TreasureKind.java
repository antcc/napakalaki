/**
 * TreasureKind.java
 */

package NapakalakiGame;

/**
 * Representa los tipos de tesoros.
 */
public enum TreasureKind {
    
    ARMOR("armor"), ONEHAND("onehand"), BOTHHANDS("bothhands"),
    HELMET("helmet"), SHOE("shoe");
    
    private final String name;
    
    TreasureKind(String n) {
        this.name = n;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
 
}
