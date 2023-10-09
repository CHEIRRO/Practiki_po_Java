package Practicheskay_9;

public class Main2 {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", 999.99);
        Automobile tesla = new Automobile("Tesla Model 3", 49999.99);

        System.out.println("Product price: $" + laptop.getPrice());
        System.out.println("Automobile price: $" + tesla.getPrice());
    }
}
