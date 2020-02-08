import javax.swing.*;
import java.awt.*;

public class Mover extends JFrame {
    private Board board;
    private Snake snake;
    private Food food;

    public Mover() {
        food = new Food(new Cell(5, 5));
        snake = new BlindSnake(new Cell(0, 0), 10, 10);
        board = new Board(food, snake);
    }

    private void initialize() {
        getContentPane().add(board);
        pack();
        setTitle("Snake");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Mover mover = new Mover();
            mover.initialize();
        });
    }
}
