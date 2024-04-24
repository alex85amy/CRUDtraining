package com.company.daoimpl;

import com.company.bean.PType2Info;
import com.company.dao.PType2InfoDao;
import com.company.util.ResultSetToJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class PType2InfoDaoImpl implements PType2InfoDao {

    private final Connection conn;
    private final Logger logger = LogManager.getLogger();

    public PType2InfoDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void add(PType2Info pType2Info) {
        try (Statement statement = conn.createStatement()) {
            String insertSQL = "INSERT INTO p_type_2_info(category, name) " +
                    "VALUES ('" + pType2Info.getCategory() + "','" + pType2Info.getName() + "')";
            statement.executeUpdate(insertSQL);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        try (Statement statement = conn.createStatement()) {
            String insertSQL = "DELETE FROM p_type_2_info WHERE auto_id =" + id;
            statement.executeUpdate(insertSQL);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, PType2Info pType2Info) {
        try (Statement statement = conn.createStatement()) {
            String insertSQL = "UPDATE p_type_2_info SET category='" + pType2Info.getCategory() + "',name='" + pType2Info.getName() +
                    "' WHERE auto_id=" + id;
            statement.executeUpdate(insertSQL);
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public String findById(int id) {
        try (Statement statement = conn.createStatement()) {
            String insertSQL = "SELECT * FROM p_type_2_info WHERE auto_id=" + id;
            ResultSet rs = statement.executeQuery(insertSQL);
            return ResultSetToJson.ResultSetToJsonString(rs, "p_type_2_info");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public String findAll() {
        try (Statement statement = conn.createStatement()) {
            String insertSQL = "SELECT * FROM p_type_2_info";
            ResultSet rs = statement.executeQuery(insertSQL);
            return ResultSetToJson.ResultSetToJsonString(rs, "p_type_2_info");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public void addBatch(List<PType2Info> pType2InfoList) {
        try (PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO p_type_2_info(category, name) VALUES (?, ?)")
        ) {
            int batchSize = 30;//批次數量
            int count = 0; // 計數器，用於計算添加到批次的記錄數量

            for (PType2Info pType2Info : pType2InfoList) {
                preparedStatement.setString(1, pType2Info.getCategory());
                preparedStatement.setString(2, pType2Info.getName());
                preparedStatement.addBatch();// 將操作加入批次
                count++;

                if (count % batchSize == 0) {
                    preparedStatement.executeBatch();// 執行批次操作
                    count = 0; // 重置計數器
                }
            }
            preparedStatement.executeBatch();// 執行最後批次操作

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
