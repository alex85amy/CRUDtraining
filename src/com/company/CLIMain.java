package com.company;

import com.company.service.JsonExportService;
import com.company.service.JsonImportService;

public class CLIMain {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Please use --import xxx.json/ --export xxx.json");

        } else {
            String command = args[0];
            String fileName = args[1];

            if (command.equals("--import")) {
                JsonImportService jsonImportService = new JsonImportService();

                if (fileName.contains("channel_info")) {
                    jsonImportService.importChannelInfo(fileName);

                } else if (fileName.contains("channel_tag_mapping")) {
                    jsonImportService.importChannelTagMapping(fileName);

                } else if (fileName.contains("p_type_2")) {
                    jsonImportService.importPType2Info(fileName);

                } else if (fileName.contains("tag_info")) {
                    jsonImportService.importTagInfo(fileName);

                } else {
                    System.out.println("Invalid file name for import.");
                }

            } else if (command.equals("--export")) {
                JsonExportService jsonExportService = new JsonExportService();

                if (fileName.contains("channel_info")) {
                    jsonExportService.exportChannelInfo(fileName);

                } else if (fileName.contains("channel_tag_mapping")) {
                    jsonExportService.exportChannelTagMapping(fileName);

                } else if (fileName.contains("p_type_2")) {
                    jsonExportService.exportPType2Info(fileName);

                } else if (fileName.contains("tag_info")) {
                    jsonExportService.exportTagInfo(fileName);

                } else
                    System.out.println("Invalid file name for export.");

            } else
                System.out.println("Please use --import xxx.json/ --export xxx.json");

        }
    }
}
