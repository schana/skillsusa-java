package game;

/**
 * This is the abstract base mover that you'll be extending. It informs the
 * game how your snake should move.
 */
public abstract class SnakeMover {
    protected Board board;

    /**
     * @param board the game board that holds the state of the snake's body,
     *              food location, and the size of the board
     */
    public SnakeMover(Board board) {
        this.board = board;
    }

    /**
     * @return the next direction for your snake to move
     */
    public abstract Direction getNextDirection();
}
