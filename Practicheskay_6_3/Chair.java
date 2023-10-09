package Practicheskay_6_3;

public class Chair extends Furniture {
    public Chair(String type) {
        super(type);
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a " + super.type + " chair.");
    }
}
