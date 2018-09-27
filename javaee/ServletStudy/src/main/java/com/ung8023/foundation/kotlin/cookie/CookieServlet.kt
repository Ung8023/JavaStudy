package com.ung8023.foundation.kotlin.cookie

import java.util.*
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class CookieServlet : HttpServlet(){

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.characterEncoding = Charsets.UTF_8.name()
        resp?.contentType = "text/html;charset=UTF-8"

        val writer = resp?.writer
        writer?.write("上次访问时间: ")
        val cookies = req?.cookies

        val filterCookies = cookies?.filter { it?.name?.equals("lastAccessTime") ?: false }
        filterCookies?.forEach {
            writer?.write(Date(it?.value?.toLong()?:0).toLocaleString())
        }

        val cookie = Cookie("lastAccessTime", "${System.currentTimeMillis()}")
        cookie.maxAge = 3600
        cookie.path = "/cookie"
        resp?.addCookie(cookie)
    }

}