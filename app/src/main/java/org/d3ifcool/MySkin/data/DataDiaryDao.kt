package org.d3ifcool.MySkin.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DataDiaryDao {
    @Insert
    fun insertData(dataDiary: DataDiary)
    @Query("SELECT * FROM datadiary ORDER BY id")
    fun getData(): LiveData<List<DataDiary>>
}