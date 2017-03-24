/**
 * TreasureKind.java
 */

package NapakalakiGame;

/**
 * Representa los tipos de tesoros.
 */
public enum TreasureKind {
    
    ARMOR("Armadura"), ONEHAND("Una mano"), BOTHHANDS("Dos manos"),
    HELMET("Casco"), SHOE("Calzado");
    
    private final String name;
    
    TreasureKind(String n) {
        this.name = n;
    }
}
