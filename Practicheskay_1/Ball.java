package Practicheskay_1;

public class Ball {
    private String color;
    private double diameter;

    public Ball(String color, double diameter) {
        this.color = color;
        this.diameter = diameter;
    }

    public String getColor() {
        return color;
    }

    public double getDiameter() {
        return diameter;
    }

    public String toString() {
        return "Мяч: Цвет - " + color + ", Диаметр - " + diameter + " см";
    }

}
