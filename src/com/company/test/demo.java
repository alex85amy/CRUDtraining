package com.company.test;

import java.sql.*;

public class demo {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/training";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "abc123";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java SimpleCRUDCLI <operation> [<parameters>]");
            return;
        }

        String operation = args[0];
        switch (operation) {
            case "create":
                if (args.length != 3) {
                    System.out.println("Usage: java SimpleCRUDCLI create <name> <age>");
                    return;
                }
                createRecord(args[1], args[2]);
                break;
            case "update":
                if (args.length != 3) {
                    System.out.println("Usage: java SimpleCRUDCLI update <id> <name> <age>");
                    return;
                }
                updateRecord(args[1], args[2]);
                break;
            case "delete":
                if (args.length != 2) {
                    System.out.println("Usage: java SimpleCRUDCLI delete <id>");
                    return;
                }
                deleteRecord(args[1]);
                break;
            case "read":
                if (args.length != 1) {
                    System.out.println("Usage: java SimpleCRUDCLI read");
                    return;
                }
                readRecords();
                break;
            default:
                System.out.println("Invalid operation. Available operations: create, update, delete, read");
                break;
        }
    }

    private static void createRecord(String category, String name) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "INSERT INTO p_type_2_info(category, name) VALUES (" + category + "," + name + ")";
            int rowsAffected = statement.executeUpdate(insertSQL);
            System.out.println(rowsAffected + " row(s) inserted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateRecord(String category, String name) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String updateSQL = "UPDATE p_type_2_info SET category = " + category + ", name = " + name +",FROM p_type_2_info";
            int rowsAffected = statement.executeUpdate(updateSQL);
            System.out.println(rowsAffected + " row(s) updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteRecord(String category) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String deleteSQL = "DELETE FROM p_type_2_info WHERE id = " + category;
            int rowsAffected = statement.executeUpdate(deleteSQL);
            System.out.println(rowsAffected + " row(s) deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void readRecords() {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String selectSQL = "SELECT * FROM p_type_2_info";
            ResultSet resultSet = statement.executeQuery(selectSQL);
            while (resultSet.next()) {
                String category = resultSet.getString("category");
                String name = resultSet.getString("name");
                System.out.println("Category: " + category + ", Name: " + name );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
