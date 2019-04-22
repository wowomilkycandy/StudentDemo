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



        System.out.println("执行分页查询");
        String loginName=request.getParameter("loginName");

       StudentManager dao=new StudentManager();
       // User u=userDao.query(loginName);
        Page page=new Page(request,response);
        page=dao.query(page);
        //for(int i=0;i<=b1.size();i++){System.out.println(b1["A"]["title"]);}
        System.out.println("bbbbbbbbbbbbbbb1");

        //Object b2=b1.get(1).get(1);
        // System.out.println(b1.get(1).get("id"));
        request.setAttribute("page",page) ;
        request.setAttribute("name",loginName);
        request.getRequestDispatcher("../a/managerUser.jsp").forward(request, response);
        /*if(u.getType().equals("admist"))
            request.getRequestDispatcher("../a/managerBlog.jsp").forward(request, response);
        else {
            request.getRequestDispatcher("../a/loginShow.jsp").forward(request, response);

        }*/

    }
}
