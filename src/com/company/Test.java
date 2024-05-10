package com.company;

import com.company.service.JsonExportService;
import com.company.service.JsonImportService;

public class Test {
    public static void main(String[] args) {
//        JsonExportService jsonExport = new JsonExportService();
//        jsonExport.exportTagInfo("tag_info0510.json");
        JsonImportService jsonImport = new JsonImportService();
        jsonImport.importTagInfo("tag_info0510.json");
    }
}


