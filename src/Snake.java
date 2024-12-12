public class Snake {
    private ArrayList<Segment> body;
    private int direction;

    public Snake(int initialSize) {
        direction = 0; // down
        body = new ArrayList<>();
    }

    public void move() {

    }

    public void grow() {

    }
    public ArrayList<Segment> getBody() {
        return body;
    }

    public boolean checkCollisionBounds(int width, int height) {
    }

    public boolean checkSelfCollision() {

    }

    public int getLength() {
        return body.size();
    }

    public void draw() {

    }
}