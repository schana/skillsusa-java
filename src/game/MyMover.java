package game;

public class MyMover extends SnakeMover {
    public MyMover(Board board) {
        super(board);
    }

    @Override
    public Direction getNextDirection() {
        return Direction.UP;
    }
}
