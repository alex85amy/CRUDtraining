package com.company;


import com.company.bean.ChannelInfo;
import com.company.bean.TagInfo;
import com.company.daoimpl.ChannelInfoDaoImpl;
import com.company.daoimpl.TagInfoDaoImpl;
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
            reader = new FileReader("C:\\CRUD\\src\\com\\company\\json\\channel_info.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, List<ChannelInfo>>>() {
        }.getType();
        Map<String, List<ChannelInfo>> jsonMap = gson.fromJson(reader, mapType);

        List<ChannelInfo> channelInfoList = jsonMap.get("channel_info");

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

    }

    public void importPType2Info() {

    }

    public void importTagInfo() {
        // 讀取 JSON 文件
        FileReader reader = null;
        try {
            reader = new FileReader("C:\\CRUD\\src\\com\\company\\json\\tag_info.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, List<TagInfo>>>() {
        }.getType();
        Map<String, List<TagInfo>> jsonMap = gson.fromJson(reader, mapType);

        List<TagInfo> channelInfoList = jsonMap.get("tag_info");

        TagInfoDaoImpl tagInfoDao = new TagInfoDaoImpl();
        for (TagInfo tagInfo : channelInfoList) {
            tagInfoDao.add(tagInfo);
        }
    }
}
