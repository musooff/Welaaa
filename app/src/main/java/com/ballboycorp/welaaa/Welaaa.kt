package com.ballboycorp.welaaa

import android.app.Application
import com.facebook.stetho.Stetho

/**
 * Created by musooff on 06/01/2019.
 */

class Welaaa : Application() {

    override fun onCreate() {
        super.onCreate()


        Stetho.initializeWithDefaults(this)
    }
}