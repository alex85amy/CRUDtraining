package com.company;

import com.company.service.JsonExportService;
import com.company.util.JDBC;

public class Test {
    public static void main(String[] args) {
        JsonExportService jsonExport = new JsonExportService();
        jsonExport.exportTagInfo("tag_info_0506.json");
//        JsonImport jsonImport = new JsonImport();
//        jsonImport.importChannelInfoBatch();
//        JDBC jdbc =new JDBC();
//        jdbc.getConnection();

//        PType2InfoDao pType2InfoDao = new PType2InfoDaoImpl();
//        PType2Info pType2Info = new PType2Info("aaa","zzz");
//        System.out.println(pType2InfoDao.findAll().toString());

    }
}


