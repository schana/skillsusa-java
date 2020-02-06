public class Mover {
    public static void main(String[] args) {
        Snake snake = new MySnake(new Cell(0, 0), 10, 10);
        while(snake.isAlive()) {
            snake.move(new Cell(5, 5));
            System.out.println(snake);
        }
    }
}
