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
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Prize testPrize = new Prize(3, 2);
        TreasureKind testTreasureKind = TreasureKind.ARMOR;
        BadConsequence testBadConsequence = new BadConsequence("Jejeje.", 9, 3, 3);
        Monster testMonster = new Monster("Pikachu", 10, testPrize, testBadConsequence);
        
        System.out.println("testPrize\n" + testPrize.toString() + "\n");
        System.out.println("testBadConsequence\n" + testBadConsequence.toString()  + "\n");
        System.out.println("testMonster\n" + testMonster.toString());
        
    }
    
}
