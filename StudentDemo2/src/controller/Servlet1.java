package controller;

import bean.Page;

import service.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        System.out.println("执行分页查询");      //测试语句
        String loginName=request.getParameter("loginName");

        StudentManager dao=new StudentManager();
        Page page=new Page(request,response);
        page=dao.query(page);
        System.out.println("bbbbbbbbbbbbbbb1");      //测试语句

        request.setAttribute("page",page) ;
        request.setAttribute("name",loginName);
        request.getRequestDispatcher("../a/managerUser.jsp").forward(request, response);
    }
}
