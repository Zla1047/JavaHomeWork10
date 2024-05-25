package org.example;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder csvNew = new StringBuilder();
        boolean isFirstColum = true;

        System.out.println("Edit youre text here: ");

        while (true) {
            String input = scanner.nextLine();

            if ("end".equalsIgnoreCase(input)) {
                break;
            } else if ("next".equalsIgnoreCase(input)) {
                    csvNew.append("\n");
                isFirstColum = true;

            } else {
                if (!isFirstColum) {
                    csvNew.append(", ");
                }
                csvNew.append(input);
                isFirstColum = false;


            }
        }
        try {
            Files.write(Paths.get("output.csv"), csvNew.toString().getBytes());
            System.out.println("File created");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }


    }
}