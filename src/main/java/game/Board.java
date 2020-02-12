package game;

import java.util.List;

/**
 * This holds the current game state. The board is in a grid shape with 0-based
 * row and column indices represented by (row, column) Cells:
 *
 * (0, 0), (0, 1), (0, 2), ..., (0, COLUMNS - 1)
 * (1, 0), (1, 1), (1, 2), ..., (1, COLUMNS - 1)
 * ...
 * (ROWS - 1, 0), (ROWS - 1, 1), ..., (ROWS - 1, COLUMNS - 1)
 */
public class Board {
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;
    private List<Cell> body;
    private Cell food;

    public Board() {
    }

    /**
     * @return the Cell representing the head of the snake
     */
    public Cell getHead() {
        return body.get(0);
    }

    /**
     * @return the list of cells making up the snake, including the head
     */
    public List<Cell> getBody() {
        return body;
    }

    /**
     * @return the Cell representing the location of the food
     */
    public Cell getFood() {
        return food;
    }

    /**
     * function used by the internal game logic to set the current state
     */
    public void setBody(List<Cell> body) {
        this.body = body;
    }

    /**
     * function used by the internal game logic to set the current state
     */
    public void setFood(Cell food) {
        this.food = food;
    }
}
