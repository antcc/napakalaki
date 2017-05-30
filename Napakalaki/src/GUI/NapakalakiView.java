/**
 * NapakalakiView.java
 */

package GUI;

import javax.swing.JFrame;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.CombatResult;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

/**
 * Representa la vista de Napakalaki.
 * Ventana principal de la aplicación.
 */
public class NapakalakiView extends JFrame {
    
    private Napakalaki napakalakiModel;
    
    private KeyEventDispatcher kEventDispatcher = new KeyEventDispatcher() {
        @Override
        public boolean dispatchKeyEvent(KeyEvent e) {
            return dispatchKeyEventHandler(e);
        }
    };
    
    public NapakalakiView(String name) {
        super(name);
        initComponents();
        
        // custom: Add application-wide KeyEventDispatcher
        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(kEventDispatcher);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jB_combat = new javax.swing.JButton();
        jB_nextTurn = new javax.swing.JButton();
        jB_meetMonster = new javax.swing.JButton();
        messagesContainer = new javax.swing.JScrollPane();
        messageText = new javax.swing.JTextArea();
        currentMonster = new GUI.MonsterView();
        jLabel1 = new javax.swing.JLabel();
        jL_numberCultist = new javax.swing.JLabel();
        currentPlayer = new GUI.PlayerView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(4, 0, 800, 800));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1100, 750));
        getContentPane().setLayout(null);

        jB_combat.setText("Combatir");
        jB_combat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_combatActionPerformed(evt);
            }
        });
        getContentPane().add(jB_combat);
        jB_combat.setBounds(200, 700, 120, 38);

        jB_nextTurn.setText("Siguiente turno");
        jB_nextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_nextTurnActionPerformed(evt);
            }
        });
        getContentPane().add(jB_nextTurn);
        jB_nextTurn.setBounds(330, 700, 170, 38);

        jB_meetMonster.setText("Mostrar monstruo");
        jB_meetMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_meetMonsterActionPerformed(evt);
            }
        });
        getContentPane().add(jB_meetMonster);
        jB_meetMonster.setBounds(30, 700, 160, 38);

        messagesContainer.setBorder(null);

        messageText.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        messageText.setColumns(20);
        messageText.setFont(new java.awt.Font("Cantarell", 0, 19)); // NOI18N
        messageText.setLineWrap(true);
        messageText.setRows(5);
        messageText.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mensajes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 14))); // NOI18N
        messagesContainer.setViewportView(messageText);
        messageText.setEditable(false);

        getContentPane().add(messagesContainer);
        messagesContainer.setBounds(1230, 460, 410, 167);

        currentMonster.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monstruo actual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Literation Mono Powerline", 1, 12))); // NOI18N
        getContentPane().add(currentMonster);
        currentMonster.setBounds(1230, 20, 415, 410);

        jLabel1.setText("Número total de sectarios:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1230, 650, 230, 24);

        jL_numberCultist.setText("jLabel2");
        getContentPane().add(jL_numberCultist);
        jL_numberCultist.setBounds(1450, 650, 57, 24);
        getContentPane().add(currentPlayer);
        currentPlayer.setBounds(0, 0, 1216, 690);

        getAccessibleContext().setAccessibleName("Napakalaki");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_meetMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_meetMonsterActionPerformed
        this.currentMonster.setVisible(true);
        this.jB_combat.setEnabled(true);
        this.jB_meetMonster.setEnabled(false);
        this.currentPlayer.changeButtonsState(false);
    }//GEN-LAST:event_jB_meetMonsterActionPerformed

    private void jB_combatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_combatActionPerformed
        CombatResult combatResult = napakalakiModel.developCombat();
        this.jB_nextTurn.setEnabled(true);
        this.jB_combat.setEnabled(false);
        this.jB_meetMonster.setEnabled(false);
        this.currentPlayer.changeButtonsState(true);
          
        switch (combatResult) {
            case WINGAME : 
                this.messageText.setBackground(Color.yellow);
                this.messageText.setText(napakalakiModel.getCurrentPlayer().getName() + ", ¡has ganado la partida!");
                this.jB_nextTurn.setEnabled(false);
                this.currentPlayer.changeButtonsState(false);
                break;
            case WIN :
                this.messageText.setText("¡Has ganado el combate!");
                break;
            case LOSE :
                this.messageText.setText("Has perdido el combate. Te toca cumplir el mal rollo.");
                break;
            case LOSEANDCONVERT :
                this.messageText.setText("Has perdido el combate y te has convertido en sectario. Aún así, te toca cumplir el mal rollo.");
                this.jL_numberCultist.setText(Integer.toString(NapakalakiGame.CultistPlayer.getTotalCultistPlayers()));
                break;
        }
        
        this.currentPlayer.setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_jB_combatActionPerformed

    private void jB_nextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_nextTurnActionPerformed
        boolean nextTurnAllowed = napakalakiModel.nextTurn();
        
        if (nextTurnAllowed) {
            this.setNapakalaki(napakalakiModel);
            this.messageText.setText("");
            this.jB_meetMonster.setEnabled(true);
            this.currentPlayer.changeButtonsState(true);
        }
        else {
            this.messageText.setText("ERROR. O bien te queda un mal rollo por cumplir, o"
                                     + " bien tienes más de 4 tesoros ocultos.");
        }
    }//GEN-LAST:event_jB_nextTurnActionPerformed

    public void setNapakalaki(Napakalaki n) {
        napakalakiModel = n;
        this.currentPlayer.setPlayer(napakalakiModel.getCurrentPlayer());
        this.currentPlayer.setNapakalaki(napakalakiModel);
        this.currentMonster.setMonster(napakalakiModel.getCurrentMonster());
        this.jL_numberCultist.setText(Integer.toString(NapakalakiGame.CultistPlayer.getTotalCultistPlayers()));
        
        this.currentMonster.setVisible(false);
        this.jB_combat.setEnabled(false);
        this.jB_nextTurn.setEnabled(false);
        
        revalidate();
        repaint();
    }
        
    public void showView() {
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Full screen
        this.setVisible(true);
    }
    
    // custom
    private boolean dispatchKeyEventHandler(KeyEvent e) {
        // Salir si se pulsa ESC en cualquier momento
        if (e.getID() == KeyEvent.KEY_PRESSED) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.MonsterView currentMonster;
    private GUI.PlayerView currentPlayer;
    private javax.swing.JButton jB_combat;
    private javax.swing.JButton jB_meetMonster;
    private javax.swing.JButton jB_nextTurn;
    private javax.swing.JLabel jL_numberCultist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextArea messageText;
    private javax.swing.JScrollPane messagesContainer;
    // End of variables declaration//GEN-END:variables
}
