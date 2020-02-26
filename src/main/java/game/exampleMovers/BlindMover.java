package game.exampleMovers;

import game.Board;
import game.Cell;
import game.Direction;
import game.SnakeMover;

public class BlindMover extends SnakeMover {
    public BlindMover(Board board) {
        super(board);
    }

    @Override
    public Direction getNextDirection() {
        Cell head = board.getHead();
        Cell food = board.getFood();
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
