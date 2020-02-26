import game.Board;
import game.internal.GameState;
import game.internal.graphics.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Runner implements ActionListener {
    private static int DELAY;
    private static int DEATH_PAUSE;
    private static boolean DISPLAY;
    private static int RUNS;
    private GameState gameState;
    private Base base;
    private int runs = 0;
    private int deathPause = DEATH_PAUSE;

    public Runner() {
        gameState = new GameState(new Board());
        if (DISPLAY) {
            base = new Base(gameState);
            Timer timer = new Timer(DELAY, this);
            timer.start();
        } else {
            int sumScore = 0;
            int sumAge = 0;
            while (runs < RUNS) {
                if (gameState.isAlive() && gameState.getAge() < 1000) {
                    gameState.step();
                } else {
                    runs++;
                    sumScore += gameState.getScore();
                    sumAge += gameState.getAge();
                    gameState = new GameState(new Board());
                    if (runs % (RUNS / 20) == 0) {
                        System.out.println(100 * runs / RUNS + "% complete");
                    }
                }
            }
            System.out.println("Average Score: " + (double) sumScore / runs + ", Average Age: " + (double) sumAge / runs);
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        base.repaint();
        if (gameState.isAlive()) {
            gameState.step();
        } else {
            if (deathPause <= 0) {
                runs++;
                System.out.println(runs + " Score: " + gameState.getScore() + ", Age: " + gameState.getAge());
                gameState = new GameState(new Board());
                base.setGameState(gameState);
                deathPause = DEATH_PAUSE;
            } else {
                deathPause--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("config.properties"));
        DISPLAY = Boolean.parseBoolean(properties.getProperty("display", "true"));
        DELAY = Integer.parseInt(properties.getProperty("delay", "50"));
        RUNS = Integer.parseInt(properties.getProperty("runs", "1000000"));
        if (DELAY == 0) {
            DEATH_PAUSE = 1000;
        } else {
            DEATH_PAUSE = 1000 / DELAY;
        }

        EventQueue.invokeLater(() -> {
            Runner runner = new Runner();
            if (DISPLAY) {
                runner.base.initialize();
            }
        });
    }
}
