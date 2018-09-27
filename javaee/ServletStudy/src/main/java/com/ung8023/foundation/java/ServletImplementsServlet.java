package com.ung8023.foundation.java;

import javax.servlet.*;
import java.io.IOException;

/**
 * 通过实现Servlet接口创建Servlet
 */
public class ServletImplementsServlet implements Servlet {

    ServletConfig servletConfig;

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
        servletConfig = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service");
        res.getWriter().write("This is a Servlet");
    }

    @Override
    public String getServletInfo() {
        return "通过实现Servlet接口创建一个Servlet";
    }

    @Override
    public void destroy() {
        System.out.println("servlet销毁了");
    }
}
