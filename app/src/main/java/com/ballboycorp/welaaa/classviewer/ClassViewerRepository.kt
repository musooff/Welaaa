package com.ballboycorp.welaaa.classviewer

import android.content.Context
import com.ballboycorp.welaaa.main.classfragment.model.Item
import com.ballboycorp.welaaa.room.AppDatabase
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by musooff on 07/01/2019.
 */

class ClassViewerRepository (val context: Context) {

    fun getItem(itemId: Int) : Single<Item> {
        return getAppDatabase().itemDao().getItem(itemId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    private fun getAppDatabase() = AppDatabase.getInstance(context)
}