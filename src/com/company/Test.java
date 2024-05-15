package com.company;

import com.company.service.JsonExportService;
import com.company.service.JsonImportService;

public class Test {
    public static void main(String[] args) {
        JsonExportService jsonExport = new JsonExportService();
//        jsonExport.exportChannelInfo("channel_info_0515.json");
//        jsonExport.exportChannelTagMapping("channel_tag_mapping_0515.json");
//        jsonExport.exportPType2Info("p_type_2_info_0515.json");
//        jsonExport.exportTagInfo("tag_info_0515.json");
        JsonImportService jsonImport = new JsonImportService();
        jsonImport.importPType2Info("p_type_2_info_0515.json");
//        jsonImport.importTagInfo("tag_info0510.json");
    }

    //            JsonObject jsonObject = new JsonObject();
    //            jsonObject.addProperty("auto_id", channelInfo.getAutoId());
    //            jsonObject.addProperty("source_id", channelInfo.getSourceId());
    //            jsonObject.addProperty("source_area_id", channelInfo.getSourceAreaId());
    //            jsonObject.addProperty("is_used", channelInfo.getIsUsed());
    //            jsonObject.addProperty("p_type_2", channelInfo.getPType2());
    //            jsonArray.add(jsonObject);
}


