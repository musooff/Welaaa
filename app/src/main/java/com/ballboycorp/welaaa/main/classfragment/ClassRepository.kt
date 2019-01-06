package com.ballboycorp.welaaa.main.classfragment

import android.content.Context
import com.ballboycorp.welaaa.main.model.Banner
import com.ballboycorp.welaaa.network.WelaaaService
import com.ballboycorp.welaaa.room.AppDatabase
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by musooff on 06/01/2019.
 */

class ClassRepository (private val context: Context) {

    fun getBanners(): Observable<List<Banner>> {
        return getAppDatabase().bannerDao().getBanners()
                .subscribeOn(Schedulers.io())
                .flatMapObservable {
                    if (!it.isEmpty()){
                        Observable.just(it)
                    }
                    else {
                        downloadBanners()
                    }
                }
                .observeOn(AndroidSchedulers.mainThread())
    }

    private fun downloadBanners(): Observable<List<Banner>>{
        return getWelaaaService().getBanners()
                .doOnNext { getAppDatabase().bannerDao().insertReplace(it) }
    }

    private fun getAppDatabase() = AppDatabase.getInstance(context)

    private fun getWelaaaService() = WelaaaService()
}