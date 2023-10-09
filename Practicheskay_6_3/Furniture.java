package Practicheskay_6_3;

public abstract class Furniture {
    public String type;

    public Furniture(String type) {
        this.type = type;
    }

    public abstract void assemble();
}

