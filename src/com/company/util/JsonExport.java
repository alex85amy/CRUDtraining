package com.company.util;

import com.company.dao.ChannelInfoDao;
import com.company.dao.ChannelTagMappingDao;
import com.company.dao.PType2InfoDao;
import com.company.dao.TagInfoDao;
import com.company.daoimpl.ChannelInfoDaoImpl;
import com.company.daoimpl.ChannelTagMappingDaoImpl;
import com.company.daoimpl.PType2InfoDaoImpl;
import com.company.daoimpl.TagInfoDaoImpl;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonExport {

    public void exportChannelInfo(String fileName) {

        ChannelInfoDao channelInfoDao = new ChannelInfoDaoImpl();
        JsonObject jsonObject = (JsonObject) channelInfoDao.findAll();

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(jsonObject.toString()); // 使用縮排格式進行格式化
            System.out.println("JSON array 已成功寫入到檔案: " + fileName);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void exportChannelTagMapping(String fileName) {

        ChannelTagMappingDao channelTagMappingDao = new ChannelTagMappingDaoImpl();
        JsonObject jsonObject = (JsonObject) channelTagMappingDao.findAll();

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(jsonObject.toString()); // 使用縮排格式進行格式化
            System.out.println("JSON array 已成功寫入到檔案: " + fileName);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void exportPType2Info(String fileName) {

        PType2InfoDao pType2InfoDao = new PType2InfoDaoImpl();
        JsonObject jsonObject = (JsonObject) pType2InfoDao.findAll();

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(jsonObject.toString()); // 使用縮排格式進行格式化
            System.out.println("JSON array 已成功寫入到檔案: " + fileName);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void exportTagInfo(String fileName) {

        TagInfoDao tagInfoDao = new TagInfoDaoImpl();
        JsonObject jsonObject = (JsonObject) tagInfoDao.findAll();

        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(jsonObject.toString()); // 使用縮排格式進行格式化
            System.out.println("JSON array 已成功寫入到檔案: " + fileName);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
