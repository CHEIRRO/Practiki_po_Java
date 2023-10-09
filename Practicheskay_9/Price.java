package Practicheskay_9;

class Product implements Priceable {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}

// Пример класса, описывающего автомобиль
class Automobile implements Priceable {
    private String brand;
    private double price;

    public Automobile(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
