package Practicheskay_6_2;

public abstract class Dog {
    public String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void bark();
}
