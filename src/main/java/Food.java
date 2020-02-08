public class Food {
    private Cell location;

    public Food(Cell location) {
        this.location = location;
    }

    public void update(Cell location) {
        this.location = location;
    }

    public Cell get() {
        return location;
    }
}
