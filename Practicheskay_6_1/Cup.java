package Practicheskay_6_1;

public class Cup extends Dish {
    public Cup(String material) {
        super(material);
    }

    @Override
    public void use() {
        System.out.println("Using a cup made of " + material);
    }
}