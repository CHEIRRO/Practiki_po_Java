package Practicheskay_11;

public class Student1 implements Comparable<Student1> {
    private int iDNumber;
    private String name;
    private double GPA;

    public Student1(int iDNumber, String name, double GPA) {
        this.iDNumber = iDNumber;
        this.name = name;
        this.GPA = GPA;
    }

    public int getIDNumber() {
        return iDNumber;
    }

    public double getGPA(){
        return GPA;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Student1 other) {
        return Integer.compare(this.iDNumber, other.iDNumber);
    }

    public static void insertionSort(Student1[] students) {
        int n = students.length;
        for (int i = 1; i < n; i++) {
            Student1 key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].compareTo(key) > 0) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        Student1[] students = {
                new Student1(3, "Alice",1),
                new Student1(1, "Bob",1),
                new Student1(4, "Eve",1),
                new Student1(2, "Charlie",1)
        };

        insertionSort(students);

        for (Student1 student : students) {
            System.out.println(student.getIDNumber() + ": " + student.getName());
        }
    }
}

