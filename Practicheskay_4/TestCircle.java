package Practicheskay_4;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0); // Создаем экземпляр окружности с радиусом 5.0

        // Выводим радиус, площадь и длину окружности
        System.out.println("Радиус окружности: " + circle.getRadius());
        System.out.println("Площадь окружности: " + circle.calculateArea());
        System.out.println("Длина окружности: " + circle.calculateCircumference());

        // Изменяем радиус и снова выводим площадь и длину окружности
        circle.setRadius(7.0);
        System.out.println("Новый радиус окружности: " + circle.getRadius());
        System.out.println("Новая площадь окружности: " + circle.calculateArea());
        System.out.println("Новая длина окружности: " + circle.calculateCircumference());
    }
}
