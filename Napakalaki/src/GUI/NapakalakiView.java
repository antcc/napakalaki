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

        currentPlayer = new GUI.PlayerView();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Napakalaki");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setNapakalaki(Napakalaki n) {
        napakalakiModel = n;
        this.currentPlayer.setPlayer(napakalakiModel.getCurrentPlayer());
        
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
    private GUI.PlayerView currentPlayer;
    // End of variables declaration//GEN-END:variables
}
