package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "MyStrutsFilter")
public class MyStrutsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {



            HttpServletRequest request = (HttpServletRequest) req;
            String url = request.getRequestURI();
            System.out.println(url);
            if (url.contains(request.getContextPath()+"/js/utf8-jsp/jsp/controller.jsp")) {
                System.out.println("使用自定义过滤器");
                chain.doFilter(req, resp);
            }else{
                System.out.println("使用默认过滤器");
                this.doFilter(req, resp, chain);
            }
        }


    public void init(FilterConfig config) throws ServletException {

    }

}
