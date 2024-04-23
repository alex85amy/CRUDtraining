package com.company;

import com.company.util.JsonExport;
import com.company.util.JsonImport;

import java.util.Scanner;

public class CLI {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter command ( --import xxx.json/ --export xxx.json) followed by file name:");

        String input = scanner.nextLine();
        String[] parts = input.split(" ", 2);
        if (parts.length != 2) {
            System.out.println("Invalid input. Please use --import xxx.json/ --export xxx.json");
            return;
        }
        String command = parts[0];
        String fileName = parts[1];
        JsonImport jsonImport = new JsonImport();
        JsonExport jsonExport = new JsonExport();

        if (command.equals("--import")) {
            if (fileName.contains("channel_info")) {
                jsonImport.importChannelInfoBatch(fileName);

            } else if (fileName.contains("channel_tag_mapping")) {
                jsonImport.importChannelTagMappingBatch(fileName);

            } else if (fileName.contains("p_type_2_list")) {
                jsonImport.importPType2Info(fileName);

            } else if (fileName.contains("tag_info")) {
                jsonImport.importTagInfo(fileName);

            } else
                System.out.println("Invalid file name for import.");

        } else if (command.equals("--export")) {
            if (fileName.contains("channel_info")) {
                jsonExport.exportChannelInfo(fileName);

            } else if (fileName.contains("channel_tag_mapping")) {
                jsonExport.exportChannelTagMapping(fileName);

            } else if (fileName.contains("p_type_2_list")) {
                jsonExport.exportPType2Info(fileName);

            } else if (fileName.contains("tag_info")) {
                jsonExport.exportTagInfo(fileName);

            } else
                System.out.println("Invalid file name for export.");

        } else
            System.out.println("Invalid command. Please use --import xxx.json/ --export xxx.json");


//        switch (command) {
//            case "--import":
//                switch (fileName) {
//                    case "channel_info":
//                        jsonImport.importChannelInfoBatch(fileName);
//                        break;
//                    case "channel_tag_mapping":
//                        jsonImport.importChannelTagMappingBatch(fileName);
//                        break;
//                    case "p_type_2_list":
//                        jsonImport.importPType2Info(fileName);
//                        break;
//                    case "tag_info":
//                        jsonImport.importTagInfo(fileName);
//                        break;
//                    default:
//                        System.out.println("Invalid file path for import.");
//                }
//                break;
//            case "--export":
//                switch (fileName) {
//                    case "channel_info.json":
//                        jsonExport.exportChannelInfo();
//                        break;
//                    case "channel_tag_mapping.json":
//                        jsonExport.exportChannelTagMapping();
//                        break;
//                    case "p_type_2_list.json":
//                        jsonExport.exportPType2Info();
//                        break;
//                    case "tag_info.json":
//                        jsonExport.exportTagInfo();
//                        break;
//                    default:
//                        System.out.println("Invalid file path for export.");
//                }
//                break;
//            default:
//                System.out.println("Invalid command. Please use --import xxx.json/ --export xxx.json");
//        }
    }
}
