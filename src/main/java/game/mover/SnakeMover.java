package game.mover;

import game.Board;
import game.Direction;

public abstract class SnakeMover {
    protected Board board;

    public SnakeMover(Board board) {
        this.board = board;
    }

    public abstract Direction getNextDirection();
}
