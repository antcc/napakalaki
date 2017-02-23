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
public class Monster {
    
    private String name;
    private int combatLevel;
    
    private Prize prize;
    private BadConsequence badConsequence;
    
    //// Constructores
    
    public Monster(String name, int combatLevel, Prize prize, BadConsequence badConsequence) {
    
        this.name = name;
        this.combatLevel = combatLevel;
        this.prize = prize;
        this.badConsequence = badConsequence;
    
    } 
    
    //// Métodos
    
    // Set & Get
    
    public String getName() {
    
        return name;
    
    }
    
    public int getCombatLevel() {
    
        return combatLevel;
    
    }
    
    public Prize getPrize() {
    
        return prize;
    
    }
    
    public BadConsequence getBadConsequence() {
    
        return badConsequence;
    
    }
    
    // Otros métodos
    
    public String toString() {
    
        return "Name: " + name + "Level: " + Integer.toString(combatLevel) +
                "Prizes: " + prize.toString() + "Bad consequence: " +
                badConsequence.toString();
    
    }
}
