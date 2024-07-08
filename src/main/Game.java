package src.main;

import java.io.IOException;

/**
 * In this class we link all the format components and inputs together
 */
public class Game implements Runnable {
    private GamePanel gamePanel;
    private GameWindow gameWindow;
    private Thread gameThread;
    private final int FPS_SET = 120;
    private final int UPS_SET = 200;


    public Game() throws IOException {
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * timePerFrame:double indica la durata della vita dei singoli frame in nanosecondi
     */
    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;
        long prevoiusTime = System.nanoTime();
        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();
        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();
            deltaU += (currentTime - prevoiusTime) / timePerUpdate;
            deltaF +=  (currentTime - prevoiusTime) / timePerFrame;
            prevoiusTime = currentTime;

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }
            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }


            if ((System.currentTimeMillis() - lastCheck) >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    private void update() {
        gamePanel.updateGame();
    }
}
