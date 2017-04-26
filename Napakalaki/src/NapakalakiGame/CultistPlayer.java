/**
 * CultistPlayer.java
 */

package NapakalakiGame;

import java.util.Random;

/**
 * Representa un jugador sectario 
 */
public class CultistPlayer extends Player {
    
    private static int totalCultistPlayers = 0;
    private Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c) {
        super(p);
        myCultistCard = c;
        totalCultistPlayers++;
    }
    
    @Override
    protected int getCombatLevel() {
        // super.getCombatLevel() + 0.7 * super.getCombatLevel() = 1.7 * super.getCombatLevel()
        return (int) (1.7 * super.getCombatLevel()) + 
                      myCultistCard.getGainedLevels() * totalCultistPlayers;
    }
    
    @Override
    protected int getOponentLevel(Monster m) {
        return m.getCombatLevelAgainstCultistPlayer();
    }
    
    @Override
    protected boolean shouldConvert() {
        return false;
    }
    
    @Override
    protected boolean canYouGiveMeATreasure() {
        return !getVisibleTreasures().isEmpty();
    }
    
    @Override
    protected Treasure giveMeATreasure() {
        return getVisibleTreasures().remove(new Random().nextInt(getVisibleTreasures().size()));
    }
    
    public static int getTotalCultistPlayers() {
        return totalCultistPlayers;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n - Carta de sectario: " + myCultistCard.toString();
    }
    
}
