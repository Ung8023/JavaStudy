package com.ung8023.foundation.kotlin

import javax.servlet.Servlet
import javax.servlet.ServletConfig
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class ServletImplementsServlet: Servlet{

    private var servletConfig: ServletConfig? = null

    override fun getServletConfig(): ServletConfig? {
        return servletConfig
    }

    override fun destroy() {
        println("销毁了")
    }

    override fun init(config: ServletConfig?) {
        servletConfig = config
    }

    override fun getServletInfo(): String = "ServletImplementsServletKt"

    override fun service(req: ServletRequest?, res: ServletResponse?) {
        res?.writer?.write("这是一个Kotlin的Servlet")
    }
}