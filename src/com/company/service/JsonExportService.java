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

    private final JDBC jdbc = new JDBC();
    private final Connection conn = jdbc.getConn();
    private final Logger logger = LogManager.getLogger();

    public void exportChannelInfo(String fileName) {

        ChannelInfoDao channelInfoDao = new ChannelInfoDao(conn);
        List<ChannelInfo> list = channelInfoDao.findAll();

        // 創建根 JsonObject
        JsonObject rootObject = new JsonObject();

        // 創建存放 ChannelInfo 的 JsonArray
        JsonArray jsonArray = new JsonArray();
        for (ChannelInfo channelInfo : list) {
            JsonObject tagObject = new JsonObject();
            tagObject.addProperty("auto_id", channelInfo.getAutoId());
            tagObject.addProperty("source_id", channelInfo.getSourceId());
            tagObject.addProperty("source_area_id", channelInfo.getSourceAreaId());
            tagObject.addProperty("is_used", channelInfo.getIsUsed());
            tagObject.addProperty("p_type_2", channelInfo.getPType2());
            jsonArray.add(tagObject);
        }

        // 將 ChannelInfo 數組添加到根 JsonObject 中
        rootObject.add("channel_info", jsonArray);

        // 初始化 Gson 時設置格式化選項
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(rootObject, fileWriter);
            System.out.println("JSON object 已成功寫入到檔案: " + fileName);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
            logger.error(e.toString());
        }
        jdbc.close();
    }

    public void exportChannelTagMapping(String fileName) {

        ChannelTagMappingDao channelTagMappingDao = new ChannelTagMappingDao(conn);
        List<ChannelTagMapping> list = channelTagMappingDao.findAll();

        // 創建根 JsonObject
        JsonObject rootObject = new JsonObject();

        // 創建存放 ChannelTagMapping 的 JsonArray
        JsonArray jsonArray = new JsonArray();
        for (ChannelTagMapping channelTagMapping : list) {
            JsonObject tagObject = new JsonObject();
            tagObject.addProperty("auto_id", channelTagMapping.getAutoId());
            tagObject.addProperty("s_area_id", channelTagMapping.getSourceAreaId());
            tagObject.addProperty("tag_id", channelTagMapping.getTagId());
            jsonArray.add(tagObject);
        }

        // 將 ChannelTagMapping 數組添加到根 JsonObject 中
        rootObject.add("channel_tag_mapping", jsonArray);

        // 初始化 Gson 時設置格式化選項
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(rootObject, fileWriter);
            System.out.println("JSON object 已成功寫入到檔案: " + fileName);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
            logger.error(e.toString());
        }
        jdbc.close();
    }

    public void exportPType2Info(String fileName) {

        PType2InfoDao pType2InfoDao = new PType2InfoDao(conn);
        List<PType2Info> list = pType2InfoDao.findAll();

        // 創建根 JsonObject
        JsonObject rootObject = new JsonObject();

        // 創建存放 PType2Info 的 JsonArray
        JsonArray jsonArray = new JsonArray();
        for (PType2Info pType2Info : list) {
            JsonObject tagObject = new JsonObject();
            tagObject.addProperty("auto_id", pType2Info.getAutoId());
            tagObject.addProperty("category", pType2Info.getCategory());
            tagObject.addProperty("name", pType2Info.getName());
            jsonArray.add(tagObject);
        }

        // 將 PType2Info 數組添加到根 JsonObject 中
        rootObject.add("p_type_2_info", jsonArray);

        // 初始化 Gson 時設置格式化選項
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(rootObject, fileWriter);
            System.out.println("JSON object 已成功寫入到檔案: " + fileName);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
            logger.error(e.toString());
        }
        jdbc.close();
    }

    public void exportTagInfo(String fileName) {
        TagInfoDao tagInfoDao = new TagInfoDao(conn);
        List<TagInfo> list = tagInfoDao.findAll();

        // 創建根 JsonObject
        JsonObject rootObject = new JsonObject();

        // 創建存放 TagInfo 的 JsonArray
        JsonArray jsonArray = new JsonArray();
        for (TagInfo tagInfo : list) {
            JsonObject tagObject = new JsonObject();
            tagObject.addProperty("tag_id", tagInfo.getTagId());
            tagObject.addProperty("tag_name", tagInfo.getTagName());
            tagObject.addProperty("type", tagInfo.getType());
            jsonArray.add(tagObject);
        }

        // 將 TagInfo 數組添加到根 JsonObject 中
        rootObject.add("tag_info", jsonArray);

        // 初始化 Gson 時設置格式化選項
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            gson.toJson(rootObject, fileWriter);
            System.out.println("JSON object 已成功寫入到檔案: " + fileName);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
            logger.error(e.toString());
        }
        jdbc.close();
    }
}
