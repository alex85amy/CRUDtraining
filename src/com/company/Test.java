package com.company;

import com.company.bean.PType2Info;
import com.company.dao.PType2InfoDao;
import com.company.daoimpl.PType2InfoDaoImpl;
import com.company.util.JDBC;
import com.company.util.JsonImport;

public class Test {
    public static void main(String[] args) {
//        JsonExport jsonExport = new JsonExport();
//        JsonImport jsonImport = new JsonImport();
//        jsonImport.importChannelInfoBatch();
//        JDBC jdbc =new JDBC();
//        jdbc.getConnection();

        PType2InfoDao pType2InfoDao = new PType2InfoDaoImpl();
//        PType2Info pType2Info = new PType2Info("aaa","zzz");
        System.out.println(pType2InfoDao.findAll().toString());

    }
}


