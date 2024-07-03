package src.main;

import src.inputs.KeyBoardInputs;
import src.inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

/**
 * GamePanel è la classe che mostra il quadro di gioco, collega gli input
 * alle figure così che si muovano sullo schermo.
 */
public class GamePanel extends JPanel {
    /**
     * I parametri Delta indicano di quanto spostiamo l'oggetto
     * dalla posizione iniziale
     */
    private int xDelta = 100;
    private int yDelta = 100;
    private int xDelta2 = 100;
    private int yDelta2 = 100;

    /**
     * Gli oggetti Inputs prendono in riferimento questo stesso panel
     */
    public GamePanel() {
        MouseInputs mouseInputs = new MouseInputs(this);
        //Prende gli input della tastiera
        addKeyListener(new KeyBoardInputs(this));
        //prende gli input dei click del mouse
        addMouseListener(mouseInputs);
        //prende gli input del movimento del mouse
        addMouseMotionListener(mouseInputs);
    }

    /**
     * I metodi Delta postano l'oggetto ad una distanza indicata.
     *
     * @param value la distanza aggiunta o rimossa.
     *              repaint() crea un refresh dell'immagine così che possiamo vedere
     *              il movimento effettivo.
     */
    public void changeXDelta(int value) {
        this.xDelta += value;
        repaint();
    }

    public void changeYDelta(int value) {
        this.yDelta += value;
        repaint();
    }

    public void changeXDelta2(int value) {
        this.xDelta2 += value;
        repaint();
    }

    public void changeYDelta2(int value) {
        this.yDelta2 += value;
        repaint();
    }

    /**
     * Muove l'oggetto nella posizione cliccata
     *
     * @param x coordinate orizzontali
     * @param y coordinate verticali
     */
    public void setRectPosition(int x, int y) {
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }

    /**
     * stampa l'oggetto sul quadro
     *
     * @param g the <code>Graphics</code> oggetto da stampare e curare.
     *          SUPER va a dare priorità al metodo paintComponent()
     *          della superclasse JPanel.
     *          fillRect() va a creare un rettangolo pieno, il nostro oggetto g.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(xDelta, yDelta, 200, 50);
    }
}
