package controller;

import bean.Page;
import bean.Student;
import service.StudentManager;
import service.UserService;


import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpServletRequest request=(HttpServletRequest)arg0;
		HttpServletResponse response=(HttpServletResponse)arg1;
		
		UserService us=new UserService();
		
		String loginName=request.getParameter("userName");
		String psw=request.getParameter("psw");
		/**
		 * 验证用户名密码是否正确
		 */
		System.out.println(loginName);
		System.out.println(psw);

		if(us.checkLogin(loginName,psw)){
			Student user=us.getUserInfo(loginName);
			request.getSession(true).setAttribute("user", user);
			//User user=us.getUserInfo(loginName);
		/* User user=us.getUserInfo(loginName);
			request.getSession(true).setAttribute("user", user);*/
			
			//其他成功逻辑
			HttpSession session=request.getSession();
			session.setAttribute("thisName",loginName);

			StudentManager userDao=new StudentManager();
			Student u=userDao.query(loginName);
			Page page=new Page(request,response);
			page=userDao.query(page);
			//for(int i=0;i<=b1.size();i++){System.out.println(b1["A"]["title"]);}
			System.out.println("bbbbbbbbbbbbbbb1");

			//Object b2=b1.get(1).get(1);
			// System.out.println(b1.get(1).get("id"));
			request.setAttribute("page",page) ;
			request.setAttribute("name",loginName);


			request.getRequestDispatcher("../a/managerUser.jsp").forward(request, response);

		}else{

			request.setAttribute("msg", "登录失败,请重新登录");


			request.getRequestDispatcher("../login.jsp").forward(request, response);
		}

	}

}
