package com.company;

import com.company.util.JsonExportService;
import com.company.util.JsonImportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        JsonImportService jsonImportService = new JsonImportService();
        JsonExportService jsonExportService = new JsonExportService();
        Logger logger = LogManager.getLogger();


        if (command.equals("--import")) {
            if (fileName.contains("channel_info")) {
                jsonImportService.importChannelInfo(fileName);
                logger.info("import channel_info");

            } else if (fileName.contains("channel_tag_mapping")) {
                jsonImportService.importChannelTagMapping(fileName);
                logger.info("import channel_tag_mapping");

            } else if (fileName.contains("p_type_2_list")) {
                jsonImportService.importPType2Info(fileName);
                logger.info("import p_type_2_list");

            } else if (fileName.contains("tag_info")) {
                jsonImportService.importTagInfo(fileName);
                logger.info("import tag_info");

            } else
                System.out.println("Invalid file name for import.");

        } else if (command.equals("--export")) {
            if (fileName.contains("channel_info")) {
                jsonExportService.exportChannelInfo(fileName);
                logger.info("export channel_info");

            } else if (fileName.contains("channel_tag_mapping")) {
                jsonExportService.exportChannelTagMapping(fileName);
                logger.info("export channel_tag_mapping");

            } else if (fileName.contains("p_type_2_list")) {
                jsonExportService.exportPType2Info(fileName);
                logger.info("export p_type_2_list");

            } else if (fileName.contains("tag_info")) {
                jsonExportService.exportTagInfo(fileName);
                logger.info("export tag_info");

            } else
                System.out.println("Invalid file name for export.");

        } else
            System.out.println("Invalid command. Please use --import xxx.json/ --export xxx.json");


//        switch (command) {
//            case "--import":
//                switch (fileName) {
//                    case "channel_info":
//                        jsonImportService.importChannelInfoBatch(fileName);
//                        break;
//                    case "channel_tag_mapping":
//                        jsonImportService.importChannelTagMappingBatch(fileName);
//                        break;
//                    case "p_type_2_list":
//                        jsonImportService.importPType2Info(fileName);
//                        break;
//                    case "tag_info":
//                        jsonImportService.importTagInfo(fileName);
//                        break;
//                    default:
//                        System.out.println("Invalid file path for import.");
//                }
//                break;
//            case "--export":
//                switch (fileName) {
//                    case "channel_info.json":
//                        jsonExportService.exportChannelInfo();
//                        break;
//                    case "channel_tag_mapping.json":
//                        jsonExportService.exportChannelTagMapping();
//                        break;
//                    case "p_type_2_list.json":
//                        jsonExportService.exportPType2Info();
//                        break;
//                    case "tag_info.json":
//                        jsonExportService.exportTagInfo();
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
