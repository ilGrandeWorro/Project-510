package src.main;

import src.inputs.KeyBoardInputs;
import src.inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * GamePanel è la classe che mostra il quadro di gioco, collega gli input
 * alle figure così che si muovano sullo schermo.
 */
public class GamePanel extends JPanel {
    /**
     * I parametri Delta indicano di quanto spostiamo l'oggetto
     * dalla posizione iniziale
     */
    private float xDelta = 100;
    private float yDelta = 100;
    private float xDir = 1f;
    private float yDir = 1f;
    private Color color = new Color(64, 130, 109);

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

    }

    public void changeYDelta(int value) {
        this.yDelta += value;
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
        updateRectangle();
        g.setColor(color);
        g.fillRect((int) xDelta, (int) yDelta, 200, 50);

    }

    /**
     * indica i limiti entro i quali l'oggetto può muoversi senza rimbalzare
     *
     * @param delta è la posizione dell'oggetto
     * @param dir   è la direzione che sta prendendo
     * @return ritorna il valore della direzione
     */
    private float changeDirection(float delta, float dir) {
        if (delta > 400 || delta < 0) {
            dir *= -1;
            color = new Color(
                    getRandomValue(),
                    getRandomValue(),
                    getRandomValue());
        }
        return dir;
    }

    /**
     * Crea un valore casuale per l'RGB
     *
     * @return un intero casuale
     */
    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(255);
    }

    /**
     * questo metodo porta a cambiare la direzione dell'oggetto quando tocca il
     * bordo
     */
    private void updateRectangle() {

        xDelta += xDir;
        xDir = changeDirection(xDelta, xDir);

        yDelta += yDir;
        yDir = changeDirection(yDelta, yDir);
    }
}
