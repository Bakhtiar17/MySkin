package org.d3ifcool.MySkin.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataDiary::class], version = 1, exportSchema = false)
abstract class DataDiaryDb : RoomDatabase() {
    abstract val dao : DataDiaryDao
    companion object {
        @Volatile
        private var INSTANCE: DataDiaryDb? = null
        fun getInstance(context: Context): DataDiaryDb {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataDiaryDb::class.java,
                        "dataDiary.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}