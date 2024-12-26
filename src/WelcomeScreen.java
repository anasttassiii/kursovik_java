import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WelcomeScreen extends JPanel {
    // Загружаем изображение
    Image img = new ImageIcon("res/snake.png").getImage();

    public WelcomeScreen() {


        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    System.exit(0);
                } else {
                    // Начать игру, если нажата любая другая клавиша
                    Game.startGame();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Отображаем изображение перед текстом
        int imageWidth = 200; // Ширина изображения
        int imageHeight = 200; // Высота изображения
        g.drawImage(img, 370, 0, imageWidth, imageHeight, null); // Устанавливаем координаты для отображения изображения

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 50));
        g.drawString("Welcome to Snake Game!", 200, 250);

        g.setFont(new Font("Arial", Font.PLAIN, 30));
        g.drawString("Use arrow keys to control the snake", 260, 290);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Press any key to start the game, Esc to exit", 295, 500);
    }
}