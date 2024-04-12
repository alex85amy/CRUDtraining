package com.company.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/training?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
        String username = "root";
        String password = "abc123";

        try {
            // 加載 JDBC 驅動程式
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 連線到資料庫
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("連線成功！");

            // 關閉連線
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("找不到 JDBC 驅動程式：" + e.getMessage());
        } catch (SQLException e) {
            System.err.println("連線失敗：" + e.getMessage());
        }
    }
}


