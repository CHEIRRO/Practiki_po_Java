package Practicheskay_13;

import java.io.*;
import java.util.Scanner;

public class WriteToFile {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("D:\\output.txt")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите текст для записи в файл (для завершения введите пустую строку):");
            String line;
            while (!(line = scanner.nextLine()).isEmpty()) {
                writer.write(line + "\n");
            }
            System.out.println("Информация записана в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

