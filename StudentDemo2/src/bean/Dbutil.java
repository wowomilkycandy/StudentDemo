package bean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Dbutil {
    private static final String URL="jdbc:mysql://localhost:3306/studentdemo";//链接数据库
    private static final String USER="root";//数据库loginName
    private static final String PASSWORD="root";//psw
    private static Connection conn=null;
    static {
        try {
            Class.forName ( "com.mysql.jdbc.Driver" );  //建立jdbc链接
            conn = DriverManager.getConnection (URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {  //捕获异常
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
