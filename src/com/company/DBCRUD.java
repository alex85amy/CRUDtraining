package com.company;


import com.company.bean.ChannelInfo;
import jakarta.json.*;

import java.io.FileReader;

public class DBCRUD {
    public static void main(String[] args) {
        try (JsonReader reader = Json.createReader(new FileReader("C:\\\\CRUD\\\\src\\\\com\\\\company\\\\channel_info.json"))) {
            JsonArray jsonArray = reader.readArray();

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = jsonArray.getJsonObject(i);

                // 從每個 JSON 物件中擷取需要的資料
                String sourceId = jsonObject.getString("source_id");
                String sourceAreaId = jsonObject.getString("source_area_id");
                int isUsed = jsonObject.getInt("is_used");
                String pType2 = jsonObject.getString("p_type_2");

                // 建立 Java 物件
                ChannelInfo channelInfo = new ChannelInfo(sourceId, sourceAreaId, isUsed, pType2);

                // 使用 Java 物件
                System.out.println("sourceId: " + channelInfo.getSourceId());
                System.out.println("sourceAreaId: " + channelInfo.getSourceAreaId());
                System.out.println("isUsed: " + channelInfo.getIsUsed());
                System.out.println("pType2: " + channelInfo.getPType2());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


//        try {
//            // 创建 Gson 实例
//            Gson gson = new Gson();
//
//            // 读取 JSON 文件到对象
//            FileReader reader = new FileReader("C:\\CRUD\\src\\com\\company\\channel_info.json");
//            List<ChannelInfo> channelInfos = gson.fromJson(reader, List.class);
//
//            // 将对象数组转换为列表
//            List<ChannelInfo> channelInfoList = new ArrayList<>();
//            for (ChannelInfo channelInfo: channelInfos){
//                channelInfoList.add(channelInfo);
//            }
//
//            // 打印每个人的信息
//            for(ChannelInfo channelInfo : channelInfos) {
//                System.out.println("sourceId: " + channelInfo.getSourceId());
//                System.out.println("sourceAreaId: " + channelInfo.getSourceAreaId());
//                System.out.println("isUsed: " + channelInfo.getIsUsed());
//                System.out.println("pType2: " + channelInfo.getPType2());
//                System.out.println();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}