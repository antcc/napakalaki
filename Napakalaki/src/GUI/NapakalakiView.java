/**
 * NapakalakiView.java
 */

package GUI;

import javax.swing.JFrame;
import NapakalakiGame.Napakalaki;
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
        playerView1 = new GUI.PlayerView();
        monsterView1 = new GUI.MonsterView();
        messagesTitleLabel = new javax.swing.JLabel();
        monsterTitleLabel = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();

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

        messagesTitleLabel.setFont(messagesTitleLabel.getFont().deriveFont(messagesTitleLabel.getFont().getStyle() | java.awt.Font.BOLD, messagesTitleLabel.getFont().getSize()+2));
        messagesTitleLabel.setText("Mensajes");

        monsterTitleLabel.setFont(monsterTitleLabel.getFont().deriveFont(monsterTitleLabel.getFont().getStyle() | java.awt.Font.BOLD, monsterTitleLabel.getFont().getSize()+2));
        monsterTitleLabel.setText("Monstruo actual");

        messageLabel.setText("Mensaje");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jB_meetMonster)
                .addGap(18, 18, 18)
                .addComponent(jB_combat)
                .addGap(18, 18, 18)
                .addComponent(jB_nextTurn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(messagesTitleLabel)
                    .addComponent(monsterTitleLabel)
                    .addComponent(messageLabel))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(playerView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(monsterTitleLabel)
                        .addGap(18, 18, 18)
                        .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(messagesTitleLabel)
                        .addGap(18, 18, 18)
                        .addComponent(messageLabel)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jB_meetMonster)
                    .addComponent(jB_combat)
                    .addComponent(jB_nextTurn))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Napakalaki");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_meetMonsterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_meetMonsterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_meetMonsterActionPerformed

    private void jB_combatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_combatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_combatActionPerformed

    private void jB_nextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_nextTurnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jB_nextTurnActionPerformed

    public void setNapakalaki(Napakalaki n) {
        napakalakiModel = n;
        //this.currentPlayer.setPlayer(napakalakiModel.getCurrentPlayer());
        //this.currentPlayer.setNapakalaki(napakalakiModel);
        
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
    private javax.swing.JButton jB_combat;
    private javax.swing.JButton jB_meetMonster;
    private javax.swing.JButton jB_nextTurn;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JLabel messagesTitleLabel;
    private javax.swing.JLabel monsterTitleLabel;
    private GUI.MonsterView monsterView1;
    private GUI.PlayerView playerView1;
    // End of variables declaration//GEN-END:variables
}
