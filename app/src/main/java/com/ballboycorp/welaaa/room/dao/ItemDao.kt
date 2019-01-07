package com.ballboycorp.welaaa.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.ballboycorp.welaaa.main.classfragment.model.Item
import io.reactivex.Single

/**
 * Created by musooff on 07/01/2019.
 */

@Dao
interface ItemDao :  BaseDao<Item> {

    @Query("SELECT * FROM Item")
    fun getItems(): Single<List<Item>>

    @Query("SELECT * FROM Item WHERE id = :itemId")
    fun getItem(itemId: Int): Single<Item>

    @Query("DELETE FROM Item")
    fun deleteItems()
}