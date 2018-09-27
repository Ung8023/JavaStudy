package com.ung8023.foundation.kotlin

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class UseServletContext : HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val pServletContext = servletConfig?.servletContext
        pServletContext?.getRequestDispatcher("/a")?.forward(req, resp)
    }
}