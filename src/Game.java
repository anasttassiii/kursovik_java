import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Game extends JPanel implements ActionListener {
    private final int N = 70; // Количество ячеек по горизонтали
    private final int M = 40; /// Количество ячеек по вертикали
    private final int size = 16; // Размер одной ячейки
    private Snake snake;
    private Fruit fruit;
    private Timer timer;
    private boolean isGameOver;
    private int score;


    public Game() {
        snake = new Snake(4);
        fruit = new Fruit(10, 10);
        fruit.respawn(N, M - 3);
        isGameOver = false;
        score = 0;


        timer = new Timer(100, this);
        timer.start();

        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> snake.setDirection(1);
                    case KeyEvent.VK_RIGHT -> snake.setDirection(2);
                    case KeyEvent.VK_UP -> snake.setDirection(3);
                    case KeyEvent.VK_DOWN -> snake.setDirection(0);
                    case KeyEvent.VK_G -> restartGame();
                    case KeyEvent.VK_ESCAPE -> System.exit(0);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (isGameOver) {
            drawGameOver(g);
        } else {
            snake.draw(g);
            fruit.draw(g);
            g.setColor(Color.BLACK);
            g.drawString("Score: " + score, 10, 20);
        }
    }

    private void drawGameOver(Graphics g) {
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("Game Over", N * size / 2 - 150, M * size / 2 - 30);
        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("Score: " + score, N * size / 2 - 50, M * size / 2 + 10);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameOver) {
            snake.move();
            if (snake.checkCollisionBounds(N * size, M * size)) {
                isGameOver = true;
            }
            if (snake.checkSelfCollision()) {
                isGameOver = true;
            }
            if (snake.getBody().get(0).getX() == fruit.x && snake.getBody().get(0).getY() == fruit.y) {
                snake.grow();
                fruit.respawn(N, M - 10);
                score++;
            }

            if (snake.getLength() < 1) {
                isGameOver = true;
            }
            repaint();
        }
    }

    private void restartGame() {


        score = 0; // Reset score for new game
        isGameOver = false;
        snake = new Snake(4);
        fruit.respawn(N - 3, M - 3);
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake Game");
        Game game = new Game();
        frame.add(game);
        frame.setSize(1136, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}