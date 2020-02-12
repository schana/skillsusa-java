package graphics;

import game.internal.GameState;

import javax.swing.*;

public class Base extends JFrame {
    private final Painter painter;

    public Base(GameState gameState) {
        painter = new Painter(gameState);
    }

    public void setGameState(GameState gameState) {
        painter.setGameState(gameState);
    }

    public void initialize() {
        getContentPane().add(painter);
        pack();
        setTitle("Snake");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
