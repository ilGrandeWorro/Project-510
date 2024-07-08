package src.inputs;

import src.main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static src.utils.Constants.Directions.*;

/**
 * Prende gli input e li trasferisce sul gamePanel.
 */
public class KeyBoardInputs implements KeyListener {

    private GamePanel gamePanel;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamePanel.setPlayerDirection(UP);
                break;
            case KeyEvent.VK_A:
                gamePanel.setPlayerDirection(LEFT);
                break;
            case KeyEvent.VK_S:
                gamePanel.setPlayerDirection(DOWN);
                break;
            case KeyEvent.VK_D:
                gamePanel.setPlayerDirection(RIGHT);
                break;
        };
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_D, KeyEvent.VK_S, KeyEvent.VK_A:
                gamePanel.setMoving(false);
                break;
        };
    }

    public KeyBoardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
}
