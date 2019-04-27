package service;

import bean.Dbutil;
import com.sun.corba.se.spi.orbutil.fsm.Guard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PageDao {
    public int getPageCount(int pageSize) throws Exception {
        Dbutil DB = new Dbutil();
        Connection conn = DB.getConnection();
        try {


            String sql = "select count(*) from user";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            rs.next();
            int rowsCount = rs.getInt(1);
            int pageCount = (int) Math.ceil(1.0 * rowsCount / pageSize);//算出总共需要多少页
            return pageCount;
        } finally {
            conn.close();
        }
    }}
