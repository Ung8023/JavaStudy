package com.ung8023.foundation.kotlin

import javax.servlet.GenericServlet
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse

class ServletExtendsGeneric : GenericServlet() {
    override fun service(req: ServletRequest?, res: ServletResponse?) {
        res?.writer?.write("这是一个Kotlin的GenericServlet")
    }
}