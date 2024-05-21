package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Test {
    public static void main(String[] args) {
//        java -jar cli.jar --import tag_info.json
//        java -jar cli.jar --export tag_info_0521.json

    }
}

//        // 使用相对路径读取上一级目录的文件
//        String filePath = "../p_type_2_list.json"; // 使用 ../ 指向上一级目录
//        try (FileReader fileReader = new FileReader(filePath, StandardCharsets.UTF_8);
//             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        JsonExportService jsonExport = new JsonExportService();
//        jsonExport.exportChannelInfo("channel_info_0516.json");
//        jsonExport.exportChannelTagMapping("channel_tag_mapping_0516.json");
//        jsonExport.exportPType2Info("p_type_2_info_0516.json");
//        jsonExport.exportTagInfo("tag_info_0516.json");
//        JsonImportService jsonImport = new JsonImportService();
//        jsonImport.importPType2Info("p_type_2_info_0516.json");
//        jsonImport.importTagInfo("tag_info_0516.json");
//            JsonObject jsonObject = new JsonObject();
//            jsonObject.addProperty("auto_id", channelInfo.getAutoId());
//            jsonObject.addProperty("source_id", channelInfo.getSourceId());
//            jsonObject.addProperty("source_area_id", channelInfo.getSourceAreaId());
//            jsonObject.addProperty("is_used", channelInfo.getIsUsed());
//            jsonObject.addProperty("p_type_2", channelInfo.getPType2());
//            jsonArray.add(jsonObject);
//    public void exportPType2Info(String fileName) {
//
//        PType2InfoDao pType2InfoDao = new PType2InfoDao(conn);
//        List<PType2Info> list = pType2InfoDao.findAll();
//
//        JsonObject rootObject = new JsonObject();
//
//        JsonArray jsonArray = new JsonArray();
//        for (PType2Info pType2Info : list) {
//            jsonArray.add(new Gson().toJsonTree(pType2Info));
//        }
//
//        rootObject.add("p_type_2_info", jsonArray);
//
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        try (FileWriter fileWriter = new FileWriter(fileName)) {
//            gson.toJson(rootObject, fileWriter);
//            System.out.println("已成功寫入到檔案: " + fileName);
//            logger.info("export p_type_2_info");
//        } catch (IOException e) {
//            e.printStackTrace();
//            logger.error(e.toString());
//        }
//        JDBC.close();
//    }



