package com.company;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBCRUD {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/training", "root", "abc123");
            JSONParser parser = new JSONParser();
            String fileName = "C:/Users/alexlai/Downloads/java-training/general-web-service-master/assets/p_type_2_info.json";

            Object obj = parser.parse(new FileReader(fileName));
            JSONArray jsonArray = (JSONArray) obj;

            String sql = "INSERT INTO p_type_2_info(category, name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                statement.setString(1, jsonObject.getString("category"));
                statement.setString(2, jsonObject.getString("name"));
                statement.executeUpdate();
            }


        } catch (SQLException | ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
