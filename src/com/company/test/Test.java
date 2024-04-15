package com.company.test;

import com.company.JsonImport;
import com.company.daoimpl.TagInfoDaoImpl;

public class Test {
    public static void main(String[] args) {
        TagInfoDaoImpl tagInfoDao = new TagInfoDaoImpl();
        System.out.println(tagInfoDao.findAll().toString());
    }
}


