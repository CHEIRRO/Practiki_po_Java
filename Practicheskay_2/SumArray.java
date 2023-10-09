package Practicheskay_2;

public class SumArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        // Используем цикл for
        int sumFor = 0;
        for (int i = 0; i < array.length; i++) {
            sumFor += array[i];
        }
        System.out.println("Сумма чисел массива (for): " + sumFor);

        // Используем цикл while
        int sumWhile = 0;
        int j = 0;
        while (j < array.length) {
            sumWhile += array[j];
            j++;
        }
        System.out.println("Сумма чисел массива (while): " + sumWhile);

        // Используем цикл do while
        int sumDoWhile = 0;
        int k = 0;
        do {
            sumDoWhile += array[k];
            k++;
        } while (k < array.length);
        System.out.println("Сумма чисел массива (do while): " + sumDoWhile);
    }
}