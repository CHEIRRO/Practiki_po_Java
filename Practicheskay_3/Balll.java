package Practicheskay_3;

public class Balll {
    private double x;
    private double y;
    private double xSpeed;
    private double ySpeed;

    // Конструктор
    public Balll(double x, double y, double xSpeed, double ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // Метод для задания положения мяча
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Метод для задания скорости мяча
    public void setXYSpeed(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    // Метод для перемещения мяча
    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

    // Метод toString для вывода информации о мяче
    @Override
    public String toString() {
        return "Ball (" + x + ", " + y + ")";
    }
}