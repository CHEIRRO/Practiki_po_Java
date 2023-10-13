package Practicheskay_13;

import java.io.*;
import java.util.Scanner;

public class AppendToFile {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("D:\\output.txt", true)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите текст для добавления в файл (для завершения введите пустую строку):");
            String line;
            while (!(line = scanner.nextLine()).isEmpty()) {
                writer.write(line + "\n");
            }
            System.out.println("Текст добавлен в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
