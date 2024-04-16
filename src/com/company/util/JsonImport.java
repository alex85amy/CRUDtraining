package com.company.util;


import com.company.bean.*;
import com.company.daoimpl.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JsonImport {

    public void importChannelInfo() {
        // 讀取 JSON 文件
        FileReader reader = null;
        try {
            reader = new FileReader("channel_info.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 使用 Gson 進行 JSON 解析
        Gson gson = new Gson();
        // 指定 JSON 資料型態為 Map<String, List<ChannelTagMapping>>
        Type mapType = new TypeToken<Map<String, List<ChannelInfo>>>() {
        }.getType();
        Map<String, List<ChannelInfo>> jsonMap = gson.fromJson(reader, mapType);

        // 從解析後的資料中取得頻道標籤對應的清單
        List<ChannelInfo> channelInfoList = jsonMap.get("channel_info");
        // 建立 ChannelTagMappingDaoImpl 物件並將解析的資料加入資料庫
        ChannelInfoDaoImpl channelInfoDao = new ChannelInfoDaoImpl();
        for (ChannelInfo channelInfo : channelInfoList) {
            channelInfoDao.add(channelInfo);

//            for (ChannelInfo channelInfo : channelInfoList) {
//                System.out.println("Source ID: " + channelInfo.getSourceId());
//                System.out.println("Source Area ID: " + channelInfo.getSourceAreaId());
//                System.out.println("Is Used: " + channelInfo.getIsUsed());
//                System.out.println("P Type 2: " + channelInfo.getPType2());
//                System.out.println();
//            }
        }
    }

    public void importChannelTagMapping() {

        FileReader reader = null;
        try {
            reader = new FileReader("channel_tag_mapping.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, List<ChannelTagMapping>>>() {
        }.getType();
        Map<String, List<ChannelTagMapping>> jsonMap = gson.fromJson(reader, mapType);

        List<ChannelTagMapping> channelTagMappingList = jsonMap.get("channel_tag_mapping");

        ChannelTagMappingDaoImpl channelTagMappingDao = new ChannelTagMappingDaoImpl();
        for (ChannelTagMapping channelTagMapping : channelTagMappingList) {
            channelTagMappingDao.add(channelTagMapping);
        }
    }

    public void importPType2Info() {
        FileReader reader = null;
        try {
            reader = new FileReader("p_type_2_list.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, List<PType2Info>>>() {
        }.getType();
        Map<String, List<PType2Info>> jsonMap = gson.fromJson(reader, mapType);

        List<PType2Info> pType2InfoList = jsonMap.get("p_type_2_info");

        PType2InfoDaoImpl pType2InfoDao = new PType2InfoDaoImpl();
        for (PType2Info pType2Info : pType2InfoList) {
            pType2InfoDao.add(pType2Info);
        }
    }

    public void importTagInfo() {

        FileReader reader = null;
        try {
            reader = new FileReader("tag_info.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, List<TagInfo>>>() {
        }.getType();
        Map<String, List<TagInfo>> jsonMap = gson.fromJson(reader, mapType);

        List<TagInfo> tagInfoList = jsonMap.get("tag_info");

        TagInfoDaoImpl tagInfoDao = new TagInfoDaoImpl();
        for (TagInfo tagInfo : tagInfoList) {
            tagInfoDao.add(tagInfo);
        }
    }
}
