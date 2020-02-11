import java.util.HashSet;
import java.util.Set;

public class Board {
    private int rows = 10;
    private int columns = 10;
    private Snake snake;
    private Food food;
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
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public Set<Cell> getCells() {
        return cells;
    }
}
