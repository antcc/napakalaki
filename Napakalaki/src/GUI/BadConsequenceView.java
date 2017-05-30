/*
 * BadConsequenceView.java
 */
package GUI;

import NapakalakiGame.BadConsequence;
import javax.swing.JPanel;

/**
 * Representa la vista de un mal rollo.
 */
public class BadConsequenceView extends JPanel {
    
    private BadConsequence badConsequenceModel;

    public BadConsequenceView() {
        initComponents();
    }
    
    public void setBadConsequence(BadConsequence badConsequence) {
        badConsequenceModel = badConsequence; 
        this.text.setText(badConsequenceModel.getText());
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextPane();

        text.setEditable(false);
        text.setFont(new java.awt.Font("Cantarell", 0, 19)); // NOI18N
        text.setBackground(javax.swing.UIManager.getDefaults().getColor("Panel.background"));
        jScrollPane2.setViewportView(text);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane text;
    // End of variables declaration//GEN-END:variables
}
