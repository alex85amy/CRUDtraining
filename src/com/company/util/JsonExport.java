package com.company.util;

import com.company.daoimpl.ChannelInfoDaoImpl;
import com.company.daoimpl.ChannelTagMappingDaoImpl;
import com.company.daoimpl.PType2InfoDaoImpl;
import com.company.daoimpl.TagInfoDaoImpl;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonExport {

    public void exportChannelInfo() {

        ChannelInfoDaoImpl channelInfoDao = new ChannelInfoDaoImpl();
        JsonObject jsonObject = (JsonObject) channelInfoDao.findAll();
        String exportFilePath = "channel_info.json";

        try (FileWriter fileWriter = new FileWriter(exportFilePath)) {
            fileWriter.write(jsonObject.toString()); // 使用縮排格式進行格式化
            System.out.println("JSON array 已成功寫入到檔案: " + exportFilePath);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void exportChannelTagMapping() {

        ChannelTagMappingDaoImpl channelTagMappingDao = new ChannelTagMappingDaoImpl();
        JsonObject jsonObject = (JsonObject) channelTagMappingDao.findAll();
        String exportFilePath = "channel_tag_mapping.json";

        try (FileWriter fileWriter = new FileWriter(exportFilePath)) {
            fileWriter.write(jsonObject.toString()); // 使用縮排格式進行格式化
            System.out.println("JSON array 已成功寫入到檔案: " + exportFilePath);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void exportPType2Info() {

        PType2InfoDaoImpl pType2InfoDao = new PType2InfoDaoImpl();
        JsonObject jsonObject = (JsonObject) pType2InfoDao.findAll();
        String exportFilePath = "p_type_2_list.json";

        try (FileWriter fileWriter = new FileWriter(exportFilePath)) {
            fileWriter.write(jsonObject.toString()); // 使用縮排格式進行格式化
            System.out.println("JSON array 已成功寫入到檔案: " + exportFilePath);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void exportTagInfo() {

        TagInfoDaoImpl tagInfoDao = new TagInfoDaoImpl();
        JsonObject jsonObject = (JsonObject) tagInfoDao.findAll();
        String exportFilePath = "tag_info.json";

        try (FileWriter fileWriter = new FileWriter(exportFilePath)) {
            fileWriter.write(jsonObject.toString()); // 使用縮排格式進行格式化
            System.out.println("JSON array 已成功寫入到檔案: " + exportFilePath);
        } catch (IOException e) {
            System.err.println("寫入檔案時發生錯誤: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
