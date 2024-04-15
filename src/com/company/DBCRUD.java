package com.company;


import com.company.bean.ChannelInfo;
import com.company.daoimpl.ChannelInfoDaoImpl;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class DBCRUD {
    public static void main(String[] args) throws FileNotFoundException {
        // 讀取 JSON 文件
        FileReader reader = new FileReader("C:\\CRUD\\src\\com\\company\\channel_info.json");

        Gson gson = new Gson();
        Type mapType = new TypeToken<Map<String, List<ChannelInfo>>>() {
        }.getType();
        Map<String, List<ChannelInfo>> jsonMap = gson.fromJson(reader, mapType);

        List<ChannelInfo> channelInfoList = jsonMap.get("channel_info");

        ChannelInfoDaoImpl channelInfoDao = new ChannelInfoDaoImpl();
        for (ChannelInfo channelInfo : channelInfoList) {
            channelInfoDao.add(channelInfo);
        }

//        for (ChannelInfo channelInfo : channelInfoList) {
//                System.out.println("Source ID: " + channelInfo.getSourceId());
//                System.out.println("Source Area ID: " + channelInfo.getSourceAreaId());
//                System.out.println("Is Used: " + channelInfo.getIsUsed());
//                System.out.println("P Type 2: " + channelInfo.getPType2());
//            System.out.println();
//        }
    }
}