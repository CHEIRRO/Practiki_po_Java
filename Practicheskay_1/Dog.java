package Practicheskay_1;

public class Dog {
    private String name;
    private int age;

    //Конструктор
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public String toString() {
        return "Собака: " + name + ", Возраст: " + age + " лет";
    }

}
