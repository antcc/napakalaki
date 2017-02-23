/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author jmml
 */
public class Prize {
    
    private int treasures;
    private int level;
    
    public Prize(int treasures, int level) {
    
        this.treasures = treasures;
        this.level = level;
    
    }
    
    //// Métodos
    
    // Set & Get
    
    public int getTreasures() {
    
        return this.treasures;
    
    }
    
    public int getLevel() {
    
        return this.level;
    
    }
    
    
    // Otros métodos
    
    public String toString() {
    
        return "Treasures: " + Integer.toString(treasures) +
                "Level: " + Integer.toString(level);
    
    }
    
    
}
