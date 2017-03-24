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
        levels = 0;
        this.death = death;
        nVisibleTreasures = 0;
        nHiddenTreasures = 0;
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
    
    public int getLevels() {
        return this.levels;
    }
    
    public int getNVisibleTreasures() {
        return this.nVisibleTreasures;
    }
    
    public int getNHiddenTreasures() {
        return this.nHiddenTreasures;
    }
    
    public ArrayList getSpecificHiddenTreasures() {
        return this.specificHiddenTreasures;
    }
    
    public ArrayList getSpecificVisibleTreasures() {
        return this.specificVisibleTreasures;
    }
    
    @Override
    public String toString() {
        String text = "Text: " + this.text;
        
        if (this.death) {
            
            text = text + "\nDeath: " + String.valueOf(death);
            
        } else {
        
            text = text + "\nLevels: " + Integer.toString(levels) +
                "\nVisible treasures lost: " + Integer.toString(nVisibleTreasures) +
                "\nHidden treasures lost: " + Integer.toString(nHiddenTreasures);
        
        }
        
        if (specificHiddenTreasures != null) {
        
            text = text + "\nSpecific Hidden Treasures: " + Arrays.toString(specificHiddenTreasures.toArray());
        
        } else if (specificVisibleTreasures != null) {
        
            text = text + "\nSpecific Visible Treasures: " + Arrays.toString(specificVisibleTreasures.toArray());
        
        }
        
        return text;
    }
    
}
