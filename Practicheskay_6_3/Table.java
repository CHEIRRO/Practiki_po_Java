package Practicheskay_6_3;

public class Table extends Furniture {
    public Table(String type) {
        super(type);
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a " + super.type + " table.");
    }
}