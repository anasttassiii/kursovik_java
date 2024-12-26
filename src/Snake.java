import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
    private ArrayList<Segment> body;
    private int direction;

    public Snake(int initialSize) {
        direction = 0; // down
        body = new ArrayList<>();
        for (int i = 0; i < initialSize; i++) {
            body.add(new Segment(10, 10 + i));
        }
    }

    public void move() {
        for (int i = body.size() - 1; i > 0; i--) {
            body.get(i).setPosition(body.get(i - 1).getX(), body.get(i - 1).getY());
        }
        switch (direction) {
            case 0 -> body.get(0).move(0, 1); // down
            case 1 -> body.get(0).move(-1, 0); // left
            case 2 -> body.get(0).move(1, 0); // right
            case 3 -> body.get(0).move(0, -1); // up
        }
    }

    public void grow() {
        body.add(new Segment(-1, -1));
    }

    public void setDirection(int dir) {
        if ((dir == 0 && direction == 3) || (dir == 1 && direction == 2) ||
                (dir == 2 && direction == 1) || (dir == 3 && direction == 0)) {
            return; // Предотвращение движения в противоположном направлении
        }
        direction = dir;
    }

    public ArrayList<Segment> getBody() {
        return body;
    }

    public boolean checkCollisionBounds(int width, int height) {
        Segment head = body.get(0);
        // Проверка, нет ли столкновений с левой, правой, верхней и нижней границами
        return (head.getX() < 0 || head.getX() >= ((width / 16)) || head.getY() < 0 || head.getY() >= ((height / 16)-3));
    }

    public boolean checkSelfCollision() {
        Segment head = body.get(0);
        int flag = 0;
        if (body.size() != 4 ){
            for (int i = 1; i < body.size(); i++) {
                if (head.getX() == body.get(i).getX() && head.getY() == body.get(i).getY()) {
                    flag = 1;
                    break;
                }
            }
        }
        if (flag == 1){
            return true;
        }else return false;

    }

    public int getLength() {
        return body.size();
    }

    public void draw(Graphics g) {
        for (Segment segment : body) {
            segment.draw(g);
        }
    }
}