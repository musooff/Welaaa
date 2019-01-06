package com.ballboycorp.welaaa.utils

import android.util.Log

/**
 * Created by musooff on 01/01/2019.
 */

object Ln {
    private const val ERROR_TAG = "Welaaa Error"
    private const val INFO_TAG = "Welaaa Info"

    fun e(throwable: Throwable) = Log.e(ERROR_TAG, throwable.message.toString())


    fun i(string: String) = Log.i(INFO_TAG, string)
}