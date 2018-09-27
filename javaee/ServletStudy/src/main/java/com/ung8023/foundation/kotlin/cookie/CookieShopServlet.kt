package com.ung8023.foundation.kotlin.cookie

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


/**
 案例：实现显示用户上次浏览过的商品
 */
class CookieShopServlet : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.characterEncoding = Charsets.UTF_8.name()
        resp?.contentType = "text/html;charset=UTF-8"

        // 显示所有的商品
        val writer = resp?.writer
        writer?.write("本站有如下商品<br/>")
        writer?.write("<ul>")
        AllShopItems.allBooks.forEach { t, u ->
            writer?.write("<li><a href='/book?id=${u.id}'>${u.name}</a></li>")
        }
        writer?.write("</ul>")

        //显示用户看过的商品
        // 显示所有的商品
        writer?.write("<br />您曾经浏览过的商品<br/>")
        val cookies = req?.cookies
        writer?.write("<ul>")
        cookies?.forEach {
            if (it.name.equals("bookHistory")) {
                val ids = it.value.split(",")
                ids.forEach {
                    val book = AllShopItems.allBooks[it]
                    writer?.write("<li><a href='/book?id=${book?.id}'>${book?.name}</a></li>")
                }
            }
        }

        writer?.write("</ul>")
    }
}