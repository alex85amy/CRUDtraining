package com.company.daoimpl;

import com.company.bean.ChannelInfo;
import com.company.dao.ChannelInfoDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ChannelInfoDaoImpl implements ChannelInfoDao {

    private static final String URL = "jdbc:mysql://localhost:3306/training";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "abc123";

    @Override
    public void add(ChannelInfo channelInfo) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "INSERT INTO channel_info(source_id, source_area_id, is_used, p_type_2) " +
                    "VALUES (" + channelInfo.getSourceId() + "," + channelInfo.getSourceAreaId() + "," + channelInfo.getIsUsed() + "," + channelInfo.getPType2() + ")";
            int rowsAffected = statement.executeUpdate(insertSQL);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(String sourceAreaId) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "DELETE FROM channel_info(source_area_id) " +
                    "VALUES (" + sourceAreaId + ")";
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
            String insertSQL = "UPDATE channel_info SET source_id=" + channelInfo.getSourceId() + ",is_used=" + channelInfo.getIsUsed() + ",p_type_2=" + channelInfo.getPType2() +
                    "WHERE source_area_id=" + sourceAreaId + ")";
            int rowsAffected = statement.executeUpdate(insertSQL);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Object findBysourceAreaId(String sourceAreaId) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "SELECT channel_info WHERE source_area_id=" + sourceAreaId + ")";
            return statement.executeQuery(insertSQL);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public Object findAll() {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "SELECT * FROM channel_info";
            return statement.executeQuery(insertSQL);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}


