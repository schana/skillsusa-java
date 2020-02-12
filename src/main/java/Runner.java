import game.Board;
import game.internal.GameState;
import graphics.Base;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Runner implements ActionListener {
    private GameState gameState;
    private Board board;
    private Base base;
    private Timer timer;
    private static final int DELAY = 50;
    private int deathPause = 1000 / DELAY;

    public Runner() {
        board = new Board();
        gameState = new GameState(board);
        base = new Base(gameState);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        base.repaint();
        if (gameState.isAlive()) {
            gameState.step();
        } else {
            if (deathPause <= 0) {
                gameState = new GameState(new Board());
                base.setGameState(gameState);
                deathPause = 1000 / DELAY;
            } else {
                deathPause--;
            }
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Runner runner = new Runner();
            runner.base.initialize();
        });
    }
}
