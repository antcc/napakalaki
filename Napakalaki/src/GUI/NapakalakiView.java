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
        currentPlayer = new GUI.PlayerView();
        messagesContainer = new javax.swing.JScrollPane();
        messageText = new javax.swing.JTextArea();
        currentMonster = new GUI.MonsterView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);

        jB_combat.setText("Combatir");
        jB_combat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_combatActionPerformed(evt);
            }
        });

        jB_nextTurn.setText("Siguiente turno");
        jB_nextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_nextTurnActionPerformed(evt);
            }
        });

        jB_meetMonster.setText("Mostrar monstruo");
        jB_meetMonster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_meetMonsterActionPerformed(evt);
            }
        });

        currentPlayer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Jugador actual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 14))); // NOI18N

        messagesContainer.setBorder(null);

        messageText.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        messageText.setColumns(20);
        messageText.setLineWrap(true);
        messageText.setRows(5);
        messageText.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mensajes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 14))); // NOI18N
        messagesContainer.setViewportView(messageText);

        currentMonster.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Monstruo actual", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 14))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jB_meetMonster)
                .addGap(18, 18, 18)
                .addComponent(jB_combat)
                .addGap(18, 18, 18)
                .addComponent(jB_nextTurn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 714, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(messagesContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(currentMonster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(currentMonster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(messagesContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_meetMonster)
                    .addComponent(jB_combat)
                    .addComponent(jB_nextTurn))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Napakalaki");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_meetMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_meetMonsterActionPerformed
        // TODO add your handling code here:
        
        this.currentMonster.setMonster(napakalakiModel.getCurrentMonster());
        
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
    }//GEN-LAST:event_jB_combatActionPerformed

    private void jB_nextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_nextTurnActionPerformed
        // TODO add your handling code here:
        napakalakiModel.nextTurn();
        this.currentPlayer.setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_jB_nextTurnActionPerformed

    public void setNapakalaki(Napakalaki n) {
        napakalakiModel = n;
        this.currentPlayer.setPlayer(napakalakiModel.getCurrentPlayer());
        this.currentPlayer.setNapakalaki(napakalakiModel);
        
        revalidate();
        repaint();
    }
        
    public void showView() {
        this.setVisible(true);
    }
    
    public KeyEventDispatcher getKeyEventDispatcher() {
        return kEventDispatcher;
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
