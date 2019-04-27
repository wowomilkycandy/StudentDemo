package controller;

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

@WebServlet(name = "SearchUserServlet ")
public class SearchUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();

        StudentManager dao=new StudentManager();
        Student u=new Student();
        String name=request.getParameter("name");
        int dd= Integer.parseInt(request.getParameter("dd"));
        boolean dd1= Boolean.parseBoolean(request.getParameter("dd1"));
        Page page=new Page(request,response);
        page=dao.query(page,name);
       if(page!=null)

       {

           request.setAttribute("page",page);
           request.setAttribute("name",name);
           request.setAttribute("dd",dd);
           // request.setAttribute("page",request.getParameter("page"));
           if(dd1)
           {
               request.setAttribute("dd1",dd1);
               request.getRequestDispatcher("../a/updateUser.jsp").forward(request,response);
           }
           else if(dd==1){
               request.getRequestDispatcher("../a/managerUser.jsp").forward(request,response);
           }

       }
   else
       {

           System.out.println("hhhhhhhhhbb----jdhcwj");
       }
    }
}
