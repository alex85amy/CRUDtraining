package com.company;

import com.company.service.JsonExportService;
import com.company.service.JsonImportService;

public class Test {
    public static void main(String[] args) {
        JsonExportService jsonExport = new JsonExportService();
        jsonExport.exportChannelInfo("channel_info_0516.json");
//        jsonExport.exportChannelTagMapping("channel_tag_mapping_0516.json");
//        jsonExport.exportPType2Info("p_type_2_info_0516.json");
//        jsonExport.exportTagInfo("tag_info_0516.json");
//        JsonImportService jsonImport = new JsonImportService();
//        jsonImport.importPType2Info("p_type_2_info_0516.json");
//        jsonImport.importTagInfo("tag_info_0516.json");

    }
}

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



