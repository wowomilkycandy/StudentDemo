package bean;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
    private static final String URL="jdbc:mysql://localhost:3306/studentdemo";//Á´½ÓÊý¾Ý¿â
    private static final String USER="root";//loginName
    private static final String PASSWORD="root";//psw

    private static Connection conn=null;
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }

}
