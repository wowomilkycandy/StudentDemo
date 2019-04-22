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

@WebServlet(name = "updateUserServlet")
public class updateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();

        StudentManager dao=new StudentManager();
        String id=  request.getParameter("id") ;
        String id11=  request.getParameter("id11") ;
        String name=request.getParameter("name");
        String psw=request.getParameter("psw");


        String ses=request.getParameter("ses");
        String acade=request.getParameter("acade");
        if(name==null||psw==null){
            PrintWriter out = response.getWriter();
            request.setAttribute("id",id);
            //out.print("<script language='JavaScript'>alert('not empty2');window.location.href='../a/updateUser.jsp';</script>");
            request.getRequestDispatcher("../a/updateUser.jsp").forward(request, response);
        }
        else {
            System.out.println(id + "---" + name + "---" + psw );
            Student u = dao.query1(id11);
            System.out.println(u);
            u.setId(id);
            u.setName(name);
            u.setPsw(MD5.MD5Encode(psw));
            u.setGender(ses);
            u.setBirDate(acade);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+u.getId());
            if (dao.updateUser(u)) {
                System.out.println("mememesuccess");
                Page page=new Page(request,response);
                page=dao.query(page);
                request.setAttribute("page", page);
                request.getRequestDispatcher("../a/managerUser.jsp").forward(request, response);
            } else {
                System.out.println("mememefail");
            }
        }
    }
}
