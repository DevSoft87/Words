package com.lx.statistic.dao;

import java.sql.*;

/**
 * Created by Sergey_PC on 23.02.2016.
 */
public class DBHelper {
//    private String uri = "jdbc:h2:db";
    private String uri = "jdbc:h2:file://d://DB//baseLab";
    private String login = "sa";
    private String password = "";

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Class.forName("org.h2.Driver");
        conn = DriverManager.getConnection(uri, login, password);
        return conn;
    }

    public void initDataBase() throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        if (!isCreatedTables())
            try (Connection conn = getConnection()) {
                ps = conn.prepareStatement(getScriptCreateTables());
                ps.executeUpdate();
            }
    }

    private boolean isCreatedTables() throws SQLException, ClassNotFoundException {
        boolean exists = true;
        ResultSet rs = null;
        Connection conn = getConnection();
        try{
            PreparedStatement ps = conn.prepareStatement("select top 1 1 from CNT");
            if((rs = ps.executeQuery())!= null){
                while (rs.next()){
                    exists = rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            exists = false;
        }
        return exists;
    }

    private String getScriptCreateTables() {
        StringBuilder sb = new StringBuilder();
        sb.append("create table CNT ( ")
                .append("ID                   varchar(25)          not null, ")
                .append("CURRKEYNUM           integer              not null, ")
                .append("constraint PK_CNT primary key (ID) ")
                .append("); ")

                .append("create table FILESTATISTIC ( ")
                .append("ID                  integer              not null, ")
                .append("FILENAME            nvarchar(100)        null, ")
                .append("LONGWORD            nvarchar(150)        null, ")
                .append("SHORTWORD           nvarchar(150)        null, ")
                .append("LONGWORDLENGHT      integer              null, ")
                .append("SHORTWORDLENGHT     integer              null, ")
                .append("ROWLENGHT           integer              null, ")
                .append("AVERAGEWORDLENGHT   integer              null, ")
                .append("COUNTWORDS          integer              null, ")
                .append("constraint PK_STATISTIC_FILE primary key (ID)  ")
                .append("); ")

                .append("create table ROWSTATISTIC ( ")
                .append("ID                  integer              not null, ")
                .append("EXTID               integer              null, ")
                .append("LONGWORD            nvarchar(150)        null, ")
                .append("SHORTWORD           nvarchar(150)        null, ")
                .append("LONGWORDLENGHT      integer              null, ")
                .append("SHORTWORDLENGHT     integer              null, ")
                .append("ROWLENGHT           integer              null, ")
                .append("AVERAGEWORDLENGHT   integer              null, ")
                .append("COUNTWORDS          integer              null, ")
                .append("constraint PK_STATISTIC_ROW primary key (ID) ")
                .append("); ")

                .append("alter table ROWSTATISTIC ")
                .append("   add constraint FK_STATISTI_REFERENCE_STATISTI foreign key (EXTID) ")
                .append("      references FILESTATISTIC(ID) ")
                .append("      on delete restrict on update restrict; ");

        return sb.toString();
    }
}
