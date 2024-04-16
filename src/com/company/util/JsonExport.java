package com.company.util;

import com.company.daoimpl.*;
import com.google.gson.JsonArray;

import java.io.FileWriter;
import java.io.IOException;

public class JsonExport {

    public void exportChannelInfo() {

        ChannelInfoDaoImpl channelInfoDao = new ChannelInfoDaoImpl();
        JsonArray jsonArray = (JsonArray) channelInfoDao.findAll();
        String exportFilePath = "channel_info.json";

        try (FileWriter fileWriter = new FileWriter(exportFilePath)) {
            fileWriter.write(jsonArray.toString()); // 使用縮排格式進行格式化
            System.out.println("JSON array 已成功寫入到檔案: " + exportFilePath);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void exportChannelTagMapping() {

        ChannelTagMappingDaoImpl channelTagMappingDao = new ChannelTagMappingDaoImpl();
        JsonArray jsonArray = (JsonArray) channelTagMappingDao.findAll();
        String exportFilePath = "channel_tag_mapping.json";

        try (FileWriter fileWriter = new FileWriter(exportFilePath)) {
            fileWriter.write(jsonArray.toString()); // 使用縮排格式進行格式化
            System.out.println("JSON array 已成功寫入到檔案: " + exportFilePath);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void exportPType2Info() {

        PType2InfoDaoImpl pType2InfoDao = new PType2InfoDaoImpl();
        JsonArray jsonArray = (JsonArray) pType2InfoDao.findAll();
        String exportFilePath = "p_type_2_list.json";

        try (FileWriter fileWriter = new FileWriter(exportFilePath)) {
            fileWriter.write(jsonArray.toString()); // 使用縮排格式進行格式化
            System.out.println("JSON array 已成功寫入到檔案: " + exportFilePath);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void exportTagInfo() {

        TagInfoDaoImpl tagInfoDao = new TagInfoDaoImpl();
        JsonArray jsonArray = (JsonArray) tagInfoDao.findAll();
        String exportFilePath = "tag_info.json";

        try (FileWriter fileWriter = new FileWriter(exportFilePath)) {
            fileWriter.write(jsonArray.toString()); // 使用縮排格式進行格式化
            System.out.println("JSON array 已成功寫入到檔案: " + exportFilePath);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
