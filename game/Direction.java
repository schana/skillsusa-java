package game;

/**
 * Enum representing the possible directions for the snake to move
 */
public enum Direction {
    UP("u"),
    DOWN("d"),
    LEFT("l"),
    RIGHT("r");

    private final String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return this.direction;
    }
}
