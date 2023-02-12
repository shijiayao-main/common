package com.jiaoay.common.logger

import android.util.Log
import java.util.Locale

class LoggerImpl : Logger {

    companion object {
        private const val LineIndex = 5
    }

    override fun v(tag: String, message: Any?) {
        Log.v(tag, getMessage(message))
    }

    override fun d(tag: String, message: Any?) {
        Log.d(tag, getMessage(message))
    }

    override fun i(tag: String, message: Any?) {
        Log.i(tag, getMessage(message))
    }

    override fun w(tag: String, message: Any?) {
        Log.w(tag, getMessage(message))
    }

    override fun e(tag: String, message: Any?) {
        if (message is Throwable) {
            Log.e(tag, getMessage(message.message), message)
        } else {
            Log.e(tag, getMessage(message))
        }
    }

    private fun getMessage(message: Any?): String {
        val lineInfo = getLineInfo()
        if (lineInfo.isEmpty()) {
            return "$message"
        }
        return "$lineInfo: $message"
    }

    /**
     * 获取日志打印时的位置
     */
    private fun getLineInfo(): String {
        try {
            var fileName = ""
            var methodName = ""
            var lineNumber: Int = -1

            val stackTrace = Thread.currentThread().stackTrace
            fileName = stackTrace[LineIndex].fileName
            val method = stackTrace[LineIndex].methodName
            lineNumber = stackTrace[LineIndex].lineNumber
            methodName = if (method.isNullOrEmpty()) {
                ""
            } else {
                method.substring(0, 1).uppercase(Locale.getDefault()) + method.substring(1)
            }
            if (fileName.isEmpty()) {
                return ""
            }
            if (methodName.isEmpty()) {
                return fileName
            }
            if (lineNumber <= 0) {
                return "${fileName}.${methodName}"
            }
            return "${fileName}.${methodName}($lineNumber)"
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }
}