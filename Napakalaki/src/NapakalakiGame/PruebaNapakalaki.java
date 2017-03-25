/**
 * PruebaNapakalaki.java
 */

package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Programa de prueba.
 */
public class PruebaNapakalaki {

    private static ArrayList<Monster> monstruos = new ArrayList();
    
    public static ArrayList<Monster> combatLevelOverTen() {
        ArrayList<Monster> res = new ArrayList();
        
        for (Monster tmp : monstruos) {
            if (tmp.getCombatLevel() > 10) {
                res.add(tmp);
            }
        }
        
        return res;
    }
    
    public static ArrayList<Monster> badConsequenceOnlyLevelLoss() {
        ArrayList<Monster> res = new ArrayList();
        
        for (Iterator<Monster> i = monstruos.iterator(); i.hasNext();) {
            Monster tmp = i.next();
            BadConsequence tmpBC = tmp.getBadConsequence();
            
            boolean condition = tmpBC.getLevels() > 0 &&
                                tmpBC.getNHiddenTreasures() == 0 &&
                                tmpBC.getNVisibleTreasures() == 0 &&
                                tmpBC.getSpecificHiddenTreasures().isEmpty() &&
                                tmpBC.getSpecificVisibleTreasures().isEmpty();
            
            if (condition) {
                res.add(tmp);
            }
        }
        
        return res;
    }
    
    public static ArrayList<Monster> levelPrizeGreaterThanOne() {
        ArrayList<Monster> res = new ArrayList();
        
        for (Monster tmp : monstruos) {
            if (tmp.getLevelsGained() > 1) {
                res.add(tmp);
            }
        }
        
        return res;
    }
    
    public static ArrayList<Monster> badConsequenceLosesTreasureKind(TreasureKind treasureKind) {
        ArrayList<Monster> res = new ArrayList();
        
        for (Iterator<Monster> i = monstruos.iterator(); i.hasNext();) {
            Monster tmp = i.next();
            BadConsequence tmpBC = tmp.getBadConsequence();
  
            boolean condition = tmpBC.getSpecificHiddenTreasures().contains(treasureKind) ||
                                tmpBC.getSpecificVisibleTreasures().contains(treasureKind);
            
            if (condition) {
                res.add(tmp);
            }
        }
        
        return res; 
    }
    
    public static void printMonsters(ArrayList<Monster> someMonsters) {
       for(Monster m : someMonsters) {
           System.out.println(m);
           System.out.println();
       }
    }
    
    public static void main(String[] args) {
        
        // Monstruos que salen en el guión de prácticas
        BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros" + 
                " visibles", 5, 3, 0);
        Prize prize = new Prize(3,2);
        monstruos.add(new Monster("El rey de rosado", 11, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta "
                + "y te dejan caer en mitad del vuelo. Descarta 1 mano visible y"
                + " 1 mano oculta", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monstruos.add(new Monster("Demonios de Magaluf", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",
        0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2, 1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Embobado con el lindo primigenio, "
        + "te descartas tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Tenochtitlan", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("El primordial bostezo contagioso. "
        + "Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",
        0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 13, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, 
        new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. " + 
                "Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("Necrófago", 13, badConsequence, prize));
        
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Flecher", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Estos monstruos resultan bastante " +
                "superficiales y te aburren mortalmente. Estás muerto.", true);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Los Hondos", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes 1 " +
                "mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien" +
                " mal su nombre. Estás muerto.", true);
        prize = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 14, badConsequence, prize));
        
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto.",
                true);
        prize = new Prize(3,1);
        monstruos.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        badConsequence = new BadConsequence("La quinta directiva primaria te " +
                "obliga a perder 2 niveles y un tesoro 2 manos visible", 2, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes " +
                "un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        monstruos.add(new Monster("El espía sordo", 5, badConsequence, prize));
        
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes " +
                "dos niveles y 5 tesoros visibles.", 2, 5, 0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Tongue", 19, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te faltan manos para tanta " +
                "cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",
                3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,
                        TreasureKind.ONEHAND, TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2,1);
        monstruos.add(new Monster("Bicéfalo", 21, badConsequence, prize));
        
        // Métodos de prueba
        System.out.println("--- Monstruos con nivel mayor que 10 ---\n");
        printMonsters(combatLevelOverTen());
        System.out.println("--- Monstruos cuyo buen rollo te da más de un nivel ---\n");
        printMonsters(levelPrizeGreaterThanOne());
        System.out.println("--- Monstruos cuyo mal rollo solo te hace perder niveles ---\n");
        printMonsters(badConsequenceOnlyLevelLoss());
        System.out.println("--- Monstruos cuyo mal rollo te hace perder tesoros de armadura ---\n");
        printMonsters(badConsequenceLosesTreasureKind(TreasureKind.ARMOR));
        System.out.println("--- Monstruos cuyo mal rollo te hace perder tesoros de dos manos ---\n");
        printMonsters(badConsequenceLosesTreasureKind(TreasureKind.BOTHHANDS));
        System.out.println("--- Monstruos cuyo mal rollo te hace perder tesoros de casco ---\n");
        printMonsters(badConsequenceLosesTreasureKind(TreasureKind.HELMET));
        System.out.println("--- Monstruos cuyo mal rollo te hace perder tesoros de una mano ---\n");
        printMonsters(badConsequenceLosesTreasureKind(TreasureKind.ONEHAND));
        System.out.println("--- Monstruos cuyo mal rollo te hace perder tesoros de calzado ---\n");
        printMonsters(badConsequenceLosesTreasureKind(TreasureKind.SHOE));
    }
   
}
