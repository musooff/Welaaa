package com.ballboycorp.welaaa.network

import com.ballboycorp.welaaa.main.model.Banner
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by musooff on 06/01/2019.
 */

interface WelaaaAPI {

    @GET("banner")
    fun getBanners(): Observable<List<Banner>>
}