package Practicheskay_11;
import java.util.Comparator;

import java.util.Comparator;

public class SortingStudentsByGPA implements Comparator<Student1> {
    @Override
    public int compare(Student1 student1, Student1 student2) {
        // Compare students by GPA (assuming students have a getGPA() method)
        return Double.compare(student2.getGPA(), student1.getGPA());
    }

    public static void quickSort(Student1[] students, int low, int high) {
        if (low < high) {
            int pi = partition(students, low, high);
            quickSort(students, low, pi - 1);
            quickSort(students, pi + 1, high);
        }
    }

    public static int partition(Student1[] students, int low, int high) {
        Student1 pivot = students[high];
        int i = low - 1;
        SortingStudentsByGPA comparator = new SortingStudentsByGPA(); // Create an instance of the comparator
        for (int j = low; j < high; j++) {
            if (comparator.compare(students[j], pivot) > 0) { // Use the comparator to compare
                i++;
                Student1 temp = students[i];
                students[i] = students[j];
                students[j] = temp;
            }
        }
        Student1 temp = students[i + 1];
        students[i + 1] = students[high];
        students[high] = temp;
        return i + 1;
    }


    public static void main(String[] args) {
        Student1[] students = {
                new Student1(1, "Alice", 3.8),
                new Student1(2, "Bob", 3.5),
                new Student1(3, "Eve", 4.0),
                new Student1(4, "Charlie", 3.9)
        };

        quickSort(students, 0, students.length - 1);

        for (Student1 student : students) {
            System.out.println(student.getName() + ": " + student.getGPA());
        }
    }
}

