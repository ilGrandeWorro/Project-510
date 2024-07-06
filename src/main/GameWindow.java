package src.main;

import javax.swing.*;

public class GameWindow extends JFrame {
    /**
     * Va a creare la finestra di gioco, cosa ben diversa dal piano di gioco
     * @param gamePanel è il piano di gioco inserito all'interno della finestra.
     * setLocationRelativeTo() indica dove appare la finestra all'avvio del gioco.
     * setVisible() serve per rendere la finestra visibile,
     * è importante metterla in fondo al costruttore per evitare bug visivi.
     */
    public GameWindow(GamePanel gamePanel){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(gamePanel);
        setLocationRelativeTo(null);
        setResizable(false);
        pack();
        setVisible(true);
    }
}
