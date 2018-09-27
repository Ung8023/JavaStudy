package com.ung8023.foundation.kotlin

import java.nio.charset.Charset
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 解决编码问题
 */
class RequestAndResponseServlet : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {

        // 第一种方式，通过设置header指定客户端打开编码
        val str = "这是一个中文字符串\n"
        // 程序以什么码表输出，一定要控制浏览器以什么码表打开
        resp?.setHeader("Content-type", "text/html;charset=UTF-8")
        resp?.outputStream?.write(str.toByteArray(Charset.forName("UTF-8")))

        val data = "这是第二个字符串\n"
        // html : <meta>标签模拟一个http响应头
        resp?.outputStream?.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'>".toByteArray(Charsets.UTF_8))
        resp?.outputStream?.write(data.toByteArray(Charsets.UTF_8))

        val data2 = "这是第三个字符串\n"
        // 设置 response使用的码表，以控制 response 以什么码表向浏览器输入数据，默认为ISO-8859-1
        resp?.characterEncoding = "UTF-8"
        //指定浏览器以什么码表打开服务器发送的数据
        resp?.setHeader("Content-type", "text/html;charset=UTF-8")
        resp?.writer?.write(data2)

        val data3 = "这是第四个字符串\n"
        resp?.contentType = "text/html;charset=UTF-8"
        resp?.writer?.write(data3)
    }
}