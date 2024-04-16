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
    public boolean delete(String sourceAreaId) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "DELETE FROM channel_info WHERE source_area_id = '" + sourceAreaId + "'";
            int rowsAffected = statement.executeUpdate(insertSQL);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(String sourceAreaId, ChannelInfo channelInfo) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "UPDATE channel_info SET source_id='" + channelInfo.getSourceId() + "',is_used=" + channelInfo.getIsUsed() + ",p_type_2='" + channelInfo.getPType2() +
                    "' WHERE source_area_id='" + sourceAreaId + "'";
            int rowsAffected = statement.executeUpdate(insertSQL);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Object findBySourceAreaId(String sourceAreaId) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "SELECT channel_info WHERE source_area_id='" + sourceAreaId +"'";
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


