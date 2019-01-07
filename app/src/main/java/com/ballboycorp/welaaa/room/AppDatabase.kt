package com.ballboycorp.welaaa.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ballboycorp.welaaa.main.classfragment.model.Item
import com.ballboycorp.welaaa.main.classfragment.model.Series
import com.ballboycorp.welaaa.main.model.Banner
import com.ballboycorp.welaaa.room.dao.BannerDao
import com.ballboycorp.welaaa.room.dao.ItemDao
import com.ballboycorp.welaaa.room.dao.SeriesDao

/**
 * Created by musooff on 01/01/2019.
 */

@Database(
        entities = [
            Banner::class,
            Series::class,
            Item::class
        ],
        version = 1,
        exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bannerDao(): BannerDao
    abstract fun itemDao(): ItemDao
    abstract fun seriesDao(): SeriesDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context) =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: Room.databaseBuilder(context, AppDatabase::class.java, "welaaa.db")
                                    .fallbackToDestructiveMigration()
                                    .build()
                                    .also {
                                        INSTANCE = it
                                    }
                }

    }
}