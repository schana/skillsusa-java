package game.exampleMovers;

import game.Board;
import game.Cell;
import game.Direction;
import game.SnakeMover;

public class CompletionistMover extends SnakeMover {

    public CompletionistMover(Board board) {
        super(board);
    }

    @Override
    public Direction getNextDirection() {
        Cell head = board.getHead();
        if (head.getRow() == Board.ROWS - 1) {
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
                if (head.getColumn() == Board.COLUMNS - 1) {
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
