/*
 * PendingBadConsequenceView.java
 */

package GUI;

import NapakalakiGame.BadConsequence;
import javax.swing.JPanel;

/**
 * Vista del mal rollo pendiente.
 */
public class PendingBadConsequenceView extends JPanel {

    private BadConsequence pendingBCModel;
    
    public PendingBadConsequenceView() {
        initComponents();
    }
    
    public void setPendingBadConsequence(BadConsequence bc) {
        pendingBCModel = bc;
        if (bc != null) {
            this.textArea.setText(bc.toString());
        }
        else {
            this.textArea.setText("Ninguno");
        }
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textArea = new javax.swing.JLabel();

        textArea.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(textArea, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel textArea;
    // End of variables declaration//GEN-END:variables
}
