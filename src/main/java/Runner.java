import game.Board;
import game.internal.GameState;
import graphics.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Runner implements ActionListener {
    private static final int DELAY = 50;
    private static final int DEATH_PAUSE = 1000 / DELAY;
    private static final boolean DISPLAY = true;
    private GameState gameState;
    private Board board;
    private Base base;
    private Timer timer;
    private int runs = 0;
    private int deathPause = DEATH_PAUSE;

    public Runner() {
        board = new Board();
        gameState = new GameState(board);
        if (DISPLAY) {
            base = new Base(gameState);
            timer = new Timer(DELAY, this);
            timer.start();
        } else {
            while (runs < 10000) {
                if (gameState.isAlive()) {
                    gameState.step();
                } else {
                    runs++;
                    System.out.println(runs + " Score: " + gameState.getScore() + ", Age: " + gameState.getAge());
                    gameState = new GameState(new Board());
                }
            }
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

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Runner runner = new Runner();
            if (DISPLAY) {
                runner.base.initialize();
            }
        });
    }
}
