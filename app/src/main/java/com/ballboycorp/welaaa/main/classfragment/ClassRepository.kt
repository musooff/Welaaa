package com.ballboycorp.welaaa.main.classfragment

import android.content.Context
import com.ballboycorp.welaaa.main.classfragment.model.Item
import com.ballboycorp.welaaa.main.classfragment.model.Series
import com.ballboycorp.welaaa.main.model.Banner
import com.ballboycorp.welaaa.network.WelaaaService
import com.ballboycorp.welaaa.room.AppDatabase
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers

/**
 * Created by musooff on 06/01/2019.
 */

class ClassRepository (private val context: Context) {


    fun getBanners(): Observable<List<Banner>>{
        return getWelaaaService().getBanners()
                .onErrorReturn { emptyList() }
                .zipWith(getAppDatabase().bannerDao().getBanners()
                        .toObservable()
                        .subscribeOn(Schedulers.io()),
                        BiFunction<List<Banner>, List<Banner>, List<Banner>> { bannersRemote, bannersLocal ->
                            if (!bannersRemote.isEmpty()){
                                updateLocalBanners(bannersRemote)
                                bannersRemote
                            }
                            else{
                                bannersLocal
                            }
                        })
                .observeOn(AndroidSchedulers.mainThread())
    }

    private fun updateLocalBanners(banners: List<Banner>){
        Completable.fromAction {
            getAppDatabase().runInTransaction {
                getAppDatabase().bannerDao().deleteBanners()
                getAppDatabase().bannerDao().insertReplace(banners)
            }
        }
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

    fun getPremiumClasses(): Observable<List<Item>> {
        return getWelaaaService().getPremiumClasses()
                .onErrorReturn { emptyList() }
                .zipWith(getAppDatabase().itemDao().getItems()
                        .subscribeOn(Schedulers.io())
                        .toObservable(),
                        BiFunction<List<Series>, List<Item>, List<Item>> { remoteSeries, localItems ->
                            if (!remoteSeries.isEmpty()){
                                updateLocalItems(remoteSeries[3].item)
                                remoteSeries[3].item
                            }
                            else{
                                localItems
                            }
                        })
                .observeOn(AndroidSchedulers.mainThread())

    }

    private fun updateLocalItems(items: List<Item>){
        Completable.fromAction {
            getAppDatabase().runInTransaction {
                getAppDatabase().itemDao().deleteItems()
                getAppDatabase().itemDao().insertReplace(items)
            }
        }
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

    private fun getAppDatabase() = AppDatabase.getInstance(context)

    private fun getWelaaaService() = WelaaaService()
}