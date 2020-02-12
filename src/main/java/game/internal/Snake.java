package game.internal;

import game.Cell;
import game.Direction;
import game.mover.SnakeMover;

public class Snake {
    private Body body;
    private SnakeMover mover;
    private boolean alive = true;
    private boolean consumedFood = false;

    public Snake(Cell head, SnakeMover mover) {
        this.body = new Body(head);
        this.mover = mover;
    }

    public void move(Cell food) {
        Direction direction = mover.getNextDirection();
        Cell nextHead = this.body.getHead().getNeighbor(direction);
        this.consumedFood = nextHead.equals(food);
        this.body.move(nextHead, consumedFood);
        this.alive = this.alive && this.body.isValid();
    }

    public boolean hasConsumedFood() {
        return this.consumedFood;
    }

    public boolean isAlive() {
        return this.alive;
    }

    public Body getBody() {
        return body;
    }
}
