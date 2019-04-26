package controller;

import bean.Page;
import service.StudentManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "deleteUserServlet ")
public class deleteUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();

        StudentManager dao=new StudentManager();
        String id=  request.getParameter("id") ;
        int dd= Integer.parseInt(request.getParameter("dd"));

        try {

             dao.delUser(id) ;
            Page page=new Page(request,response);
            page=dao.query(page);
            request.setAttribute("page",page);
            request.setAttribute("dd",dd);
            if(dd==2){
                request.getRequestDispatcher("../a/managerUser.jsp").forward(request,response);
            }
            else {
                PrintWriter out=response.getWriter();

                out.print("<script>language='javascript'>alert('delete successfully');window.location.href='../index.jsp';</script>");

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
