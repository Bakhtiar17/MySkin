package org.d3ifcool.MySkin.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface DataDiaryDao {
    @Insert
    fun insertData(dataDiary: DataDiary)
}