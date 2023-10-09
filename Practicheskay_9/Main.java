package Practicheskay_9;

public class Main {
    public static void main(String[] args) {
        Planet earth = new Planet("Earth");
        Car bmw = new Car("BMW");
        Animal dog = new Animal("Dog");

        System.out.println("Planet name: " + earth.getName());
        System.out.println("Car name: " + bmw.getName());
        System.out.println("Animal name: " + dog.getName());
    }
}