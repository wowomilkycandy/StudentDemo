package service;


import bean.Dbutil;
import bean.Page;
import bean.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentManager {

        public boolean addUser(Student user) throws Exception{

            String sql="insert into user (id,name,psw,gender,birDate) values(?,?,?,?,?)";
            System.out.println("------------------------------------------------------------------------------------"+user.getId());
            Connection conn= Dbutil.getConnection();
            PreparedStatement ptmt=conn.prepareStatement(sql);
            try {
                ptmt.setString(1,user.getId());
                ptmt.setString(2,user.getName());
                ptmt.setString(3,user.getPsw());
                ptmt.setString(4,user.getGender());
                ptmt.setString(5,user.getBirDate());
                ptmt.execute();
                return true;
            } catch (Exception e) {
                // TODO Auto-generated catch block


                return false;
            }
        }
        public boolean delUser(String id) throws SQLException {
            String sql="delete from user where id=?";
            Connection conn=Dbutil.getConnection();
            PreparedStatement ptmt=conn.prepareStatement(sql);
            try {

                ptmt.setString(1,id);
                ptmt.execute();

                return true;
            } catch (Exception e) {
                // TODO Auto-generated catch block

                return false;
            }
        }
        public boolean updateUser(Student user){
            String sql="update user set name=?,psw=?,gender=?,birDate=?  where id=?";
            Connection conn=Dbutil.getConnection();
                     try {
                PreparedStatement ptmt=conn.prepareStatement(sql);

                //ptmt.setString(1,user.getId());
                ptmt.setString(1,user.getName());
                ptmt.setString(2,user.getPsw());
                ptmt.setString(3,user.getGender());
                ptmt.setString(4,user.getBirDate());

                ptmt.setString(5,user.getId());
                ptmt.execute();

                return true;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                return false;
            }


        }

    public List<Student> query(){
        String sql="select * from user";
        Connection conn=Dbutil.getConnection();
        ResultSet rs=null;
        List<Student> list=new ArrayList<Student>();
        Student user=null;
        try {
            PreparedStatement ptmt=conn.prepareStatement(sql);
            rs=ptmt.executeQuery();
            while(rs.next()){
               user=new Student();
               user.setId(rs.getString("id"));

               user.setName(rs.getString("name"));
                user.setPsw(rs.getString("psw"));
                user.setGender(rs.getString("gender"));
                user.setBirDate(rs.getString("birDate"));


                list.add(user);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }
    public static List<Map<String, Object>> convertList(ResultSet rs) {
        // 新建一个map list集合用于存放多条查询记录
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            ResultSetMetaData md = rs.getMetaData();// 结果集(rs)的结构信息，比如字段数、字段名等。
            int columnCount = md.getColumnCount();// 取得查询出来的字段个数
            while (rs.next()) {// 迭代rs
                // 新建一个map集合 将查询出内容按照字段名：值 的键值对形式存储在map集合中
                Map<String, Object> rowData = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {// 循环所有查询出字段
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                    // getColumnName(i) 获取第i个列名
                    // getObject(i) 获取第i个对象的值
                }
                list.add(rowData);// 将map放入list集合中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {// 关闭连接
            try {
                if (rs != null)
                    rs.close();
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public Page query(Page page){
        String sql="select * from user limit ?,?";
        Connection conn=Dbutil.getConnection();
        ResultSet rs=null;
        List list=new ArrayList<Student>();
        Student user=null;
        try {
            PreparedStatement ptmt=conn.prepareStatement(sql);
            ptmt.setInt(1, (page.getPageNo()-1)*page.getPageSize());
            ptmt.setInt(2, page.getPageSize());
            System.out.println("woshiyigeaaa223311330000");
            rs=ptmt.executeQuery();
            list=convertList(rs);

            page.setList(list);
            sql = "select count(*) from user";
            ptmt = conn.prepareStatement(sql);
           rs = ptmt.executeQuery();
            if(rs.next()) {
                int totalRecords = rs.getInt(1);  //rs.getInt("count(*)")也是可以的
                page.setCount(totalRecords);
            }
            return page;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public Page query(Page page,String name){
        String sql="select * from user where name=? limit ?,?  ";
        Connection conn=Dbutil.getConnection();
        ResultSet rs=null;
        List list=new ArrayList<Student>();
        Student user=null;
        try {
            PreparedStatement ptmt=conn.prepareStatement(sql);
            ptmt.setString(1,name);
            ptmt.setInt(2, (page.getPageNo()-1)*page.getPageSize());
            ptmt.setInt(3, page.getPageSize());

            System.out.println("woshiyigeaaa223311330000");
            rs=ptmt.executeQuery();
            list=convertList(rs);

            page.setList(list);
            sql = "select count(*) from user";
            ptmt = conn.prepareStatement(sql);
            rs = ptmt.executeQuery();
            if(rs.next()) {
                int totalRecords = rs.getInt(1);  //rs.getInt("count(*)")也是可以的
                page.setCount(totalRecords);
            }
            return page;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    public Student query(String name){//根据登录名查询
        String sql="select * from user where name=?";
        Connection conn=Dbutil.getConnection();
        ResultSet rs=null;

        Student user=null;
        try {
            PreparedStatement ptmt=conn.prepareStatement(sql);
            ptmt.setString(1,name);
            rs=ptmt.executeQuery();
           if(rs.next()){
                user=new Student();
               user.setId(rs.getString("id"));

               user.setName(rs.getString("name"));
               user.setPsw(rs.getString("psw"));
               user.setGender(rs.getString("gender"));
               user.setBirDate(rs.getString("birDate"));


            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return user;
    }


    public Student query1(String name){//根据登录名查询
        String sql="select * from user where name=?";
        Connection conn=Dbutil.getConnection();
        ResultSet rs=null;

        Student user=null;
        try {
            PreparedStatement ptmt=conn.prepareStatement(sql);
            ptmt.setString(1,name);
            rs=ptmt.executeQuery();
            if(rs.next()){
                user=new Student();
                user.setId(rs.getString("id"));

                user.setName(rs.getString("name"));
                user.setPsw(rs.getString("psw"));
                user.setGender(rs.getString("gender"));
                user.setBirDate(rs.getString("birDate"));



            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return user;
    }
    public void app(int i, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentManager userDao=new StudentManager();

        Page page=new Page(request,response);
        page=userDao.query(page);
        if(i==1)//增加
            request.getRequestDispatcher("../a/addUser.jsp").forward(request, response);
        if(i==2)//查找。。。。
        {
            request.setAttribute("page",page) ;
            request.getRequestDispatcher("../a/searchStudent.jsp").forward(request, response);
        }

        if(i==3)//删除一个，，，，
        {
            request.setAttribute("page",page) ;
            request.getRequestDispatcher("../a/searchStudent.jsp").forward(request, response);
        }
        if(i==7)//删除多个
        {
            request.setAttribute("page",page) ;
            request.getRequestDispatcher("../a/managerUser.jsp").forward(request, response);
        }
        if(i==4)//修改一个
        {
            request.setAttribute("page",page) ;
            boolean dd1=true;
            request.setAttribute("dd1",dd1) ;
            request.getRequestDispatcher("../a/searchStudent.jsp").forward(request, response);
        }
        if(i==8)//修改多个
        {
            request.setAttribute("page",page) ;

            request.getRequestDispatcher("../a/managerUser.jsp").forward(request, response);
        }
        if(i==5)//输出
        {
            request.setAttribute("page",page) ;
            request.getRequestDispatcher("../a/managerUser.jsp").forward(request, response);
        }
        if(i==6)//退出

            request.getRequestDispatcher("../index.jsp").forward(request, response);

    }

}
