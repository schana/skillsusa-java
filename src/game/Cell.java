package game;

public class Cell {
    private int row;
    private int column;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * Gets a Cell's neighbor in the specified direction. Note that this does
     * not perform any boundary checking and could return invalid cells
     *
     * @param direction the direction of the neighbor
     * @return the neighbor cell in the specified direction
     */
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

    /**
     * Determines equality based on hash
     *
     * @param obj object to compare to
     * @return whether hashes match
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Cell) {
            Cell other = (Cell) obj;
            return this.hashCode() == other.hashCode();
        }
        return false;
    }

    /**
     * Hash calculated based on offset column and row, such that two cells with
     * equal rows and columns will have the same hash code
     *
     * @return simple hash based on row and column
     */
    @Override
    public int hashCode() {
        return row + column * 10000;
    }
}
