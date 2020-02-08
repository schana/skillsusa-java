public class MySnake extends Snake {
    public MySnake(Cell head, int rows, int columns) {
        super(head, rows, columns);
    }

    @Override
    public Direction getNextDirection(Cell food) {
        Cell head = body.getHead();
        if (head.getRow() == rows - 1) {
            if (head.getColumn() % 2 == 0) {
                return Direction.RIGHT;
            } else {
                return Direction.UP;
            }
        } else {
            if (head.getRow() == 0) {
                if (head.getColumn() == 0) {
                    return Direction.DOWN;
                } else {
                    return Direction.LEFT;
                }
            } else if (head.getRow() == 1) {
                if (head.getColumn() == columns - 1) {
                    return Direction.UP;
                } else {
                    if (head.getColumn() % 2 == 0) {
                        return Direction.DOWN;
                    } else {
                        return Direction.RIGHT;
                    }
                }
            } else {
                if (head.getColumn() % 2 == 0) {
                    return Direction.DOWN;
                } else {
                    return Direction.UP;
                }
            }
        }
    }
}
