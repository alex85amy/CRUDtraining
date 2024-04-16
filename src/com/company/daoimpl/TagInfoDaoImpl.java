package com.company.daoimpl;

import com.company.bean.TagInfo;
import com.company.dao.TagInfoDao;
import com.company.util.ResultSetToJson;

import java.sql.*;

public class TagInfoDaoImpl implements TagInfoDao {

    private static final String URL = "jdbc:mysql://localhost:3306/training?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "abc123";

    @Override
    public void add(TagInfo tagInfo) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "INSERT INTO tag_info(tag_id, tag_name, type) " +
                    "VALUES (" + tagInfo.getTagId() + ",'" + tagInfo.getTagName() + "'," + tagInfo.getType() + ")";
            int rowsAffected = statement.executeUpdate(insertSQL);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(int tagId) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "DELETE FROM tag_info WHERE tag_id =" +tagId;
            int rowsAffected = statement.executeUpdate(insertSQL);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int tagId, TagInfo tagInfo) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "UPDATE tag_info SET tag_name='" + tagInfo.getTagName() + "',type=" + tagInfo.getType() +
                    "WHERE tag_id=" + tagId;
            int rowsAffected = statement.executeUpdate(insertSQL);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Object findByTagId(int tagId) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "SELECT tag_info WHERE tag_id=" + tagId;
            ResultSet rs =  statement.executeQuery(insertSQL);
            return ResultSetToJson.ResultSetToJsonObject(rs,"tag_info");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Object findAll() {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "SELECT * FROM tag_info";
            ResultSet rs =  statement.executeQuery(insertSQL);
            return ResultSetToJson.ResultSetToJsonObject(rs,"tag_info");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
