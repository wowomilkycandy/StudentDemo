package controller;

import bean.MD5;
import bean.Page;
import bean.Student;
import service.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addUserServlet")
public class addUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();

        StudentManager dao=new StudentManager();
        Student u=new Student();
        String loginName=request.getParameter("name");
        String psw=request.getParameter("psw");
        String ids=request.getParameter("ids");
        String ses=request.getParameter("ses");
        String acade=request.getParameter("acade");
        if(loginName==null||psw==null||ids==null){
            PrintWriter out = response.getWriter();
            out.print("<script language='JavaScript'>alert('not empty2');window.location.href='../a/addUser.jsp';</script>");

        }
        else {
            u.setId( ids );
            u.setBirDate(acade);
            u.setGender(ses);
            u.setName(loginName);
            u.setPsw(MD5.MD5Encode(psw));


            try {
                if (dao.addUser(u)) {
                    Page page=new Page(request,response);
                    page=dao.query(page);
                    request.setAttribute("page", page);
                    System.out.println("sucess");
                    System.out.println("fail");
                    PrintWriter out = response.getWriter();
                    out.print("<script language='JavaScript'>alert('add success');window.location.href='../index.jsp';</script>");


                } else {
                    System.out.println("fail");
                    PrintWriter out = response.getWriter();
                    out.print("<script language='JavaScript'>alert('add fail');window.location.href='../a/addUser.jsp';</script>");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
