/*
 * PlayerView.java
 */

package GUI;

import NapakalakiGame.Player;
import NapakalakiGame.Treasure;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * Vista de un jugador.
 */
public class PlayerView extends JPanel {
    
    private Player playerModel;

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
            .addGap(0, 498, Short.MAX_VALUE)
        );
        hiddenTreasuresLayout.setVerticalGroup(
            hiddenTreasuresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );

        jB_Steal.setText("Robar tesoro");

        jB_Discard.setText("Descartar tesoros");

        jB_Visible.setText("Hacer tesoro visible");

        jB_DiscardAll.setText("Descartar todo");

        pendingBadConsequenceView.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pendingBadLabel.setText("Mal rollo pendiente:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(pendingBadConsequenceView, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cultistCardLabel)
                        .addGap(18, 18, 18)
                        .addComponent(cultistCard)
                        .addGap(144, 144, 144)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jB_Discard)
                                .addGap(18, 18, 18)
                                .addComponent(jB_DiscardAll))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jB_Steal)
                                .addGap(18, 18, 18)
                                .addComponent(jB_Visible)))
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
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
                            .addComponent(isPlayerDead)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(visibleTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(hiddenTreasures, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jB_Steal)
                            .addComponent(jB_Visible))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jB_Discard)
                            .addComponent(jB_DiscardAll)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addComponent(cultistCard))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


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
