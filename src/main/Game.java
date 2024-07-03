package src.main;

/**
 * In this class we link all the format components and inputs together
 */
public class Game {

    public Game() {
        GamePanel gamePanel = new GamePanel();
        GameWindow gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
    }
}
