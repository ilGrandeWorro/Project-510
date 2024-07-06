package src.main;

import src.inputs.KeyBoardInputs;
import src.inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * GamePanel è la classe che mostra il quadro di gioco, collega gli input
 * alle figure così che si muovano sullo schermo.
 */
public class GamePanel extends JPanel {
    private float xDelta = 100;
    private float yDelta = 100;
    private BufferedImage img;
    private BufferedImage subImg;

    public Dimension setDimension(int w, int h) {
        return new Dimension(w, h);
    }

    /**
     * Gli oggetti Inputs prendono in riferimento questo stesso panel
     */
    public GamePanel() throws IOException {
        MouseInputs mouseInputs = new MouseInputs(this);
        importImg();
        setPanelSize();
        //Prende gli input della tastiera
        addKeyListener(new KeyBoardInputs(this));
        //prende gli input dei click del mouse
        addMouseListener(mouseInputs);
        //prende gli input del movimento del mouse
        addMouseMotionListener(mouseInputs);
    }

    private File findMedia(String element) {
        return new File("C:\\Users\\aless\\OneDrive\\Desktop\\Project-510\\src\\media\\1 Biker\\" + element);
    }

    private void importImg() {
        try {
            img = ImageIO.read(findMedia("Biker_idle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPanelSize() {
        Dimension size = setDimension(1280, 800);
        setMinimumSize(size);
        setMaximumSize(size);
        setPreferredSize(size);
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
        subImg = createSubImg(0, 0);
        g.drawImage(subImg, (int)xDelta, (int)yDelta, 60, 96, null);
    }

    private BufferedImage createSubImg(int xCut, int yCut) {
        int w = 30;
        int h = 48;
        return img.getSubimage(xCut * w, yCut * h, w, h);
    }

}
