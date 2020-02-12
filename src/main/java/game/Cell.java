package game;

public class Cell {
    private int row;
    private int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Cell getNeighbor(Direction direction) {
        switch (direction) {
            case UP:
                return getUp();
            case DOWN:
                return getDown();
            case LEFT:
                return getLeft();
            case RIGHT:
                return getRight();
        }
        return null;
    }

    public Cell getLeft() {
        return new Cell(getRow(), getColumn() - 1);
    }

    public Cell getRight() {
        return new Cell(getRow(), getColumn() + 1);
    }

    public Cell getUp() {
        return new Cell(getRow() - 1, getColumn());
    }

    public Cell getDown() {
        return new Cell(getRow() + 1, getColumn());
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell other = (Cell) obj;
            return this.row == other.row && this.column == other.column;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return row + column * 10000;
    }
}
