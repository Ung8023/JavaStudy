package com.ung8023.foundation.java;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 通过继承HttpServlet接口创建Servlet
 */
public class ServletExtendsHttp extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        InputStream resourceAsStream = getServletContext().getResourceAsStream("WEB-INF/classes/a.properties");
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        System.out.println(properties.getProperty("name"));
        super.doGet(req, resp);
    }
}
