package game.internal;

import game.Board;
import game.Cell;
import game.mover.BlindMover;
import game.mover.CompletionistMover;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static game.Board.COLUMNS;
import static game.Board.ROWS;

public class GameState {
    private Board board;
    private Snake snake;
    private Food food;
    private Set<Cell> cells;
    private int age = 0;

    public GameState(Board board) {
        this.board = board;
        cells = new HashSet<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                cells.add(new Cell(r, c));
            }
        }
        this.snake = new Snake(new Cell(new Random().nextInt(ROWS), new Random().nextInt(COLUMNS)), new CompletionistMover(board));
        this.food = new Food(getRandomFreeCell());
        board.setBody(snake.getBody().getCells());
        board.setFood(food.get());
    }

    public boolean step() {
        age++;
        snake.move(food.get());
        if (snake.hasConsumedFood()) {
            Cell nextFood = getRandomFreeCell();
            if (nextFood != null) {
                food.update(nextFood);
            } else {
                return false;
            }
        }
        board.setBody(snake.getBody().getCells());
        board.setFood(food.get());
        return snake.isAlive();
    }

    public boolean isAlive() {
        return snake.isAlive();
    }

    public int getAge() {
        return age;
    }

    public int getScore() {
        return snake.getBody().getCells().size();
    }

    public Board getBoard() {
        return board;
    }

    private Cell getRandomFreeCell() {
        HashSet<Cell> available = new HashSet<Cell>(cells);
        available.removeAll(snake.getBody().getCells());
        if (available.size() > 0) {
            int item = new Random().nextInt(available.size());
            int i = 0;
            for (Cell c : available) {
                if (i == item) {
                    return c;
                }
                i++;
            }
        }
        return null;
    }
}
