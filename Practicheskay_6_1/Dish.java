package Practicheskay_6_1;

public abstract class Dish {
    public String material;

    public Dish(String material) {
        this.material = material;
    }

    public abstract void use();
}