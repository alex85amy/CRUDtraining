package com.company;

import java.io.*;
import java.util.Scanner;

public class CLI{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter command ( --import / --export ) followed by file path:");
        String command = scanner.next();
        String filePath = scanner.next();

        if (command.equals("--import")) {
            importData(filePath);
        } else if (command.equals("--export")) {
            exportData(filePath);
        } else {
            System.out.println("Invalid command. Please use --import or --export.");
        }

        scanner.close();
    }

    private static void importData(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String data;
            while ((data = reader.readLine()) != null) {
                System.out.println("Imported data: " + data);
            }
        } catch (IOException e) {
            System.err.println("Error importing data: " + e.getMessage());
        }
    }

    private static void exportData(String filePath) {

    }
}
