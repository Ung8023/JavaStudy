package com.ung8023.foundation.kotlin.cookie

import java.util.LinkedHashMap

object AllShopItems {
    val allBooks = LinkedHashMap<String, Book>().apply {
        put("1", Book("1", "小说1", "张三", "好小说"))
        put("2", Book("2", "小说2", "李四", "好小说"))
        put("3", Book("3", "小说3", "王屋", "好小说"))
        put("4", Book("4", "小说4", "赵六", "好小说"))
        put("5", Book("5", "小说5", "孙奇", "好小说"))
    }
}