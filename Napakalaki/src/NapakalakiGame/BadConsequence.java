/**
 * BadConsequence.java
 */

package NapakalakiGame;

import java.util.ArrayList;

/**
 * Representa un mal rollo genérico de un monstruo.
 */
public abstract class BadConsequence {

    private String text;
    private int levels;
    
    public BadConsequence(String t, int l) {
        text = t;
        levels = l;
    }

    public int getLevels() {
        return levels;
    }
    
    public String getText() {
        return text;
    }
    
    protected abstract boolean isEmpty();
    
    protected abstract void substractVisibleTreasure(Treasure t);
    
    protected abstract void substractHiddenTreasure(Treasure t);
    
    protected abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, 
                                                            ArrayList<Treasure> h);
    
    @Override
    public String toString() {
        return "    * Texto: " + text + "\n    * Niveles perdidos: " + Integer.toString(levels);
    }
    
}
