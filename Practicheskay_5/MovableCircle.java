package Practicheskay_5;

public class MovableCircle implements Movable {
    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    @Override
    public void moveUp() {
        center.moveUp();
    }

    @Override
    public void moveDown() {
        center.moveDown();
    }

    @Override
    public void moveLeft() {
        center.moveLeft();
    }

    @Override
    public void moveRight() {
        center.moveRight();
    }

    @Override
    public int getXSpeed() {
        return center.getXSpeed();
    }

    @Override
    public int getYSpeed() {
        return center.getYSpeed();
    }

    @Override
    public String toString() {
        return String.format("MovableCircle with center %s and radius %d", center, radius);
    }
}


