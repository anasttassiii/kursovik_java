import java.awt.Color;
import java.awt.Graphics;

public class Segment {
    private int x, y;

    public Segment(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(x * 16, y * 16, 16, 16);
    }


}