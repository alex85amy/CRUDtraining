package com.company.service;

import com.company.bean.ChannelInfo;
import com.company.bean.ChannelTagMapping;
import com.company.bean.PType2Info;
import com.company.bean.TagInfo;
import com.company.dao.ChannelInfoDao;
import com.company.dao.ChannelTagMappingDao;
import com.company.dao.PType2InfoDao;
import com.company.dao.TagInfoDao;
import com.company.util.JDBC;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class JsonExportService {

    private final Connection conn = JDBC.getConn();
    private final Logger logger = LogManager.getLogger();

    public void exportChannelInfo(String fileName) {

        ChannelInfoDao channelInfoDao = new ChannelInfoDao(conn);
        List<ChannelInfo> list = channelInfoDao.findAll();

        // 創建根 JsonObject
        JsonObject rootObject = new JsonObject();

        // 創建存放 ChannelInfo 的 JsonArray
        JsonArray jsonArray = new JsonArray();
        for (ChannelInfo channelInfo : list) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("auto_id", channelInfo.getAutoId());
            jsonObject.addProperty("source_id", channelInfo.getSourceId());
            jsonObject.addProperty("source_area_id", channelInfo.getSourceAreaId());
            jsonObject.addProperty("is_used", channelInfo.getIsUsed());
            jsonObject.addProperty("p_type_2", channelInfo.getPType2());
            jsonArray.add(jsonObject);
        }

        // 將 ChannelInfo 數組添加到根 JsonObject 中
        rootObject.add("channel_info", jsonArray);

        // 初始化 Gson 時設置格式化選項
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(rootObject, fileWriter);
            System.out.println("已成功寫入到檔案: " + fileName);
            logger.info("export channel_info");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        JDBC.close();
    }

    public void exportChannelTagMapping(String fileName) {

        ChannelTagMappingDao channelTagMappingDao = new ChannelTagMappingDao(conn);
        List<ChannelTagMapping> list = channelTagMappingDao.findAll();

        JsonObject rootObject = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (ChannelTagMapping channelTagMapping : list) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("auto_id", channelTagMapping.getAutoId());
            jsonObject.addProperty("s_area_id", channelTagMapping.getSourceAreaId());
            jsonObject.addProperty("tag_id", channelTagMapping.getTagId());
            jsonArray.add(jsonObject);
        }

        rootObject.add("channel_tag_mapping", jsonArray);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(rootObject, fileWriter);
            System.out.println("已成功寫入到檔案: " + fileName);
            logger.info("export channel_tag_mapping");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        JDBC.close();
    }

    public void exportPType2Info(String fileName) {

        PType2InfoDao pType2InfoDao = new PType2InfoDao(conn);
        List<PType2Info> list = pType2InfoDao.findAll();

        JsonObject rootObject = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (PType2Info pType2Info : list) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("auto_id", pType2Info.getAutoId());
            jsonObject.addProperty("category", pType2Info.getCategory());
            jsonObject.addProperty("name", pType2Info.getName());
            jsonArray.add(jsonObject);
        }

        rootObject.add("p_type_2_info", jsonArray);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(rootObject, fileWriter);
            System.out.println("已成功寫入到檔案: " + fileName);
            logger.info("export p_type_2_info");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        JDBC.close();
    }

    public void exportTagInfo(String fileName) {

        TagInfoDao tagInfoDao = new TagInfoDao(conn);
        List<TagInfo> list = tagInfoDao.findAll();

        JsonObject rootObject = new JsonObject();

        JsonArray jsonArray = new JsonArray();
        for (TagInfo tagInfo : list) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("tag_id", tagInfo.getTagId());
            jsonObject.addProperty("tag_name", tagInfo.getTagName());
            jsonObject.addProperty("type", tagInfo.getType());
            jsonArray.add(jsonObject);
        }

        rootObject.add("tag_info", jsonArray);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(rootObject, fileWriter);
            System.out.println("已成功寫入到檔案: " + fileName);
            logger.info("export tag_info");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        JDBC.close();
    }
}
