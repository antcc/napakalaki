/*
 * TreasureView.java
 */

package GUI;

import NapakalakiGame.Prize;
import javax.swing.JPanel;

/**
 * Representa la vista de una recompensa.
 */
public class PrizeView extends JPanel {
    
    private Prize prizeModel;

    public PrizeView() {
        initComponents();
    }
    
    public void setPrize(Prize prize) {
        prizeModel = prize;
        
        this.treasures.setText(Integer.toString(prize.getTreasures()) + " tesoros");
        this.levels.setText(Integer.toString(prize.getLevels()) + " niveles");
        
        repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        treasuresLabel = new javax.swing.JLabel();
        levelsLabel = new javax.swing.JLabel();
        levels = new javax.swing.JLabel();
        treasures = new javax.swing.JLabel();

        treasuresLabel.setFont(treasuresLabel.getFont().deriveFont(treasuresLabel.getFont().getStyle() | java.awt.Font.BOLD, treasuresLabel.getFont().getSize()+2));
        treasuresLabel.setText("Tesoros");

        levelsLabel.setFont(levelsLabel.getFont().deriveFont(levelsLabel.getFont().getStyle() | java.awt.Font.BOLD, levelsLabel.getFont().getSize()+2));
        levelsLabel.setText("Niveles ganados");

        levels.setText("0 niveles");

        treasures.setText("0 tesoros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(levelsLabel)
                    .addComponent(treasuresLabel)
                    .addComponent(levels)
                    .addComponent(treasures))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(treasuresLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(treasures)
                .addGap(18, 18, 18)
                .addComponent(levelsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(levels)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel levels;
    private javax.swing.JLabel levelsLabel;
    private javax.swing.JLabel treasures;
    private javax.swing.JLabel treasuresLabel;
    // End of variables declaration//GEN-END:variables
}
