package Practicheskay_6_2;

public class Labrador extends Dog {
    public Labrador(String name, int age) {
        super(name, age);
    }

    @Override
    public void bark() {
        System.out.println("Labrador named " + super.name + " is barking!");
    }
}