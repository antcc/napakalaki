/**
 * PlayerNamesCapture.java
 */

package GUI;

import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JDialog;

/**
 *
 * @author antcc
 */
public class PlayerNamesCapture extends JDialog {
    
    private ArrayList<String> names;

    public PlayerNamesCapture(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        names = new ArrayList();
        this.setTitle("Jugadores");
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        // custom: añadir KeyListener a los cuadros de texto
        KeyAdapter kListenerPressed = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPressed(e);
            }
        };
        
        textP1.addKeyListener(kListenerPressed);
        textP2.addKeyListener(kListenerPressed);
        textP3.addKeyListener(kListenerPressed);
        
        // custom: mensaje de error.
        labelError.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelP1 = new javax.swing.JLabel();
        labelP2 = new javax.swing.JLabel();
        labelP3 = new javax.swing.JLabel();
        textP1 = new javax.swing.JTextField();
        textP2 = new javax.swing.JTextField();
        textP3 = new javax.swing.JTextField();
        buttonPlay = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();
        labelError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        labelP1.setText("Player 1");

        labelP2.setText("Player 2");

        labelP3.setText("Player 3");

        textP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textP1ActionPerformed(evt);
            }
        });

        textP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textP2ActionPerformed(evt);
            }
        });

        buttonPlay.setText("Play");
        buttonPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPlayActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        labelError.setForeground(new java.awt.Color(191, 32, 46));
        labelError.setText("Introduce al menos dos jugadores distintos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonPlay, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelError)
                    .addComponent(textP1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textP2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textP3, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelP3)
                    .addComponent(labelP1)
                    .addComponent(labelP2))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(labelP1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelP2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(labelP3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPlay)
                    .addComponent(buttonCancel))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textP2ActionPerformed

    private void textP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textP1ActionPerformed

    private void buttonPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPlayActionPerformed
        names.add(textP1.getText());
        names.add(textP2.getText());
        names.add(textP3.getText());
        
        if (names.stream().distinct().filter(s -> !s.isEmpty()).count() < 2) {
            names.clear();
            labelError.setVisible(true);
        }
        
        else {
            this.dispose();
        }
    }//GEN-LAST:event_buttonPlayActionPerformed

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
        System.exit(0);
    }//GEN-LAST:event_buttonCancelActionPerformed

    public ArrayList<String> getNames() {
        this.setVisible(true);
        return names;
    }
    
    private void handleKeyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            buttonPlayActionPerformed(null);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonPlay;
    private javax.swing.JLabel labelError;
    private javax.swing.JLabel labelP1;
    private javax.swing.JLabel labelP2;
    private javax.swing.JLabel labelP3;
    private javax.swing.JTextField textP1;
    private javax.swing.JTextField textP2;
    private javax.swing.JTextField textP3;
    // End of variables declaration//GEN-END:variables
}
