/*
 * PlayerView.java
 */

package GUI;

import NapakalakiGame.Napakalaki;
import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Vista de un jugador.
 */
public class PlayerView extends JPanel {
    
    private Player playerModel;
    private Napakalaki napakalakiModel;

    public PlayerView() {
        initComponents();
        this.cultistCard.setVisible(false);
        this.cultistCardLabel.setVisible(false);
    }
    
    public void setPlayer(Player p) {
        playerModel = p;
        
        this.canPlayerStealContent.setText(playerModel.canISteal() ? "Sí" : "No");
        this.isPlayerDeadContent.setText(playerModel.isDead() ? "Sí" : "No");
        this.playerCombatLevelContent.setText(Integer.toString(playerModel.getCombatLevel()));
        this.playerEnemyContent.setText(playerModel.getEnemy().getName());
        this.playerLevelContent.setText(Integer.toString(playerModel.getLevel()));
        this.playerNameContent.setText(playerModel.getName());
        this.pendingBadConsequenceView.setPendingBadConsequence(playerModel.getPendingBadConsequence());
        fillTreasurePanel(visibleTreasures, playerModel.getVisibleTreasures());
        fillTreasurePanel(hiddenTreasures, playerModel.getHiddenTreasures());
        
        // Cultist players
        if (playerModel instanceof NapakalakiGame.CultistPlayer) {
            this.cultistCard.setText(Integer.toString(((NapakalakiGame.CultistPlayer) playerModel)
                                                             .getCultistCard().getGainedLevels()));
            this.cultistCard.setVisible(true);
            this.cultistCardLabel.setVisible(true);
        }
        
        revalidate();
        repaint();
    }
    
    public void setNapakalaki(Napakalaki n) {
        napakalakiModel = n;
    }
    
    private void fillTreasurePanel(JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua
        aPanel.removeAll();
        
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas al panel
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure(t);
            aTreasureView.setVisible(true);
            aPanel.add(aTreasureView);
        }
        
        // Se fuerza la actualización visual del panel
        aPanel.revalidate();
        aPanel.repaint();
    }
    
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {
        TreasureView tv;
        ArrayList<Treasure> output = new ArrayList();
        for (Component c : aPanel.getComponents()) {
            tv = (TreasureView) c;
            if ( tv.isSelected() )
                output.add ( tv.getTreasure() );
        }
        return output;
        }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerNameContent = new javax.swing.JLabel();
        playerLevel = new javax.swing.JLabel();
        playerLevelContent = new javax.swing.JLabel();
        isPlayerDead = new javax.swing.JLabel();
        isPlayerDeadContent = new javax.swing.JLabel();
        playerEnemy = new javax.swing.JLabel();
        playerEnemyContent = new javax.swing.JLabel();
        canPlayerSteal = new javax.swing.JLabel();
        canPlayerStealContent = new javax.swing.JLabel();
        playerCombatLevel = new javax.swing.JLabel();
        playerCombatLevelContent = new javax.swing.JLabel();
        cultistCardLabel = new javax.swing.JLabel();
        cultistCard = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        jB_Steal = new javax.swing.JButton();
        jB_Discard = new javax.swing.JButton();
        jB_Visible = new javax.swing.JButton();
        jB_DiscardAll = new javax.swing.JButton();
        pendingBadConsequenceView = new GUI.PendingBadConsequenceView();
        pendingBadLabel = new javax.swing.JLabel();

        playerNameContent.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        playerNameContent.setText("jLabel2");

        playerLevel.setText("Nivel:");

        playerLevelContent.setText("jLabel2");

        isPlayerDead.setText("Muerto:");

        isPlayerDeadContent.setText("jLabel2");

        playerEnemy.setText("Enemigo:");

        playerEnemyContent.setText("jLabel2");

        canPlayerSteal.setText("Puede robar:");

        canPlayerStealContent.setText("jLabel2");

        playerCombatLevel.setText("Nivel de combate:");

        playerCombatLevelContent.setText("jLabel2");

        cultistCardLabel.setText("Carta cultista:");
        cultistCardLabel.setEnabled(false);

        cultistCard.setText("jLabel2");
        cultistCard.setEnabled(false);

        visibleTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        hiddenTreasures.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout hiddenTreasuresLayout = new javax.swing.GroupLayout(hiddenTreasures);
        hiddenTreasures.setLayout(hiddenTreasuresLayout);
        hiddenTreasuresLayout.setHorizontalGroup(
            hiddenTreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );
        hiddenTreasuresLayout.setVerticalGroup(
            hiddenTreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );

        jB_Steal.setText("Robar tesoro");
        jB_Steal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_StealActionPerformed(evt);
            }
        });

        jB_Discard.setText("Descartar tesoros");
        jB_Discard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_DiscardActionPerformed(evt);
            }
        });

        jB_Visible.setText("Hacer tesoro visible");
        jB_Visible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_VisibleActionPerformed(evt);
            }
        });

        jB_DiscardAll.setText("Descartar todo");
        jB_DiscardAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_DiscardAllActionPerformed(evt);
            }
        });

        pendingBadConsequenceView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pendingBadLabel.setText("Mal rollo pendiente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playerLevel)
                        .addGap(18, 18, 18)
                        .addComponent(playerLevelContent))
                    .addComponent(playerNameContent)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(isPlayerDead)
                                .addGap(18, 18, 18)
                                .addComponent(isPlayerDeadContent))
                            .addComponent(playerCombatLevel))
                        .addGap(18, 18, 18)
                        .addComponent(playerCombatLevelContent))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(canPlayerSteal)
                        .addGap(18, 18, 18)
                        .addComponent(canPlayerStealContent))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playerEnemy)
                        .addGap(18, 18, 18)
                        .addComponent(playerEnemyContent))
                    .addComponent(pendingBadLabel)
                    .addComponent(pendingBadConsequenceView, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cultistCardLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cultistCard)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jB_Discard, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jB_DiscardAll, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jB_Steal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jB_Visible, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(playerNameContent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerLevel)
                            .addComponent(playerLevelContent))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerCombatLevel)
                            .addComponent(playerCombatLevelContent))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(isPlayerDeadContent)
                            .addComponent(isPlayerDead))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerEnemy)
                            .addComponent(playerEnemyContent))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(canPlayerSteal)
                            .addComponent(canPlayerStealContent))
                        .addGap(18, 18, 18)
                        .addComponent(pendingBadLabel)
                        .addGap(18, 18, 18)
                        .addComponent(pendingBadConsequenceView, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cultistCardLabel)
                            .addComponent(cultistCard)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jB_Steal)
                            .addComponent(jB_Visible))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jB_Discard)
                            .addComponent(jB_DiscardAll))
                        .addGap(34, 34, 34)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jB_VisibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_VisibleActionPerformed
        ArrayList<Treasure> hiddenTreasuresSelected = getSelectedTreasures(hiddenTreasures);
        napakalakiModel.makeTreasuresVisible(hiddenTreasuresSelected);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_jB_VisibleActionPerformed

    private void jB_StealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_StealActionPerformed
        playerModel.stealTreasure();
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_jB_StealActionPerformed

    private void jB_DiscardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_DiscardActionPerformed
        ArrayList<Treasure> hiddenTreasuresSelected = getSelectedTreasures(hiddenTreasures);
        ArrayList<Treasure> visibleTreasuresSelected = getSelectedTreasures(visibleTreasures);
        napakalakiModel.discardHiddenTreasures(hiddenTreasuresSelected);
        napakalakiModel.discardVisibleTreasures(visibleTreasuresSelected);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_jB_DiscardActionPerformed

    private void jB_DiscardAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_DiscardAllActionPerformed
        playerModel.discardAllTreasures();
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_jB_DiscardAllActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel canPlayerSteal;
    private javax.swing.JLabel canPlayerStealContent;
    private javax.swing.JLabel cultistCard;
    private javax.swing.JLabel cultistCardLabel;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel isPlayerDead;
    private javax.swing.JLabel isPlayerDeadContent;
    private javax.swing.JButton jB_Discard;
    private javax.swing.JButton jB_DiscardAll;
    private javax.swing.JButton jB_Steal;
    private javax.swing.JButton jB_Visible;
    private GUI.PendingBadConsequenceView pendingBadConsequenceView;
    private javax.swing.JLabel pendingBadLabel;
    private javax.swing.JLabel playerCombatLevel;
    private javax.swing.JLabel playerCombatLevelContent;
    private javax.swing.JLabel playerEnemy;
    private javax.swing.JLabel playerEnemyContent;
    private javax.swing.JLabel playerLevel;
    private javax.swing.JLabel playerLevelContent;
    private javax.swing.JLabel playerNameContent;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}
