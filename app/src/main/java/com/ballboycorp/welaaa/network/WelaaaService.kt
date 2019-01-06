package com.ballboycorp.welaaa.network

import com.ballboycorp.welaaa.main.model.Banner
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

/**
 * Created by musooff on 06/01/2019.
 */

class WelaaaService {
    companion object {
        private const val SERVER_BASE_URL = "https://api-prod.welaaa.com/api/v1.0/cms/main/"
    }

    private fun startService(): WelaaaAPI {

        val retrofit = Retrofit.Builder()
                .baseUrl(SERVER_BASE_URL)
                .addConverterFactory(JacksonConverterFactory
                        .create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()

        return retrofit.create(WelaaaAPI::class.java)

    }

    fun getBanners() : Observable<List<Banner>> {
        return startService().getBanners()
    }
}