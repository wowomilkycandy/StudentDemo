package controller;

import bean.MD5;
import bean.Student;
import service.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        Student u=new Student();
        StudentManager dao=new StudentManager();
        String userName=request.getParameter("username");//获取用户名密码
        String id=request.getParameter("id");//获取用户名密码
        String psw=request.getParameter("psw");
        String ses=request.getParameter("ses");
        String acade=request.getParameter("acade");

       String mPsw=MD5.MD5Encode(psw);//对密码进行加密
        u.setName(userName);
        u.setPsw(mPsw);
        //将密码与用户设置给用户
        u.setId(id);
        u.setBirDate(acade);
        u.setGender(ses);
        /*User uexist=dao.query(userName);
        if(uexist==null||uexist.equals(null)){
            PrintWriter out = response.getWriter();

            out.print("<script language='JavaScript'>alert('用户名已经存在');window.location.href='/login.jsp';</script>");

        }
        else {*/
            try {


                if (dao.addUser(u)) {
                    PrintWriter out = response.getWriter();

                    out.print("<script language='JavaScript'>alert('注册成功111');window.location.href='/login.jsp';</script>");

                } else {
                    PrintWriter out = response.getWriter();

                    out.print("<script language='JavaScript'>alert('注册失败222，请重新注册');window.location.href='/login.jsp';</script>");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
       /* }*/
    }
}
