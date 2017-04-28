/**
 * SpecificBadConsequence.java
 */

package NapakalakiGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

/**
 * Representa un mal rollo de tesoros específicos.
 */
public class SpecificBadConsequence extends BadConsequence {
    
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    public SpecificBadConsequence(String t, int l, ArrayList<TreasureKind> v,
                                  ArrayList<TreasureKind> h) {
        super(t, l);
        specificVisibleTreasures = v;
        specificHiddenTreasures = h;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return specificHiddenTreasures;
    }
    
    @Override
    public boolean isEmpty() {
        return specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty();
    }
    
    @Override
    public void substractVisibleTreasure(Treasure t) {
        if (!specificVisibleTreasures.isEmpty()) {
            specificVisibleTreasures.remove(t.getType());
        }
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t) {
        if (!specificHiddenTreasures.isEmpty()) {
            specificHiddenTreasures.remove(t.getType());
        }
    }
    
    @Override
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, 
                                                   ArrayList<Treasure> h) {
        // Nuevos arrays con los tipos de tesoros
        ArrayList<TreasureKind> newVisibleType = new ArrayList();
        ArrayList<TreasureKind> newHiddenType = new ArrayList();
            
        for (Treasure t : v) {
            newVisibleType.add(t.getType());
        }
            
        for (Treasure t : h) {
            newHiddenType.add(t.getType());
        }
            
        // Nuevos arrays con la intersección (con duplicados)
        ArrayList<TreasureKind> newVisible = new ArrayList();
        ArrayList<TreasureKind> newHidden = new ArrayList();
            
        for (TreasureKind tKind : TreasureKind.values()) {
            int min_visible = Math.min(Collections.frequency(specificVisibleTreasures, tKind),
                                       Collections.frequency(newVisibleType, tKind));
            int min_hidden = Math.min(Collections.frequency(specificHiddenTreasures, tKind),
                                      Collections.frequency(newHiddenType, tKind));
                
            newVisible.addAll(Collections.nCopies(min_visible, tKind));
            newHidden.addAll(Collections.nCopies(min_hidden, tKind));
        }
            
        return new SpecificBadConsequence(getText(), getLevels(), newVisible, newHidden);
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n    * Tesoros visibles específicos perdidos: " + 
               Arrays.toString(specificVisibleTreasures.toArray()) +
               "\n    * Tesoros ocultos específicos perdidos: " + 
               Arrays.toString(specificHiddenTreasures.toArray());
    }
    
}
