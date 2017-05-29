/**
 * NapakalakiView.java
 */

package GUI;

import javax.swing.JFrame;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.CombatResult;
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
        jB_combat.setBounds(308, 669, 102, 29);

        jB_nextTurn.setText("Siguiente turno");
        jB_nextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_nextTurnActionPerformed(evt);
            }
        });
        getContentPane().add(jB_nextTurn);
        jB_nextTurn.setBounds(414, 669, 140, 29);

        jB_meetMonster.setText("Mostrar monstruo");
        jB_meetMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_meetMonsterActionPerformed(evt);
            }
        });
        getContentPane().add(jB_meetMonster);
        jB_meetMonster.setBounds(131, 669, 157, 29);

        messagesContainer.setBorder(null);

        messageText.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        messageText.setColumns(20);
        messageText.setLineWrap(true);
        messageText.setRows(5);
        messageText.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mensajes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 14))); // NOI18N
        messagesContainer.setViewportView(messageText);

        getContentPane().add(messagesContainer);
        messagesContainer.setBounds(732, 502, 310, 167);

        currentMonster.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monstruo actual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 14))); // NOI18N
        getContentPane().add(currentMonster);
        currentMonster.setBounds(732, 12, 314, 371);
        getContentPane().add(currentPlayer);
        currentPlayer.setBounds(10, 20, 706, 601);

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
          switch (combatResult) {
            case WINGAME : 
              this.messageText.setText(napakalakiModel.getCurrentPlayer().getName() + ", ¡has ganado la partida!");
              break;
            case WIN :
              this.messageText.setText("¡Has ganado el combate!");
              break;
            case LOSE :
              this.messageText.setText("Has perdido el combate. Te toca cumplir el mal rollo.");
              break;
            case LOSEANDCONVERT :
              this.messageText.setText("Has perdido el combate y te has convertido en sectario. Aún así, te toca cumplir el mal rollo.");
              this.currentPlayer.setPlayer(napakalakiModel.getCurrentPlayer());
              break;
          }
          this.jB_nextTurn.setEnabled(true);
          this.jB_combat.setEnabled(false);
          this.jB_meetMonster.setEnabled(false);
    }//GEN-LAST:event_jB_combatActionPerformed

    private void jB_nextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_nextTurnActionPerformed
        napakalakiModel.nextTurn();
        this.setNapakalaki(napakalakiModel);
        this.messageText.setText("");
        this.jB_combat.setEnabled(false);
        this.jB_nextTurn.setEnabled(false);
        this.jB_meetMonster.setEnabled(true);
        
        this.currentPlayer.changeButtonsState(true);
    }//GEN-LAST:event_jB_nextTurnActionPerformed

    public void setNapakalaki(Napakalaki n) {
        napakalakiModel = n;
        this.currentPlayer.setPlayer(napakalakiModel.getCurrentPlayer());
        this.currentPlayer.setNapakalaki(napakalakiModel);
        this.currentMonster.setMonster(napakalakiModel.getCurrentMonster());
        this.currentMonster.setVisible(false);
        
        this.jB_combat.setEnabled(false);
        this.jB_nextTurn.setEnabled(false);
        
        revalidate();
        repaint();
    }
        
    public void showView() {
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
    private javax.swing.JTextArea messageText;
    private javax.swing.JScrollPane messagesContainer;
    // End of variables declaration//GEN-END:variables
}
