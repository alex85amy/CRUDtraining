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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class JsonExportService {

    private JDBC jdbc = new JDBC();
    private Connection conn = jdbc.getConnection();
    private Logger logger = LogManager.getLogger();

    public void exportChannelInfo(String fileName) {

        ChannelInfoDao channelInfoDao = new ChannelInfoDao(conn);
        List<ChannelInfo> list = channelInfoDao.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(json);
            System.out.println("JSON array 已成功寫入到檔案: " + fileName);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
            logger.error(e.toString());
        }

    }

    public void exportChannelTagMapping(String fileName) {

        ChannelTagMappingDao channelTagMappingDao = new ChannelTagMappingDao(conn);
        List<ChannelTagMapping> list = channelTagMappingDao.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(json);
            System.out.println("JSON array 已成功寫入到檔案: " + fileName);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
            logger.error(e.toString());
        }
    }

    public void exportPType2Info(String fileName) {

        PType2InfoDao pType2InfoDao = new PType2InfoDao(conn);
        List<PType2Info> list = pType2InfoDao.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(json);
            System.out.println("JSON array 已成功寫入到檔案: " + fileName);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
            logger.error(e.toString());
        }

    }

    public void exportTagInfo(String fileName) {

        TagInfoDao tagInfoDao = new TagInfoDao(conn);
        List<TagInfo> list = tagInfoDao.findAll();
        Gson gson = new Gson();
        String json = gson.toJson(list);
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(json);
            System.out.println("JSON array 已成功寫入到檔案: " + fileName);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
            logger.error(e.toString());
        }

    }
}
