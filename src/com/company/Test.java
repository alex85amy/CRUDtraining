package com.company;

import com.company.service.JsonExportService;
import com.company.service.JsonImportService;

public class Test {
    public static void main(String[] args) {
        JsonExportService jsonExport = new JsonExportService();
//        jsonExport.exportPType2Info("p_type_2_info.json");
        JsonImportService jsonImport = new JsonImportService();
        jsonImport.importPType2Info("p_type_2_list.json");
//        jsonImport.importTagInfo("tag_info0510.json");
    }
}


