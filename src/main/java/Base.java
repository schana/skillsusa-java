import javax.swing.*;

public class Base extends JFrame {
    private final Painter painter;

    public Base(Board board) {
        painter = new Painter(board);
    }

    public void initialize() {
        getContentPane().add(painter);
        pack();
        setTitle("Snake");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
