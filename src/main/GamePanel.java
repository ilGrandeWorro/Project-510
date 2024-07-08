package src.main;

import src.inputs.KeyBoardInputs;
import src.inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static src.utils.Constants.Directions.*;
import static src.utils.Constants.PlayerConstants.*;

/**
 * GamePanel è la classe che mostra il quadro di gioco, collega gli input
 * alle figure così che si muovano sullo schermo.
 */
public class GamePanel extends JPanel {
    private float xDelta = 100;
    private float yDelta = 100;
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick;
    private int aniIndex;
    private int aniSpeed = 15;
    private int playerAction = IDLE;
    private int playerDirection = -1;
    private boolean moving = false;

    public Dimension setDimension(int w, int h) {
        return new Dimension(w, h);
    }

    public void setPlayerDirection(int playerDirection) {
        this.playerDirection = playerDirection;
        moving = true;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    /**
     * Gli oggetti Inputs prendono in riferimento questo stesso panel
     */
    public GamePanel() throws IOException {
        MouseInputs mouseInputs = new MouseInputs(this);
        importImg();
        loadAnimations();
        setPanelSize();
        //Prende gli input della tastiera
        addKeyListener(new KeyBoardInputs(this));
        //prende gli input dei click del mouse
        addMouseListener(mouseInputs);
        //prende gli input del movimento del mouse
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];
        for (int j = 0; j < animations.length; j++) {
            for (int i = 0; i < animations[j].length; i++) {
                animations[j][i] = createSubImg(i, j);
            }
        }

    }

    private File findMedia(String element) {
        return new File("C:\\Users\\aless\\OneDrive\\Desktop\\Project-510\\src\\media\\1 Biker\\" + element);
    }

    private void importImg() {
        try {
            img = ImageIO.read(findMedia("player_sprites.png"));
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

    public void setMoving(int direction) {

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

        g.drawImage(animations[playerAction][aniIndex], (int) xDelta, (int) yDelta, 128, 80, null);
    }

    private void updatePosition() {
        if(moving){
            switch(playerDirection){
                case LEFT:
                    xDelta -=5;
                    break;
                case UP:
                    yDelta -=5;
                    break;
                case RIGHT:
                    xDelta +=5;
                    break;
                case DOWN:
                    yDelta +=5;
                    break;

            }
        }
    }

    private void setAnimation() {
        if (moving) {
            playerAction = RUNNING;
        } else {
            playerAction = IDLE;
        }
    }


    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= getSprayAmounts(playerAction)) {
                aniIndex = 0;
            }
        }
    }

    private BufferedImage createSubImg(int xCut, int yCut) {
        int w = 64;
        int h = 40;
        return img.getSubimage(xCut * w, yCut * h, w, h);
    }

    public void updateGame(){
        updateAnimationTick();
        setAnimation();
        updatePosition();
    }
}
