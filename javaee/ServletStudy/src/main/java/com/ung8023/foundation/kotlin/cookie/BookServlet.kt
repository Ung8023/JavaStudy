package com.ung8023.foundation.kotlin.cookie

import javax.servlet.http.Cookie
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * 显示书籍详细信息
 */
class BookServlet: HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val writer = resp?.writer
        // 根据用户带过来的id显示详细信息
        resp?.characterEncoding = "UTF-8"
        resp?.contentType = "text/html;charset=UTF-8"

        val id = req?.getParameter("id")
        val book = AllShopItems.allBooks[id]
        writer?.write("书籍名: ${book?.name?:""} <br />")
        writer?.write("作  者: ${book?.author?:""} <br />")
        writer?.write("描  述: ${book?.description?:""} <br />")

        // 构建cookie，回写给浏览器
        val cookieStr = buildCookie(id, req)
        val cookie = Cookie("bookHistory", cookieStr)
        cookie.maxAge = 1*30*24*3600
        cookie.path = "/"
        resp?.addCookie(cookie)
    }

    fun buildCookie(id: String?, req: HttpServletRequest?): String? {
        var bookHistory: String? = null
        val cookies = req?.cookies
        val find = cookies?.find { it.name.equals("bookHistory") }
        bookHistory = find?.value

        bookHistory?:return id

        val split = ArrayList(bookHistory.split(","))
        if (split.contains(id)) {
            split.remove(id)
            split.add(0, id)
        }else {
            if (split.size >= 3) {
                split.removeAt(split.size - 1)
                split.add(0, id)
            }else {
                split.add(0, id)
            }
        }
        return split.joinToString(",")
    }

}