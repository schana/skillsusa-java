package game.mover;

import game.Board;
import game.Direction;

public class MyMover extends SnakeMover {
    public MyMover(Board board) {
        super(board);
    }

    @Override
    public Direction getNextDirection() {
        return Direction.UP;
    }
}
