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
        if (!this.body.isValid(this.rows, this.columns)){
            this.alive = false;
        }
    }

    public boolean hasConsumedFood() {
        return this.consumedFood;
    }

    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        for(int c=0; c<columns; c++){
            sb.append(" - ");
        }
        sb.append("+\n");
        for(int r=0; r<rows; r++) {
            sb.append('|');
            for(int c=0; c<columns; c++){
                if(body.contains(new Cell(r, c))) {
                    sb.append(" X ");
                }else{
                    sb.append("   ");
                }
            }
            sb.append("|\n");
        }
        sb.append('+');
        for(int c=0; c<columns; c++){
            sb.append(" - ");
        }
        sb.append("+\n");
        return sb.toString();
    }

    public abstract Direction getNextDirection(Cell food);
}
