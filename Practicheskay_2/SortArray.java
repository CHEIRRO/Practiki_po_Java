package Practicheskay_2;

import java.util.Arrays;
import java.util.Random;

public class SortArray {
    public static void main(String[] args) {
        int[] numbers = generateRandomArray(10);
        System.out.println("Исходный массив: " + Arrays.toString(numbers));

        Arrays.sort(numbers);
        System.out.println("Отсортированный массив: " + Arrays.toString(numbers));
    }

    public static int[] generateRandomArray(int length) {
        int[] array = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }
}

