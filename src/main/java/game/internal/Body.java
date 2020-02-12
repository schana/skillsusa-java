package game.internal;

import game.Board;
import game.Cell;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Body implements Iterable<Cell> {
    private List<Cell> body;

    public Body(Cell head) {
        this.body = new ArrayList<>();
        this.body.add(head);
    }

    public void move(Cell nextHead, boolean shouldGrow) {
        this.body.add(0, nextHead);
        if (!shouldGrow) {
            this.body.remove(this.body.size() - 1);
        }
    }

    public boolean isValid() {
        // Check for overlaps
        if (new HashSet<>(this.body).size() != body.size()) {
            return false;
        }
        // Check boundaries
        for (Cell cell : body) {
            if (!isBodyPartValid(cell)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBodyPartValid(Cell cell) {
        if (cell.getRow() < 0 || cell.getRow() >= Board.ROWS) {
            return false;
        }
        if (cell.getColumn() < 0 || cell.getColumn() >= Board.COLUMNS) {
            return false;
        }
        return true;
    }

    public List<Cell> getCells() {
        return body;
    }

    public Cell getHead() {
        return body.get(0);
    }

    @Override
    public Iterator<Cell> iterator() {
        return body.iterator();
    }
}
