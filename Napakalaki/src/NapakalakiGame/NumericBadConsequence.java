/**
 * NumericBadConsequence.java
 */

package NapakalakiGame;

import java.util.ArrayList;

/**
 * Representa un mal rollo numérico.
 */
public class NumericBadConsequence extends BadConsequence {
    
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    
    public NumericBadConsequence(String t, int l, int nVisible, int nHidden) {
        super(t, l);
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
    }
    
    public int getNVisibleTreasures() {
        return this.nVisibleTreasures;
    }
    
    public int getNHiddenTreasures() {
        return this.nHiddenTreasures;
    }
    
    @Override
    public boolean isEmpty() {
        return nVisibleTreasures == 0 && nHiddenTreasures == 0;
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t) {
        if (nVisibleTreasures > 0) {
            nVisibleTreasures--;
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t) {
        if (nHiddenTreasures > 0) {
            nHiddenTreasures--;
        }
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, 
                                                   ArrayList<Treasure> h) {
        // Nos quedamos con el mínimo
        int maxVisible = Math.min(v.size(), nVisibleTreasures);
        int maxHidden = Math.min(h.size(), nHiddenTreasures);
            
        return new NumericBadConsequence(getText(), getLevels(), maxVisible, maxHidden);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n    * Tesoros visibles perdidos: " + 
               (nVisibleTreasures == MAXTREASURES ?
               "TODOS LOS TESOROS" : Integer.toString(nVisibleTreasures)) +
               "\n    * Tesoros ocultos perdidos: " + (nHiddenTreasures == MAXTREASURES ?
               "TODOS LOS TESOROS" : Integer.toString(nHiddenTreasures));
    }
    
} 
        
