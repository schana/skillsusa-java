public class MySnake extends Snake {
    public MySnake(Cell head, int rows, int columns) {
        super(head, rows, columns);
    }

    @Override
    public Direction getNextDirection(Cell food) {
        return Direction.DOWN;
    }
}
