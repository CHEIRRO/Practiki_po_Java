package Practicheskay_6_1;

public class Plate extends Dish {
    public Plate(String material) {
        super(material);
    }

    @Override
    public void use() {
        System.out.println("Using a plate made of " + material);
    }
}