package Practicheskay_10;

public class TriangularSequence {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java TriangularSequence <n>");
            System.exit(1);
        }

        int n = Integer.parseInt(args[0]);
        int k = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                System.out.print(i + " ");
                if (i == n) {
                    break; // Завершаем выполнение после вывода n элементов
                }
            }
            k++;
        }
    }
}

