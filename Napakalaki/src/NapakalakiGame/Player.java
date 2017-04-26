/**
 * Player.java
 */

package NapakalakiGame;

import java.util.ArrayList;
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
    
    public Player(Player p) {
        name = p.name;
        level = p.level;
        dead = p.dead;
        canISteal = p.canISteal;
        enemy = p.enemy;
        pendingBadConsequence = p.pendingBadConsequence;
        visibleTreasures = p.visibleTreasures;
        hiddenTreasures = p.hiddenTreasures;
    }

    public String getName() {
        return name;
    }
    
    private void bringToLife() {
        dead = false;
    }
    
    protected int getCombatLevel() {
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
        int nLevels = m.getLevelsGained();
        int nTreasures = m.getTreasuresGained();
        
        incrementLevels(nLevels);
        
        if (nTreasures > 0) {
            CardDealer dealer = CardDealer.getInstance();
            
            for (int i = 0; i < nTreasures; i++) {
                hiddenTreasures.add(dealer.nextTreasure());
            }
        }
    }
    
    private void applyBadConsequence(Monster m) {
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();   
        
        decrementLevels(nLevels);
        
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures,
                                                                            hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    protected boolean shouldConvert() {
        return Dice.getInstance().nextNumber() == 6;
    }
    
    protected int getOponentLevel(Monster m) {
        return m.getCombatLevel();
    }
    
    private boolean canMakeTreasureVisible(Treasure t) {
        boolean canMakeVisible;
        TreasureKind type = t.getType();
        int count = howManyVisibleTreasures(type);
        
        
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
    
    protected Player getEnemy() {
        return enemy;
    }

    public ArrayList<Treasure> getHiddenTreasures() {
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures() {
        return visibleTreasures;
    }

    public CombatResult combat(Monster m) {
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m);
        CombatResult combatResult;
        
        if (!canISteal) {
            Dice dice = Dice.getInstance();
            int number = dice.nextNumber();
            
            if (number < 3) {
                monsterLevel += enemy.getCombatLevel();
            }
        }
        
        if (myLevel > monsterLevel) {
            applyPrize(m);
            combatResult = level >= MAXLEVEL ? CombatResult.WINGAME : CombatResult.WIN;
        }
        
        else {
            applyBadConsequence(m);
            if (shouldConvert())
                combatResult = CombatResult.LOSEANDCONVERT;
            else
                combatResult = CombatResult.LOSE;
        }
        
        return combatResult;
    }
    
    public void makeTreasureVisible(Treasure t) {
        if (canMakeTreasureVisible(t)) {
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t) {
        visibleTreasures.remove(t);
        
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()) {
            pendingBadConsequence.substractVisibleTreasure(t);
        }
        
        dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t) {
        hiddenTreasures.remove(t);
        
        if (pendingBadConsequence != null && !pendingBadConsequence.isEmpty()) {
            pendingBadConsequence.substractHiddenTreasure(t);
        }
        
        dieIfNoTreasures();
    }
    
    public boolean validState() {
        return (pendingBadConsequence == null || pendingBadConsequence.isEmpty())
                && hiddenTreasures.size() <= 4; 
    }
    
    public void initTreasures() {
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        
        bringToLife();
        hiddenTreasures.add(dealer.nextTreasure());
        
        int number = dice.nextNumber();
        
        if (number > 1) {
            hiddenTreasures.add(dealer.nextTreasure());
        }
        
        if (number == 6) {
            hiddenTreasures.add(dealer.nextTreasure());
        }       
    }
    
    public int getLevel() {
        return level;
    }
    
    public Treasure stealTreasure() {
        Treasure treasure = null;
        
        if (canISteal()) {
            if (enemy.canYouGiveMeATreasure()) {
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                haveStolen();
            }
        }
        
        return treasure;
    }
    
    public void setEnemy(Player enemy) {
        this.enemy = enemy;
    }
    
    protected Treasure giveMeATreasure() {
        return hiddenTreasures.remove(new Random().nextInt(hiddenTreasures.size()));
    }

    public boolean canISteal() {
        return canISteal;
    }
    
    protected boolean canYouGiveMeATreasure() {
        return !hiddenTreasures.isEmpty();
    }
    
    private void haveStolen() {
        canISteal = false;
    }
    
    public void discardAllTreasures() {
        ArrayList<Treasure> copyVisible = new ArrayList(visibleTreasures);
        ArrayList<Treasure> copyHidden = new ArrayList(hiddenTreasures);
        
        for (Treasure treasure : copyVisible) {
            discardVisibleTreasure(treasure);
        }
        
        for (Treasure treasure : copyHidden) {
            discardHiddenTreasure(treasure);
        }
    }
    
    @Override
    public String toString() {
        String text = name + " (nivel " + Integer.toString(level)
               + ", nivel de combate " + Integer.toString(getCombatLevel()) + ")"
               + "\n - Muerto: " + dead + "\n - Puede robar: " + canISteal 
               + "\n - Enemigo: " + enemy.getName() + "\n - Mal rollo pendiente: ";

        if (pendingBadConsequence != null /*&& !pendingBadConsequence.isEmpty()*/)
            text += "\n" + pendingBadConsequence.toString();
        else
            text += "NO";
        
        //text += "\n - Hidden treasures: " + Arrays.toString(hiddenTreasures.toArray());
        //text += "\n - Visible treasures: " + Arrays.toString(visibleTreasures.toArray());
        
        return text;
    }

}
