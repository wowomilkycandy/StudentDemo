package controller;

import bean.Page;
import service.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userServlet ")
public class userServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   request.setCharacterEncoding("utf-8");
   response.setCharacterEncoding("utf-8");
   response.setContentType("text/html");

        StudentManager dao=new StudentManager();
        String name=request.getParameter("name");
        System.out.println("love000111");
        Page page=new Page(request,response);
        page=dao.query(page);
        request.setAttribute("page",page);
        request.setAttribute("name",name);
       // request.setAttribute("page",request.getParameter("page"));
        request.getRequestDispatcher("../a/managerUser.jsp").forward(request,response);
    }
}
