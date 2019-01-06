package com.ballboycorp.welaaa.network

import com.ballboycorp.welaaa.main.classfragment.model.Series
import com.ballboycorp.welaaa.main.model.Banner
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by musooff on 06/01/2019.
 */

interface WelaaaAPI {

    @GET("v1.0/cms/main/banner")
    fun getBanners(): Observable<List<Banner>>

    @GET("v1.0/contents/audiobooks/group-by/categories")
    fun getAudiobookCategories()

    @GET("v1.1/contents/audiobooks")
    fun getAudiobook(@Query("ccode") ccode: String, @Query("page") page: Int)

    @GET("v1.0/contents/video-series")
    fun getVideoSeries(): Observable<List<Series>>
}