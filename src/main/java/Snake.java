public abstract class Snake {
    protected Body body;
    protected final int rows;
    protected final int columns;
    private boolean alive = true;
    private boolean consumedFood = false;

    public Snake(Cell head, int rows, int columns) {
        this.body = new Body(head);
        this.rows = rows;
        this.columns = columns;
    }

    public void move(Cell food) {
        Direction direction = getNextDirection(food);
        Cell nextHead = this.body.getHead().getNeighbor(direction);
        this.consumedFood = nextHead.equals(food);
        this.body.move(nextHead, consumedFood);
        if (!this.body.isValid(this.rows, this.columns)) {
            this.alive = false;
        }
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

    public abstract Direction getNextDirection(Cell food);
}
