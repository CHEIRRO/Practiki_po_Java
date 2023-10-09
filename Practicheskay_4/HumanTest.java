package Practicheskay_4;

public class HumanTest {
    public static void main(String[] args) {
        Head head = new Head("Brown");
        Leg leftLeg = new Leg(80);
        Leg rightLeg = new Leg(80);
        Hand leftHand = new Hand(true);
        Hand rightHand = new Hand(true);

        Human person = new Human(head, leftLeg, rightLeg, leftHand, rightHand);

        System.out.println("Информация о человеке:");
        System.out.println("Цвет волос: " + person.getHead().getHairColor());
        System.out.println("Длина левой ноги: " + person.getLeftLeg().getLength() + " см");
        System.out.println("Длина правой ноги: " + person.getRightLeg().getLength() + " см");
        System.out.println("Есть ли пальцы на левой руке: " + person.getLeftHand().hasFingers());
        System.out.println("Есть ли пальцы на правой руке: " + person.getRightHand().hasFingers());
    }
}

