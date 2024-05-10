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
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class JsonImportService {

    private final JDBC jdbc = new JDBC();
    private final Connection conn = jdbc.getConn();
    private final Logger logger = LogManager.getLogger();

    public void importChannelInfo(String fileName) {
        // 使用 try-with-resources 確保資源被正確關閉
        try (FileReader reader = new FileReader(fileName)) {
            // 使用 Gson 進行 JSON 解析
            Gson gson = new Gson();
            // 使用 TypeToken 來獲取泛型類型信息
            Type mapType = new TypeToken<Map<String, List<ChannelInfo>>>() {
            }.getType();
            // 指定 JSON 資料型態為 Map<String, List<ChannelTagMapping>>
            Map<String, List<ChannelInfo>> jsonMap = gson.fromJson(reader, mapType);

            // 從解析後的資料中取得頻道標籤對應的清單
            List<ChannelInfo> channelInfoList = jsonMap.get("channel_info");
            ChannelInfoDao channelInfoDao = new ChannelInfoDao(conn);
            channelInfoDao.addBatch(channelInfoList);
        } catch (FileNotFoundException e) {
            // 記錄錯誤
            logger.error(e.toString());
        } catch (IOException e) {
            // 處理 IO 錯誤
            e.printStackTrace();
        }
        jdbc.close();
    }

    public void importChannelTagMapping(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            Gson gson = new Gson();

            Type mapType = new TypeToken<Map<String, List<ChannelTagMapping>>>() {
            }.getType();
            Map<String, List<ChannelTagMapping>> jsonMap = gson.fromJson(reader, mapType);

            List<ChannelTagMapping> channelTagMappingList = jsonMap.get("channel_tag_mapping");
            ChannelTagMappingDao channelTagMappingDao = new ChannelTagMappingDao(conn);
            channelTagMappingDao.addBatch(channelTagMappingList);
        } catch (FileNotFoundException e) {
            // 記錄錯誤
            logger.error(e.toString());
        } catch (IOException e) {
            // 處理 IO 錯誤
            e.printStackTrace();
        }
        jdbc.close();
    }

    public void importPType2Info(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            Gson gson = new Gson();

            Type mapType = new TypeToken<Map<String, List<PType2Info>>>() {
            }.getType();
            Map<String, List<PType2Info>> jsonMap = gson.fromJson(reader, mapType);

            List<PType2Info> pType2InfoList = jsonMap.get("p_type_2_info");
            PType2InfoDao pType2InfoDao = new PType2InfoDao(conn);
            pType2InfoDao.addBatch(pType2InfoList);
        } catch (FileNotFoundException e) {
            // 記錄錯誤
            logger.error(e.toString());
        } catch (IOException e) {
            // 處理 IO 錯誤
            e.printStackTrace();
        }
        jdbc.close();
    }

    public void importTagInfo(String fileName) {
        try (FileReader reader = new FileReader(fileName)) {
            Gson gson = new Gson();

            Type mapType = new TypeToken<Map<String, List<TagInfo>>>() {
            }.getType();
            Map<String, List<TagInfo>> jsonMap = gson.fromJson(reader, mapType);

            List<TagInfo> tagInfoList = jsonMap.get("tag_info");
            TagInfoDao tagInfoDao = new TagInfoDao(conn);
            tagInfoDao.addBatch(tagInfoList);
        } catch (FileNotFoundException e) {
            // 記錄錯誤
            logger.error(e.toString());
        } catch (IOException e) {
            // 處理 IO 錯誤
            e.printStackTrace();
        }
        jdbc.close();
    }
}
