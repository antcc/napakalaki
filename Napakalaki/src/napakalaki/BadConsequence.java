/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author jmml
 */
public class BadConsequence {
    
    
    //// Atributos
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    
    private ArrayList<TreasureKind>specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind>specificVisibleTreasures = new ArrayList();
    
    //// Constructores
    
    public BadConsequence(String text, int levels, int nVisible, int nHidden) {
    
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    
    }
    
    public BadConsequence(String text, boolean death) {
    
        this.text = text;
        this.death = death;
    
    }
    
    public BadConsequence (String text, int levels, ArrayList<TreasureKind> tVisible, 
            ArrayList<TreasureKind> tHidden) {
    
        this.specificVisibleTreasures = tVisible;
        this.specificHiddenTreasures = tHidden;
    
    }
    
    //// Métodos
    
    // Set & Get
    
    public String getText() {

        return this.text;
    
    }
    
    public int getLevels() {
    
        return this.levels;
    
    }
    
    public int getVisibleTreasures() {
    
        return this.nVisibleTreasures;
    
    }
    
    public int getHiddenTreasures() {
    
        return this.nHiddenTreasures;
    
    }
    
    public boolean getDeath() {
    
        return this.death;
        
    }
    
    public ArrayList getSpecificHiddenTreasures() {
    
        return this.specificHiddenTreasures;
    
    }
    
    public ArrayList getSpecificVisibleTreasures() {
    
        return this.specificVisibleTreasures;
    
    }
}
