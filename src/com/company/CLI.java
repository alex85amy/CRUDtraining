package com.company;

import com.company.service.JsonExportService;
import com.company.service.JsonImportService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CLI {
    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Invalid input. Please use --import xxx.json/ --export xxx.json");
            return;
        }
        String command = args[0];
        String fileName = args[1];
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

    }
}
