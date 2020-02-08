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

    public boolean contains(Cell cell) {
        return this.body.contains(cell);
    }

    public void move(Cell nextHead, boolean shouldGrow) {
        this.body.add(0, nextHead);
        if (!shouldGrow) {
            this.body.remove(this.body.size() - 1);
        }
    }

    public boolean isValid(int rows, int columns) {
        // Check for overlaps
        if (new HashSet<>(this.body).size() != body.size()) {
            return false;
        }
        // Check boundaries
        for (Cell cell : body) {
            if (!isBodyPartValid(cell, rows, columns)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBodyPartValid(Cell cell, int rows, int columns) {
        if (cell.getRow() < 0 || cell.getRow() >= rows) {
            return false;
        }
        if (cell.getColumn() < 0 || cell.getColumn() >= columns) {
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
