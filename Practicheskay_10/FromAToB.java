package Practicheskay_10;

public class  FromAToB {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java FromAToB <A> <B>");
            System.exit(1);
        }

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        if (a < b) {
            for (int i = a; i <= b; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (int i = a; i >= b; i--) {
                System.out.print(i + " ");
            }
        }
    }
}

