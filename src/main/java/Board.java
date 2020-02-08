import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Board extends JPanel implements ActionListener {
    private int rows = 10;
    private int columns = 10;
    private int cellSize = 40;
    private int padding = 5;
    private Snake snake;
    private Food food;
    private Timer timer;
    private final int DELAY = 50;
    private Set<Cell> cells;

    public Board(Food food, Snake snake) {
        this.food = food;
        this.snake = snake;
        cells = new HashSet<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                cells.add(new Cell(r, c));
            }
        }
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(calculateWidth(), calculateHeight()));
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public int calculateWidth() {
        return (2 + columns) * cellSize + (columns + 1) * padding;
    }

    public int calculateHeight() {
        return (2 + rows) * cellSize + (rows + 1) * padding;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        gg.setColor(new Color(100, 100, 100));
        // top
        gg.fillRect(0, 0, calculateWidth(), cellSize - padding);
        // bottom
        gg.fillRect(0, calculateHeight() - cellSize + padding, calculateWidth(), cellSize - padding);
        // left
        gg.fillRect(0, cellSize - padding, cellSize - padding, calculateHeight() - 2 * (cellSize - padding));
        // right
        gg.fillRect(calculateWidth() - cellSize + padding, cellSize - padding, cellSize - padding, calculateHeight() - 2 * (cellSize - padding));
        Cell previous = null;
        for (Cell c : snake.getBody()) {
            gg.setColor(new Color(180, 180, 180));
            if (previous != null) {
                if (previous.equals(c.getRight())) {
                    gg.fillRect(cellSize + previous.getColumn() * (cellSize + padding) - padding,
                            cellSize + c.getRow() * (cellSize + padding) + padding,
                            padding * 2, cellSize);
                } else if (previous.equals(c.getLeft())) {
                    gg.fillRect(cellSize + c.getColumn() * (cellSize + padding) - padding,
                            cellSize + c.getRow() * (cellSize + padding) + padding,
                            padding * 2, cellSize);
                } else if (previous.equals(c.getDown())) {
                    gg.fillRect(cellSize + c.getColumn() * (cellSize + padding) + padding,
                            cellSize + previous.getRow() * (cellSize + padding) - padding,
                            cellSize, padding * 2);
                } else {
                    gg.fillRect(cellSize + c.getColumn() * (cellSize + padding) + padding,
                            cellSize + c.getRow() * (cellSize + padding) - padding,
                            cellSize, padding * 2);
                }
            }
            gg.fillRect(cellSize + padding + c.getColumn() * (cellSize + padding),
                    cellSize + padding + c.getRow() * (cellSize + padding), cellSize, cellSize);
            previous = c;
        }
        if (!snake.getBody().isValid(rows, columns)) {
            gg.setColor(new Color(240, 50, 50));
            Cell head = snake.getBody().getHead();
            gg.fillRect(cellSize + padding + head.getColumn() * (cellSize + padding),
                    cellSize + padding + head.getRow() * (cellSize + padding), cellSize, cellSize);
        }
        gg.setColor(new Color(0, 100, 0));
        gg.fillRect(cellSize + padding + food.get().getColumn() * (cellSize + padding),
                cellSize + padding + food.get().getRow() * (cellSize + padding), cellSize, cellSize);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        snake.move(food.get());
        if (snake.hasConsumedFood()) {
            HashSet<Cell> available = new HashSet<Cell>(cells);
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
        repaint();
        if (!snake.isAlive()) {
            timer.stop();
        }
    }
}
