import javax.swing.*;
import java.awt.*;

public class Painter extends JPanel {
    private Board board;
    private static final int CELL_SIZE = 40;
    private static final int PADDING = 5;
    private static final Color COLOR_BORDER = new Color(100, 100, 100);
    private static final Color COLOR_SNAKE = new Color(180, 180, 180);
    private static final Color COLOR_INVALID = new Color(240, 50, 50);
    private static final Color COLOR_FOOD = new Color(0, 100, 0);

    public Painter(Board board) {
        this.board = board;
        this.setBackground(Color.BLACK);
        this.setPreferredSize(new Dimension(calculateWidth(), calculateHeight()));
    }

    public int calculateWidth() {
        return (2 + board.getColumns()) * CELL_SIZE + (board.getColumns() + 1) * PADDING;
    }

    public int calculateHeight() {
        return (2 + board.getRows()) * CELL_SIZE + (board.getRows() + 1) * PADDING;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gg = (Graphics2D) g;
        paintBoarders(gg);
        paintSnake(gg);
        paintFood(gg);
    }

    private void paintBoarders(Graphics2D gg) {
        gg.setColor(COLOR_BORDER);
        // top
        gg.fillRect(0, 0, calculateWidth(), CELL_SIZE - PADDING);
        // bottom
        gg.fillRect(0, calculateHeight() - CELL_SIZE + PADDING, calculateWidth(), CELL_SIZE - PADDING);
        // left
        gg.fillRect(0, CELL_SIZE - PADDING, CELL_SIZE - PADDING, calculateHeight() - 2 * (CELL_SIZE - PADDING));
        // right
        gg.fillRect(calculateWidth() - CELL_SIZE + PADDING, CELL_SIZE - PADDING, CELL_SIZE - PADDING, calculateHeight() - 2 * (CELL_SIZE - PADDING));
    }

    private void paintSnake(Graphics2D gg) {
        Cell previous = null;
        for (Cell c : board.getSnake().getBody()) {
            gg.setColor(COLOR_SNAKE);
            if (previous != null) {
                if (previous.equals(c.getRight())) {
                    gg.fillRect(CELL_SIZE + previous.getColumn() * (CELL_SIZE + PADDING) - PADDING,
                            CELL_SIZE + c.getRow() * (CELL_SIZE + PADDING) + PADDING,
                            PADDING * 2, CELL_SIZE);
                } else if (previous.equals(c.getLeft())) {
                    gg.fillRect(CELL_SIZE + c.getColumn() * (CELL_SIZE + PADDING) - PADDING,
                            CELL_SIZE + c.getRow() * (CELL_SIZE + PADDING) + PADDING,
                            PADDING * 2, CELL_SIZE);
                } else if (previous.equals(c.getDown())) {
                    gg.fillRect(CELL_SIZE + c.getColumn() * (CELL_SIZE + PADDING) + PADDING,
                            CELL_SIZE + previous.getRow() * (CELL_SIZE + PADDING) - PADDING,
                            CELL_SIZE, PADDING * 2);
                } else {
                    gg.fillRect(CELL_SIZE + c.getColumn() * (CELL_SIZE + PADDING) + PADDING,
                            CELL_SIZE + c.getRow() * (CELL_SIZE + PADDING) - PADDING,
                            CELL_SIZE, PADDING * 2);
                }
            }
            gg.fillRect(CELL_SIZE + PADDING + c.getColumn() * (CELL_SIZE + PADDING),
                    CELL_SIZE + PADDING + c.getRow() * (CELL_SIZE + PADDING), CELL_SIZE, CELL_SIZE);
            previous = c;
        }
        if (!board.getSnake().getBody().isValid(board.getRows(), board.getColumns())) {
            gg.setColor(COLOR_INVALID);
            Cell head = board.getSnake().getBody().getHead();
            gg.fillRect(CELL_SIZE + PADDING + head.getColumn() * (CELL_SIZE + PADDING),
                    CELL_SIZE + PADDING + head.getRow() * (CELL_SIZE + PADDING), CELL_SIZE, CELL_SIZE);
        }
    }

    private void paintFood(Graphics2D gg) {
        gg.setColor(COLOR_FOOD);
        gg.fillRect(CELL_SIZE + PADDING + board.getFood().get().getColumn() * (CELL_SIZE + PADDING),
                CELL_SIZE + PADDING + board.getFood().get().getRow() * (CELL_SIZE + PADDING), CELL_SIZE, CELL_SIZE);
    }
}
