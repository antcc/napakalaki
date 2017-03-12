/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 *
 * @author jmml
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    
    static ArrayList<Monster> monstruos = new ArrayList();
    
    static ArrayList<Monster> combatLevelOverTen() {
        
        ArrayList<Monster> res = new ArrayList();
        
        for (Iterator<Monster> i = monstruos.iterator(); i.hasNext();) {
        
            Monster tmp = i.next();
            
            if (tmp.getCombatLevel() > 10) {
                res.add(tmp);
            
            }
            
        }
        
        return res;
    
    }
    
    static ArrayList<Monster> badConsequenceOnlyLevelLoss() {
        
        ArrayList<Monster> res = new ArrayList();
        
        for (Iterator<Monster> i = monstruos.iterator(); i.hasNext();) {
        
            Monster tmp = i.next();
            BadConsequence tmpBC = tmp.getBadConsequence();
            
            Boolean condition = tmpBC.getLevels() > 0 &&
                                tmpBC.getDeath() == false &&
                                tmpBC.getHiddenTreasures() == 0 &&
                                tmpBC.getVisibleTreasures() == 0 &&
                                tmpBC.getSpecificHiddenTreasures() == null &&
                                tmpBC.getSpecificVisibleTreasures() == null;
            
            
            if (condition) {
                res.add(tmp);
            }
            
        }
        
        return res;
    
    }
    
    static ArrayList<Monster> levelPrizeGreaterThanOne() {
        
        ArrayList<Monster> res = new ArrayList();
        
        for (Iterator<Monster> i = monstruos.iterator(); i.hasNext();) {
        
            Monster tmp = i.next();
            
            if (tmp.getPrize().getLevel() > 1) {
                res.add(tmp);
            }
            
        }
        
        return res;
    
    }
    
    static ArrayList<Monster> badConsequenceLosesTreasureKind(TreasureKind treasureKind) {
        
        ArrayList<Monster> res = new ArrayList();
        
        for (Iterator<Monster> i = monstruos.iterator(); i.hasNext();) {
        
            Monster tmp = i.next();
            BadConsequence tmpBC = tmp.getBadConsequence();
            
            Boolean condition = false;
            
            if (tmpBC.getSpecificHiddenTreasures() != null) {
            
                condition = condition || tmpBC.getSpecificHiddenTreasures().contains(treasureKind);
            
            } else if (tmpBC.getSpecificVisibleTreasures() != null) {
            
                condition = condition || tmpBC.getSpecificVisibleTreasures().contains(treasureKind);
            
            }
            
            if (condition) {
                res.add(tmp);
            }
            
        }
        
        return res;
    
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
     
        
        
        // Monstruos que salen en el guion de prácticas
        BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros" + 
                "visibles", 5, 3, 0);
        Prize prize = new Prize(4,2);
        monstruos.add(new Monster("El rey de rosa", 13, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta "
                + "y te dejan caer en mitad del vuelo. Descarta 1 mano visible y"
                + " 1 mano oculta", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monstruos.add(new Monster("Ángeles de la noche ibicenca", 14, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",
        0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2, 1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Embobado con el lindo primigenio, "
        + "te descartas tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), null);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Tenochtitlan", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("El primordial bostezo contagioso. "
        + "Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOES)), null);
        prize = new Prize(1,1);
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",
        0, Integer.MAX_VALUE, 0);
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 13, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, 
        new ArrayList(Arrays.asList(TreasureKind.ARMOR)), null);
        prize = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. " + 
                "Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), null);
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
                "mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), null);
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
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), null);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes " +
                "un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), null);
        prize = new Prize(1,1);
        monstruos.add(new Monster("El espía sordo", 5, badConsequence, prize));
        
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes " +
                "dos niveles y 5 tesoros visibles.", 2, 5, 0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Tongue", 19, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te faltan manos para tanta " +
                "cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",
                0, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,
                        TreasureKind.ONEHAND, TreasureKind.ONEHAND)), null);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Bicéfalo", 21, badConsequence, prize));
        
        combatLevelOverTen();
        badConsequenceOnlyLevelLoss();
        badConsequenceLosesTreasureKind(TreasureKind.ARMOR);
        badConsequenceLosesTreasureKind(TreasureKind.BOTHHANDS);
        badConsequenceLosesTreasureKind(TreasureKind.HELMET);
        badConsequenceLosesTreasureKind(TreasureKind.ONEHAND);
        badConsequenceLosesTreasureKind(TreasureKind.SHOES);
        
        
    }
    
}
