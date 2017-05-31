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

    private BadConsequence pendingBCModel = null;
    
    public PendingBadConsequenceView() {
        initComponents();
    }
    
    public void setPendingBadConsequence(BadConsequence bc) {
        pendingBCModel = bc;
        if (bc != null && !bc.isEmpty()) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        textArea.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Cantarell", 0, 19)); // NOI18N
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        textArea.setBorder(null);
        textArea.setEditable(false);
        jScrollPane1.setViewportView(textArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
