package src.inputs;

import src.main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
                gamePanel.changeYDelta(-10);
                break;
            case KeyEvent.VK_A:
                gamePanel.changeXDelta(-10);
                break;
            case KeyEvent.VK_S:
                gamePanel.changeYDelta(10);
                break;
            case KeyEvent.VK_D:
                gamePanel.changeXDelta(10);
                break;
            default:
                break;
        };
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public KeyBoardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
}
