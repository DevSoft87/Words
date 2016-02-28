package com.lx.statistic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Sergey_PC on 23.02.2016.
 */
public class CntDao extends DBHelper{
    public int getCurrKey(String tableName) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet         rs = null;
        int key = 0;
        try{
            conn = getConnection();
            conn.setAutoCommit(false);
            ps = conn.prepareStatement("select CURRKEYNUM from CNT where ID = ?");
            ps.setString(1, tableName);
            if((rs = ps.executeQuery())!= null){
                while (rs.next()){
                    key = rs.getInt(1);
                }
            }
            if(key == 0){
                ps.close();
                ps = conn.prepareStatement("insert into CNT(ID, CURRKEYNUM) values (?, ?)");
                ps.setString(1, tableName);
                ps.setInt   (2, 1);
                ps.executeUpdate();
            }
            ps = conn.prepareStatement("update CNT set CURRKEYNUM = CURRKEYNUM + 1 where ID = ?");
            ps.setString(1, tableName);
            ps.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            e.printStackTrace();
        }finally {
            conn.setAutoCommit(true);
            conn.close();
        }
        return key;
    }
}
