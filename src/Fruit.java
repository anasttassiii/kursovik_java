import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Fruit {
    public int x, y;
    private Random random;

    public Fruit(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.random = new Random();
    }

    public void respawn(int width, int height) {
        this.x = random.nextInt(width);
        this.y = random.nextInt(height);
    }

    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x * 16, y * 16, 16, 16); // размер ячейки 16х16
    }
}