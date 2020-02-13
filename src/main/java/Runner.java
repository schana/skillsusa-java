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
            while (runs < 1000000) {
                if (gameState.isAlive() && gameState.getAge() < 1000) {
                    gameState.step();
                } else {
                    runs++;
                    sumScore += gameState.getScore();
                    sumAge += gameState.getAge();
                    //System.out.println(runs + " Score: " + gameState.getScore() + ", Age: " + gameState.getAge());
                    gameState = new GameState(new Board());
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

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Runner runner = new Runner();
            if (DISPLAY) {
                runner.base.initialize();
            }
        });
    }
}
