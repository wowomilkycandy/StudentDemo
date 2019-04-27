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

        String name=request.getParameter("name1");
        String name11=request.getParameter("name11");
        String psw=request.getParameter("psw");


        String ses=request.getParameter("ses");
        String acade=request.getParameter("acade");
        System.out.println(id + "---" + name11 + "---" + psw+"--------"+name );
       int dd= Integer.parseInt(request.getParameter("dd"));
       boolean dd1= Boolean.parseBoolean(request.getParameter("dd1"));
        if(name==null||psw==null){
            PrintWriter out = response.getWriter();
            request.setAttribute("id",id);
            request.setAttribute("dd",dd);
            //out.print("<script language='JavaScript'>alert('not empty2');window.location.href='../a/updateUser.jsp';</script>");
            request.getRequestDispatcher("../a/updateUser.jsp").forward(request, response);
        }
        else {
            System.out.println(id + "---" + name11 + "---" + psw );
            Student u = dao.query(name11);
            System.out.println(u);
            u.setId(u.getId());
            u.setName(name);
            u.setPsw(MD5.MD5Encode(psw));
            u.setGender(ses);
            u.setBirDate(acade);
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+u.getName());
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+u.getId());
            if (dao.updateUser(u)) {
                System.out.println("mememesuccess");
                Page page=new Page(request,response);
                page=dao.query(page);
                request.setAttribute("page", page);
                request.setAttribute("dd",dd);
                if(dd1)
                {
                    PrintWriter out=response.getWriter();

                    out.print("<script>language='javascript'>alert('update successfully');window.location.href='../index.jsp';</script>");

                }
                else if(dd==2){
                    request.getRequestDispatcher("../a/managerUser.jsp").forward(request,response);
                }
                else {
                    PrintWriter out=response.getWriter();

                    out.print("<script>language='javascript'>alert('update successfully');window.location.href='../index.jsp';</script>");

                }

            } else {
                System.out.println("mememefail");
            }
        }
    }
}
