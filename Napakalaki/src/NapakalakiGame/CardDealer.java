/**
 * CardDealer.java
 */

package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Representa los mazos de cartas.
 * Singleton.
 */
public class CardDealer {
    
    private static CardDealer instance = null;
    
    private ArrayList<Monster> unusedMonsters;
    private ArrayList<Monster> usedMonsters;
    private ArrayList<Treasure> unusedTreasures;
    private ArrayList<Treasure> usedTreasures;
    
    private CardDealer() {
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
    }
    
    private void initTreasureCardDeck() {
        unusedTreasures.add(new Treasure("¡Sí mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigación", 3, TreasureKind.SHOE));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia ácida", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora ACME", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la ETSIIT", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alópodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistórica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato místico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metálica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrocomicón", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicón", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a dos manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrognomicón", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necroplayboycón", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentáculo de pega", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOE));
    }
    
    private void initMonsterCardDeck() {
        BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros" + 
                " visibles", 5, 3, 0);
        Prize prize = new Prize(3,2);
        unusedMonsters.add(new Monster("El rey de rosado", 11, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta "
                + "y te dejan caer en mitad del vuelo. Descarta 1 mano visible y"
                + " 1 mano oculta", 0, 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), 
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Demonios de Magaluf", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta",
        0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Embobado con el lindo primigenio, "
        + "te descartas tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Tenochtitlan", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("El primordial bostezo contagioso. "
        + "Pierdes el calzado visible", 0, new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles",
        0, BadConsequence.MAXTREASURES, 0);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral", 13, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, 
        new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. " + 
                "Descarta la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Necrófago", 13, badConsequence, prize));
        
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Flecher", 2, badConsequence, prize));
        
        badConsequence = new BadConsequence("Estos monstruos resultan bastante " +
                "superficiales y te aburren mortalmente. Estás muerto.", true);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Los Hondos", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes 1 " +
                "mano visible.", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien" +
                " mal su nombre. Estás muerto.", true);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 14, badConsequence, prize));
        
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto.",
                true);
        prize = new Prize(3,1);
        unusedMonsters.add(new Monster("Familia feliz", 1, badConsequence, prize));
        
        badConsequence = new BadConsequence("La quinta directiva primaria te " +
                "obliga a perder 2 niveles y un tesoro 2 manos visible", 2, 
                new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes " +
                "un casco visible.", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList());
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("El espía sordo", 5, badConsequence, prize));
        
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes " +
                "dos niveles y 5 tesoros visibles.", 2, 5, 0);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Tongue", 19, badConsequence, prize));
        
        badConsequence = new BadConsequence("Te faltan manos para tanta " +
                "cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",
                3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,
                        TreasureKind.ONEHAND, TreasureKind.ONEHAND)), new ArrayList());
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Bicéfalo", 21, badConsequence, prize));
    }
    
    private void shuffleTreasures() {
        Collections.shuffle(unusedTreasures);   
    }
    
    private void shuffleMonsters() {
        Collections.shuffle(unusedMonsters);
    }
        
    public static CardDealer getInstance() {
        if (instance == null)
            instance = new CardDealer();
        
        return instance;
    }
    
    public Treasure nextTreasure() {
        if (unusedTreasures.isEmpty()) {
            // swap used & unused
            ArrayList<Treasure> temp;
            temp = unusedTreasures;
            unusedTreasures = usedTreasures;
            usedTreasures = temp;
            
            // shuffle deck
            shuffleTreasures();
        }
        
        // Sacamos el tesoro del final (es más eficiente)
        return unusedTreasures.remove(unusedTreasures.size()-1);
    }
    
    public Monster nextMonster() {
        if (unusedMonsters.isEmpty()) {
            // swap used & unused
            ArrayList<Monster> temp;
            temp = unusedMonsters;
            unusedMonsters = usedMonsters;
            usedMonsters = temp;
            
            // shuffle deck
            shuffleMonsters();
        }
        
        // Sacamos el monstruo del final de la lista (es más eficiente)
        return unusedMonsters.remove(unusedMonsters.size()-1);
    }
    
    public void giveTreasureBack(Treasure t) {
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m) {
        usedMonsters.add(m);
    }
    
    public void initCards() {
        initTreasureCardDeck();
        initMonsterCardDeck();
    }
    
}
