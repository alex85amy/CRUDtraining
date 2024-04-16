package com.company;

import com.company.util.JsonExport;
import com.company.util.JsonImport;

import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command ( --import xxx.json/ --export xxx.json) followed by file path:");

        String input = scanner.nextLine();
        String[] parts = input.split(" ", 2);
        if (parts.length != 2) {
            System.out.println("Invalid input. Please use --import xxx.json/ --export xxx.json");
            return;
        }
        String command = parts[0];
        String filePath = parts[1];
        JsonImport jsonImport = new JsonImport();
        JsonExport jsonExport = new JsonExport();

        switch (command) {
            case "--import":
                switch (filePath) {
                    case "channel_info.json":
                        jsonImport.importChannelInfo();
                        break;
                    case "channel_tag_mapping.json":
                        jsonImport.importChannelTagMapping();
                        break;
                    case "p_type_2_list.json":
                        jsonImport.importPType2Info();
                        break;
                    case "tag_info.json":
                        jsonImport.importTagInfo();
                        break;
                    default:
                        System.out.println("Invalid file path for import.");
                }
                break;
            case "--export":
                switch (filePath) {
                    case "channel_info.json":
                        jsonExport.exportChannelInfo();
                        break;
                    case "channel_tag_mapping.json":
                        jsonExport.exportChannelTagMapping();
                        break;
                    case "p_type_2_list.json":
                        jsonExport.exportPType2Info();
                        break;
                    case "tag_info.json":
                        jsonExport.exportTagInfo();
                        break;
                    default:
                        System.out.println("Invalid file path for export.");
                }
                break;
            default:
                System.out.println("Invalid command. Please use --import xxx.json/ --export xxx.json");
        }
    }
}
