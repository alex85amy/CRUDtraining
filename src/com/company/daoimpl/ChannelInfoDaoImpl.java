package com.company.daoimpl;

import com.company.bean.ChannelInfo;
import com.company.dao.ChannelInfoDao;
import com.company.util.ResultSetToJson;

import java.sql.*;

public class ChannelInfoDaoImpl implements ChannelInfoDao {

    private static final String URL = "jdbc:mysql://localhost:3306/training?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "abc123";

    @Override
    public void add(ChannelInfo channelInfo) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "INSERT INTO channel_info(source_id, source_area_id, is_used, p_type_2) " +
                    "VALUES ('" + channelInfo.getSourceId() + "','" + channelInfo.getSourceAreaId() + "'," + channelInfo.getIsUsed() + ",'" + channelInfo.getPType2() + "')";
            int rowsAffected = statement.executeUpdate(insertSQL);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "DELETE FROM channel_info WHERE auto_id = " + id;
            int rowsAffected = statement.executeUpdate(insertSQL);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, ChannelInfo channelInfo) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "UPDATE channel_info SET source_id='" + channelInfo.getSourceId() + "',source_area_id='" + channelInfo.getSourceAreaId() + "',is_used=" + channelInfo.getIsUsed() + ",p_type_2='" + channelInfo.getPType2() +
                    "' WHERE auto_id=" + id;
            int rowsAffected = statement.executeUpdate(insertSQL);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Object findById(int id) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "SELECT * FROM channel_info WHERE auto_id=" + id;
            ResultSet rs = statement.executeQuery(insertSQL);
            return ResultSetToJson.ResultSetToJsonObject(rs, "channel_info");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Object findAll() {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "SELECT * FROM channel_info";
            ResultSet rs = statement.executeQuery(insertSQL);
            return ResultSetToJson.ResultSetToJsonObject(rs, "channel_info");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}


