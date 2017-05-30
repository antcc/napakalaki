/*
 * TreasureView.java
 */

package GUI;

import NapakalakiGame.Treasure;
import java.awt.Color;
import javax.swing.JPanel;

/**
 * Vista de un tesoro.
 */
public class TreasureView extends JPanel {
    
    private Treasure treasureModel;
    private boolean selected;

    public TreasureView() {
        selected = false;
        this.setBackground(Color.yellow);
        this.setOpaque(false);
        initComponents();
    }
    
    public void setTreasure(Treasure t) {
        treasureModel = t;
        
        this.nameContent.setText(t.getName());
        this.bonusContent.setText("+" + Integer.toString(t.getBonus()));
        this.typeContent.setText(t.getType().toString());
        
        repaint();
    }
    
    public boolean isSelected() {
        return selected;
    }
    
    public Treasure getTreasure() {
        return treasureModel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameContent = new javax.swing.JLabel();
        bonusContent = new javax.swing.JLabel();
        typeContent = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        nameContent.setText("jLabel1");

        bonusContent.setText("jLabel1");

        typeContent.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameContent, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(typeContent, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(bonusContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameContent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bonusContent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(typeContent)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        selected = !selected;
        if (selected) {
            this.setOpaque(true);
        }
        else {
            this.setOpaque(false);
        }
        repaint();
    }//GEN-LAST:event_formMouseClicked

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bonusContent;
    private javax.swing.JLabel nameContent;
    private javax.swing.JLabel typeContent;
    // End of variables declaration//GEN-END:variables
}
