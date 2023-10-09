package Practicheskay_10;

public class From1ToN {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java From1ToN <n>");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);

        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
    }
}

