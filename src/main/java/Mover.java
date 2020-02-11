import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;

public class Mover implements ActionListener {
    private Board board;
    private Snake snake;
    private Food food;
    private Base base;
    private Timer timer;
    private static final int DELAY = 50;

    public Mover() {
        food = new Food(new Cell(5, 5));
        snake = new BlindSnake(new Cell(0, 0), 10, 10);
        board = new Board(food, snake);
        base = new Base(board);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        snake.move(food.get());
        if (snake.hasConsumedFood()) {
            HashSet<Cell> available = new HashSet<Cell>(board.getCells());
            available.removeAll(snake.getBody().getCells());
            if (available.size() > 0) {
                int item = new Random().nextInt(available.size());
                int i = 0;
                for (Cell c : available) {
                    if (i == item) {
                        food.update(c);
                        break;
                    }
                    i++;
                }
            } else {
                timer.stop();
            }
        }
        base.repaint();
        if (!snake.isAlive()) {
            timer.stop();
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Mover mover = new Mover();
            mover.base.initialize();
        });
    }
}
