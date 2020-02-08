public class BlindSnake extends Snake {
    public BlindSnake(Cell head, int rows, int columns) {
        super(head, rows, columns);
    }

    @Override
    public Direction getNextDirection(Cell food) {
        Cell head = getBody().getHead();
        if (head.getRow() > food.getRow()) {
            return Direction.UP;
        } else if (head.getRow() < food.getRow()) {
            return Direction.DOWN;
        } else if (head.getColumn() > food.getColumn()) {
            return Direction.LEFT;
        } else {
            return Direction.RIGHT;
        }
    }
}
