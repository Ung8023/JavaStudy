package com.ung8023.foundation.kotlin

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class ServletExtendsHttp : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("doget")
        resp?.writer?.write("这是一个Kotlin的HttpServlet")
//        super.doGet(req, resp)
    }
}