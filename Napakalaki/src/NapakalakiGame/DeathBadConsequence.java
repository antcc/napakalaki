/**
 * DeathBadConsequence.java
 */

package NapakalakiGame;

/**
 * Representa un mal rollo de muerte.
 */
public class DeathBadConsequence extends NumericBadConsequence {
    
    public DeathBadConsequence(String t) {
        super(t, Player.MAXLEVEL, MAXTREASURES, MAXTREASURES);
    }
    
}
