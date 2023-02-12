package com.jiaoay.common.logger

import android.util.Log

object CommonLog {
    var logger: Logger = LoggerImpl()

    fun v(tag: String, message: Any?) {
        logger.v(tag = tag, message = message)
    }

    fun d(tag: String, message: Any?) {
        logger.d(tag = tag, message = message)
    }

    fun i(tag: String, message: Any?) {
        logger.i(tag = tag, message = message)
    }

    fun w(tag: String, message: Any?) {
        logger.w(tag = tag, message = message)
    }

    fun e(tag: String, message: Any?) {
        logger.e(tag = tag, message = message)
    }
}
