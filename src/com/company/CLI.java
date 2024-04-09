package com.company;

import jakarta.json.*;
import java.io.*;
import java.util.Scanner;

public class CLI{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to CLI Application");
        System.out.println("Available commands:");
        System.out.println("1. import <file_path> - Import JSON data from file");
        System.out.println("2. export <file_path> - Export JSON data to file");
        System.out.println("3. exit - Exit the application");

        boolean running = true;
        while (running) {
            System.out.print(">> ");
            String command = scanner.nextLine().trim();
            String[] parts = command.split(" ");

            switch (parts[0]) {
                case "import":
                    if (parts.length != 2) {
                        System.out.println("Usage: import <file_path>");
                        break;
                    }
                    importData(parts[1]);
                    break;
                case "export":
                    if (parts.length != 2) {
                        System.out.println("Usage: export <file_path>");
                        break;
                    }
                    exportData(parts[1]);
                    break;
                case "exit":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }

        System.out.println("Exiting CLI Application");
        scanner.close();
    }

    private static void importData(String filePath) {
        try (JsonReader reader = Json.createReader(new FileReader(filePath))) {
            JsonObject json = reader.readObject();
            // Process imported JSON data
            System.out.println("JSON data imported successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException | JsonException e) {
            System.out.println("Error reading JSON file: " + e.getMessage());
        }
    }

    private static void exportData(String filePath) {
        // Assume jsonData is a sample JSON object
        JsonObject jsonData = Json.createObjectBuilder()
                .add("key", "value")
                .build();

        try (JsonWriter writer = Json.createWriter(new FileWriter(filePath))) {
            writer.writeObject(jsonData);
            System.out.println("JSON data exported successfully");
        } catch (IOException e) {
            System.out.println("Error writing JSON file: " + e.getMessage());
        }
    }

}

