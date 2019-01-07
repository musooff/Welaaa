package com.ballboycorp.welaaa.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.ballboycorp.welaaa.main.classfragment.model.Series
import io.reactivex.Single

/**
 * Created by musooff on 07/01/2019.
 */

@Dao
interface SeriesDao : BaseDao<Series> {

    @Query("SELECT * FROM Series")
    fun getItems(): Single<List<Series>>
}