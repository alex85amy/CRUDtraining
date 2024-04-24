package com.company.service;


import com.company.bean.ChannelInfo;
import com.company.bean.ChannelTagMapping;
import com.company.bean.PType2Info;
import com.company.bean.TagInfo;
import com.company.dao.ChannelInfoDao;
import com.company.dao.ChannelTagMappingDao;
import com.company.dao.PType2InfoDao;
import com.company.dao.TagInfoDao;
import com.company.daoimpl.ChannelInfoDaoImpl;
import com.company.daoimpl.ChannelTagMappingDaoImpl;
import com.company.daoimpl.PType2InfoDaoImpl;
import com.company.daoimpl.TagInfoDaoImpl;
import com.company.util.JDBC;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class JsonImportService {

    private JDBC jdbc = new JDBC();
    private Connection conn = jdbc.getConnection();
    private Logger logger = LogManager.getLogger();

    public void importChannelInfo(String fileName) {
        // 讀取 JSON 文件
        FileReader reader = null;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        // 使用 Gson 進行 JSON 解析
        Gson gson = new Gson();
        // 指定 JSON 資料型態為 Map<String, List<ChannelTagMapping>>
        Type mapType = new TypeToken<Map<String, List<ChannelInfo>>>() {
        }.getType();
        Map<String, List<ChannelInfo>> jsonMap = gson.fromJson(reader, mapType);

        // 從解析後的資料中取得頻道標籤對應的清單
        List<ChannelInfo> channelInfoList = jsonMap.get("channel_info");
        ChannelInfoDao channelInfoDao = new ChannelInfoDaoImpl(conn);
        channelInfoDao.addBatch(channelInfoList);

    }

    public void importChannelTagMapping(String fileName) {
        // 讀取 JSON 文件
        FileReader reader = null;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, List<ChannelTagMapping>>>() {
        }.getType();
        Map<String, List<ChannelTagMapping>> jsonMap = gson.fromJson(reader, mapType);

        List<ChannelTagMapping> channelTagMappingList = jsonMap.get("channel_tag_mapping");
        ChannelTagMappingDao channelTagMappingDao = new ChannelTagMappingDaoImpl(conn);
        channelTagMappingDao.addBatch(channelTagMappingList);

    }

    public void importPType2Info(String fileName) {
        FileReader reader = null;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, List<PType2Info>>>() {
        }.getType();
        Map<String, List<PType2Info>> jsonMap = gson.fromJson(reader, mapType);

        List<PType2Info> pType2InfoList = jsonMap.get("p_type_2_info");
        PType2InfoDao pType2InfoDao = new PType2InfoDaoImpl(conn);
        pType2InfoDao.addBatch(pType2InfoList);

    }

    public void importTagInfo(String fileName) {

        FileReader reader = null;
        try {
            reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            logger.error(e.toString());
        }
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, List<TagInfo>>>() {
        }.getType();
        Map<String, List<TagInfo>> jsonMap = gson.fromJson(reader, mapType);

        List<TagInfo> tagInfoList = jsonMap.get("tag_info");
        TagInfoDao tagInfoDao = new TagInfoDaoImpl(conn);
        tagInfoDao.addBatch(tagInfoList);

    }
}
