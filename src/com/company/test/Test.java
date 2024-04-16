package com.company.test;

import com.company.daoimpl.TagInfoDaoImpl;
import com.company.util.JsonExport;
import com.company.util.JsonImport;

public class Test {
    public static void main(String[] args) {
        JsonExport jsonExport = new JsonExport();
        jsonExport.exportChannelInfo();
    }
}


