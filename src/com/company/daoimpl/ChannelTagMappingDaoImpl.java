package com.company.daoimpl;

import com.company.bean.ChannelTagMapping;
import com.company.dao.ChannelTagMappingDao;
import com.company.util.ResultSetToJson;

import java.sql.*;

public class ChannelTagMappingDaoImpl implements ChannelTagMappingDao {
    private static final String URL = "jdbc:mysql://localhost:3306/training?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "abc123";
    @Override
    public void add(ChannelTagMapping channelTagMapping) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "INSERT INTO channel_tag_mapping(s_area_id, tag_id) " +
                    "VALUES ('" + channelTagMapping.getSourceAreaId() + "'," + channelTagMapping.getTagId() +")";
            int rowsAffected = statement.executeUpdate(insertSQL);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(String sourceAreaId, int tagId) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "DELETE FROM channel_tag_mapping WHERE s_area_id = '"+ sourceAreaId + "'AND tag_id =" + tagId + ")";
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
            String insertSQL = "SELECT channel_tag_mapping WHERE s_area_id ='" + sourceAreaId + "'";
            ResultSet rs = statement.executeQuery(insertSQL);
            return ResultSetToJson.ResultSetToJsonArray(rs);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Object findByTagId(int tagId) {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "SELECT channel_tag_mapping WHERE tag_id =" + tagId;
            ResultSet rs = statement.executeQuery(insertSQL);
            return ResultSetToJson.ResultSetToJsonArray(rs);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Object findAll() {
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            String insertSQL = "SELECT * FROM channel_tag_mapping";
            ResultSet rs = statement.executeQuery(insertSQL);
            return ResultSetToJson.ResultSetToJsonArray(rs);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
