package com.company;

import com.company.util.JsonImport;

public class Test {
    public static void main(String[] args) {
//        JsonExport jsonExport = new JsonExport();
        JsonImport jsonImport = new JsonImport();
        jsonImport.importChannelInfoBatch();
    }
}


