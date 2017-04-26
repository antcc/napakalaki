/**
 * BadConsequence.java
 */

package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Representa el mal rollo de un monstruo.
 */
public class BadConsequence {

    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    final static int MAXTREASURES = 10;
    
    public boolean isEmpty() {
        return nVisibleTreasures == 0 && nHiddenTreasures == 0 &&
               specificHiddenTreasures.isEmpty() && specificVisibleTreasures.isEmpty();
    }
    
    public int getLevels() {
        return this.levels;
    }
    
    public int getNVisibleTreasures() {
        return this.nVisibleTreasures;
    }
    
    public int getNHiddenTreasures() {
        return this.nHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures() {
        return this.specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures() {
        return this.specificVisibleTreasures;
    }
    
    public void substractVisibleTreasure(Treasure t) {
        if (!specificVisibleTreasures.isEmpty()) {
            specificVisibleTreasures.remove(t.getType());
        }
        
        else if (nVisibleTreasures > 0) {
            nVisibleTreasures--;
        }
    }
    
    public void substractHiddenTreasure(Treasure t) {
        if (!specificHiddenTreasures.isEmpty()) {
            specificHiddenTreasures.remove(t.getType());
        }
        
        else if (nHiddenTreasures > 0) {
            nHiddenTreasures--;
        }
    }
    
    public BadConsequence(String t, int l, int nVisible, int nHidden) {
        text = t;
        levels = l;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        death = false;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
    
    public BadConsequence(String t, boolean death) {
        text = t;
        levels = Player.MAXLEVEL;
        this.death = death;
        nVisibleTreasures = MAXTREASURES;
        nHiddenTreasures = MAXTREASURES;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
    
    public BadConsequence(String t, int l, ArrayList<TreasureKind> v, 
                          ArrayList<TreasureKind> h) {
        text = t;
        levels = l;
        death = false;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
        specificVisibleTreasures = v;
        specificHiddenTreasures = h;
    }
    
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, 
                                                   ArrayList<Treasure> h) {
        BadConsequence bd;
        
        // Mal rollo de tesoros específicos
        if (nVisibleTreasures == 0 && nHiddenTreasures == 0) {
            bd = new BadConsequence(text, levels,
                       (ArrayList<TreasureKind>) specificVisibleTreasures.clone(),
                       (ArrayList<TreasureKind>) specificHiddenTreasures.clone());
            
            // Nuevos arrays con los tipos de tesoros
            ArrayList<TreasureKind> newVisibleType = new ArrayList();
            ArrayList<TreasureKind> newHiddenType = new ArrayList();
            
            for (Treasure t : v) {
                newVisibleType.add(t.getType());
            }
            
            for (Treasure t : h) {
                newHiddenType.add(t.getType());
            }
            
            // Intersección (mantiene duplicados)
            bd.specificVisibleTreasures.retainAll(newVisibleType);
            bd.specificHiddenTreasures.retainAll(newHiddenType);
        }
        
        // Mal rollo de teosoros genéricos
        else {
            int maxVisible = Math.min(v.size(), nVisibleTreasures);
            int maxHidden = Math.min(h.size(), nHiddenTreasures);
            
            bd = new BadConsequence(text, levels, maxVisible, maxHidden);
        }
        
        return bd;
    }
    
    @Override
    public String toString() {
        String text = "Texto: " + this.text;
        
        if (this.death) {
            
            text = text + "\nMuerte: " + (death ? "SI" : "NO");
            
        } else {
        
            text = text + "\nNiveles: " + Integer.toString(levels) +
                "\nTesoros visibles perdidos: " + (nVisibleTreasures == MAXTREASURES ?
                "TODOS LOS TESOROS" : Integer.toString(nVisibleTreasures)) +
                "\nTesoros ocultos perdidos: " + (nHiddenTreasures == MAXTREASURES ?
                "TODOS LOS TESOROS" : Integer.toString(nHiddenTreasures));
        }
        
        text = text + "\nTesoros visibles específicos perdidos: " + Arrays.toString(specificVisibleTreasures.toArray());
        text = text + "\nTesoros ocultos específicos perdidos: " + Arrays.toString(specificHiddenTreasures.toArray());
        
        return text;
    }
    
}
