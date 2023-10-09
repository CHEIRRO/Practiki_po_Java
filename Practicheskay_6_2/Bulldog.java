package Practicheskay_6_2;

public class Bulldog extends Dog {
    public Bulldog(String name, int age) {
        super(name, age);
    }

    @Override
    public void bark() {
        System.out.println("Bulldog named " + super.name + " is barking!");
    }
}