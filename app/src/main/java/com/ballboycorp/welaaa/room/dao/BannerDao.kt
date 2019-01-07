package com.ballboycorp.welaaa.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.ballboycorp.welaaa.main.model.Banner
import io.reactivex.Single

/**
 * Created by musooff on 06/01/2019.
 */

@Dao
interface BannerDao : BaseDao<Banner> {

    @Query("SELECT * FROM Banner ORDER BY align DESC")
    fun getBanners(): Single<List<Banner>>

    @Query("DELETE FROM Banner")
    fun deleteBanners()
}