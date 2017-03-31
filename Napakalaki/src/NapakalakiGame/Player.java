/**
 * Player.java
 */

package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Representa un jugador.
 */
public class Player {
    
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    private Player enemy;
    private BadConsequence pendingBadConsequence;
    private ArrayList<Treasure> visibleTreasures;
    private ArrayList<Treasure> hiddenTreasures;
    
    final static int MAXLEVEL = 10;
    
    public Player(String name) {
        this.name = name;
        level = 1;
        dead = true;
        canISteal = true;
        enemy = null;
        pendingBadConsequence = null;
        visibleTreasures = new ArrayList();
        hiddenTreasures = new ArrayList();
    }

    public String getName() {
        return name;
    }
    
    private void bringToLife() {
        dead = false;
    }
    
    private int getCombatLevel() {
        int combatLevel = level;
        for (Treasure vt : visibleTreasures)
            combatLevel += vt.getBonus();
        
        return combatLevel;
    }
    
    private void incrementLevels(int l) {
        level = Math.min(level + l, MAXLEVEL);
    }
    
    private void decrementLevels(int l) {
        level = Math.max(level - l, 1);
    }
    
    private void setPendingBadConsequence(BadConsequence b) {
        pendingBadConsequence = b;
    }
    
    private void applyPrize(Monster m) {
        
    }
    
    private void applyBadConsequence(Monster m) {
        
    }
    
    private boolean canMakeTreasureVisible(Treasure t) {
        TreasureKind type = t.getType();
        boolean canMakeVisible;
        int count = 0;
        
        for (Treasure vt : visibleTreasures) {
            if (type == vt.getType())
                count++;
        }
        
        
        if (type == TreasureKind.ONEHAND) {
            /*
                noneMatch(pred): devuelve si ningún elemento del array visibleTreasures cumple el 
                predicado pred.
            */
            
            canMakeVisible = count < 2 && visibleTreasures
                                                    .stream()
                                                    .noneMatch(s -> s.getType() == TreasureKind.BOTHHANDS);
        }
        
        else {
            canMakeVisible = count < 1;
            
            if (type == TreasureKind.BOTHHANDS) {
                canMakeVisible &= visibleTreasures
                                            .stream()
                                            .noneMatch(s -> s.getType() == TreasureKind.ONEHAND);
            }
        }
        
        return canMakeVisible;
    }
    
    private int howManyVisibleTreasures(TreasureKind tKind) {
        int howMany = 0;
        for (Treasure vt : visibleTreasures)
            if (vt.getType() == tKind)
                howMany++;
        
        return howMany;
    }
    
    private void dieIfNoTreasures() {
        if (visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            dead = true;
    }
    
    public boolean isDead() {
        return dead;
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }
    
    // TODO: implementar
    //public CombatResult combat(Monster m) {
        
    //}
    
    public void makeTreasureVisible(Treasure t) {
        
    }
    
    public void discardVisibleTreasure(Treasure t) {
        
    }
    
    public void discardHiddenTreasure(Treasure t) {
        
    }
    
    public boolean validState() {
        return (pendingBadConsequence == null || pendingBadConsequence.isEmpty())
               && hiddenTreasures.size() <= 4; 
    }
    
    public void initTreasures() {
        
    }
    
    public int getLevels() {
        return level;
    }
    
    // TODO: implementar
    //public Treasure stealTreasure() {
        
    //}
    
    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
    
    private Treasure giveMeATreasure() {
        return hiddenTreasures.get(new Random().nextInt(hiddenTreasures.size()));
    }

    public boolean canISteal() {
        return canISteal;
    }
    
    // TODO: revisar cuando implementemos sectarios.
    private boolean canYouGiveMeATreasure() {
        return !hiddenTreasures.isEmpty();
    }
    
    private void haveStolen() {
        canISteal = false;
    }
    
    public void discardAllTreasures() {
        
    }
    
    @Override
    public String toString() {
        String text = "Name: " + name + "\nLevel: " + Integer.toString(level)
               + "\nDead: " + dead + "\nCan I steal: " + canISteal + "\nEnemy: ";
        
        if (enemy != null)
            text += enemy.getName();
        
        text += "\nPending bad consequence: ";
        
        if (pendingBadConsequence != null)
            text += pendingBadConsequence.toString();
        
        text += "\nHidden treasures: " + Arrays.toString(hiddenTreasures.toArray());
        text += "\nVisible treasures: " + Arrays.toString(visibleTreasures.toArray());
        
        return text;
    }

}
