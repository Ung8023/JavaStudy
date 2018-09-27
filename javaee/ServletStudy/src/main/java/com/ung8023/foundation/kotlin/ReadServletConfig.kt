package com.ung8023.foundation.kotlin

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ReadServletConfig : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val userName = servletConfig?.getInitParameter("username")
        val level = servletConfig?.getInitParameter("level")
        resp?.writer?.write("用户: $userName, 等级: $level")
    }
}