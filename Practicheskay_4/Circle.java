package Practicheskay_4;

public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    //Пл
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    //Дл
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
}
