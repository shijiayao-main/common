package com.jiaoay.common.logger

interface Logger {

    fun v(tag: String, message: Any?)

    fun d(tag: String, message: Any?)

    fun i(tag: String, message: Any?)

    fun w(tag: String, message: Any?)

    fun e(tag: String, message: Any?)
}