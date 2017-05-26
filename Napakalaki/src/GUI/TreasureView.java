/*
 * TreasureView.java
 */

package GUI;

import NapakalakiGame.Treasure;
import javax.swing.JPanel;

/**
 * Vista de un tesoro.
 */
public class TreasureView extends JPanel {
    
    private Treasure treasureModel;

    public TreasureView() {
        initComponents();
    }
    
    public void setTreasure(Treasure t) {
        treasureModel = t;
        
        this.nameContent.setText(t.getName());
        this.bonusContent.setText(Integer.toString(t.getBonus()));
        this.typeContent.setText(t.getType().toString());
        
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        nameContent = new javax.swing.JLabel();
        bonus = new javax.swing.JLabel();
        bonusContent = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        typeContent = new javax.swing.JLabel();

        name.setText("Nombre:");

        nameContent.setText("jLabel1");

        bonus.setText("Bonus:");

        bonusContent.setText("jLabel1");

        type.setText("Tipo:");

        typeContent.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(type)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(typeContent))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bonus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bonusContent))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(name)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameContent)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(nameContent))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bonus)
                    .addComponent(bonusContent))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(type)
                    .addComponent(typeContent))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bonus;
    private javax.swing.JLabel bonusContent;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nameContent;
    private javax.swing.JLabel type;
    private javax.swing.JLabel typeContent;
    // End of variables declaration//GEN-END:variables
}
