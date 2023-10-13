package Practicheskay_13;

import java.io.*;
import java.util.Scanner;

public class ReplaceInFile {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter("D:\\output.txt", false)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите новый текст для записи в файл (для завершения введите пустую строку):");
            String line;
            while (!(line = scanner.nextLine()).isEmpty()) {
                writer.write(line + "\n");
            }
            System.out.println("Информация в файле заменена.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

