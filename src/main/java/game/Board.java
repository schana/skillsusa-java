package game;

import java.util.List;

public class Board {
    public static final int ROWS = 10;
    public static final int COLUMNS = 10;
    private List<Cell> body;
    private Cell food;

    public Board() {
    }

    public Cell getHead() {
        return body.get(0);
    }

    public List<Cell> getBody() {
        return body;
    }

    public Cell getFood() {
        return food;
    }

    public void setBody(List<Cell> body) {
        this.body = body;
    }

    public void setFood(Cell food) {
        this.food = food;
    }
}
