package Practicheskay_11;

import java.util.Arrays;

public class MergeSorting {
    public static Student1[] mergeSort(Student1[] arr1, Student1[] arr2) {
        Student1[] merged = new Student1[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i].compareTo(arr2[j]) <= 0) {
                merged[k++] = arr1[i++];
            } else {
                merged[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            merged[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            merged[k++] = arr2[j++];
        }

        return merged;
    }

    public static void main(String[] args) {
        Student1[] students1 = {
                new Student1(3, "Alice",1),
                new Student1(1, "Bob",1),
                new Student1(4, "Eve",1),
                new Student1(2, "Charlie",1)
        };

        Student1[] students2 = {
                new Student1(5, "David",1),
                new Student1(7, "Frank",1),
                new Student1(6, "Grace",1),
                new Student1(8, "Helen",1)
        };

        Arrays.sort(students1);
        Arrays.sort(students2);

        Student1[] mergedStudents = mergeSort(students1, students2);

        for (Student1 student : mergedStudents) {
            System.out.println(student.getIDNumber() + ": " + student.getName());
        }
    }
}

