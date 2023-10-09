package Practicheskay_4;

class Head {
    private String hairColor;

    public Head(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

}

class Leg {
    private int length;

    public Leg(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}

class Hand {
    private boolean hasFingers;

    public Hand(boolean hasFingers) {
        this.hasFingers = hasFingers;
    }

    public boolean hasFingers() {
        return hasFingers;
    }

    public void setHasFingers(boolean hasFingers) {
        this.hasFingers = hasFingers;
    }

}