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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class JsonExportService {

    private final Connection conn = JDBC.getConn();
    private final Logger logger = LogManager.getLogger();

    public void exportChannelInfo(String fileName) {

        ChannelInfoDao channelInfoDao = new ChannelInfoDao(conn);
        // 初始化 Gson 時設置格式化選項
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //將資料批次查詢並放入json
        int amount = 100000;
        int NumOfData = channelInfoDao.findNumOfData();
        int pages = NumOfData / amount + (NumOfData % amount == 0 ? 0 : 1);
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write("""
                    {
                    "channel_info":
                    [
                    """); // json頭

            for (int i = 1; i <= pages; i++) {
                List<ChannelInfo> list = channelInfoDao.findPageData(amount, i);
                for (int j = 0; j < list.size(); j++) {
                    ChannelInfo channelInfo = list.get(j);
                    fileWriter.write(gson.toJson(channelInfo));
                    if (i < pages || j < list.size() - 1) {
                        fileWriter.write(",\n"); //除了最後一個物件外都有逗號換行
                    }
                }
                fileWriter.flush();
            }
            fileWriter.write("\n]\n}"); // json尾
            fileWriter.flush();
            logger.info("export " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.toString());
        } finally {
            JDBC.close();
        }

    }

    public void exportChannelTagMapping(String fileName) {

        ChannelTagMappingDao channelTagMappingDao = new ChannelTagMappingDao(conn);
        // 初始化 Gson 時設置格式化選項
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //將資料批次查詢並放入json
        int amount = 100000;
        int NumOfData = channelTagMappingDao.findNumOfData();
        int pages = channelTagMappingDao.findNumOfData() / amount + (NumOfData % amount == 0 ? 0 : 1);
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write("""
                    {
                    "channel_tag_mapping":
                    [
                    """); // json頭

            for (int i = 1; i <= pages; i++) {
                List<ChannelTagMapping> list = channelTagMappingDao.findPageData(amount, i);
                for (int j = 0; j < list.size(); j++) {
                    ChannelTagMapping channelTagMapping = list.get(j);
                    fileWriter.write(gson.toJson(channelTagMapping));
                    if (i < pages || j < list.size() - 1) {
                        fileWriter.write(",\n"); //除了最後一個物件外都有逗號換行
                    }
                }
                fileWriter.flush();
            }
            fileWriter.write("\n]\n}"); // json尾
            fileWriter.flush();
            logger.info("export " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.toString());
        } finally {
            JDBC.close();
        }
    }

    public void exportPType2Info(String fileName) {

        PType2InfoDao pType2InfoDao = new PType2InfoDao(conn);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        int amount = 30;
        int NumOfData = pType2InfoDao.findNumOfData();
        int pages = pType2InfoDao.findNumOfData() / amount + (NumOfData % amount == 0 ? 0 : 1);

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write("""
                    {
                    "p_type_2_info":
                    [
                    """); // json頭

            for (int i = 1; i <= pages; i++) {
                List<PType2Info> list = pType2InfoDao.findPageData(amount, i);
                for (int j = 0; j < list.size(); j++) {
                    PType2Info pType2Info = list.get(j);
                    fileWriter.write(gson.toJson(pType2Info));
                    if (i < pages || j < list.size() - 1) {
                        fileWriter.write(",\n"); //除了最後一個物件外都有逗號換行
                    }
                }
                fileWriter.flush();
            }
            fileWriter.write("\n]\n}"); // json尾
            fileWriter.flush();
            logger.info("export " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.toString());
        } finally {
            JDBC.close();
        }
    }

    public void exportTagInfo(String fileName) {

        TagInfoDao tagInfoDao = new TagInfoDao(conn);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        int amount = 30;
        int NumOfData = tagInfoDao.findNumOfData();
        int pages = tagInfoDao.findNumOfData() / amount + (NumOfData % amount == 0 ? 0 : 1);

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write("""
                    {
                    "tag_info":
                    [
                    """); // json頭

            for (int i = 1; i <= pages; i++) {
                List<TagInfo> list = tagInfoDao.findPageData(amount, i);
                for (int j = 0; j < list.size(); j++) {
                    TagInfo tagInfo = list.get(j);
                    fileWriter.write(gson.toJson(tagInfo));
                    if (i < pages || j < list.size() - 1) {
                        fileWriter.write(",\n"); //除了最後一個物件外都有逗號換行
                    }
                }
                fileWriter.flush();
            }
            fileWriter.write("\n]\n}"); // json尾
            fileWriter.flush();
            logger.info("export " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.toString());
        } finally {
            JDBC.close();
        }
    }
}
