package org.d3ifcool.MySkin.diary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3ifcool.MySkin.data.DataDiary
import org.d3ifcool.MySkin.data.DataDiaryDao

class MainDiaryViewModel(private val db : DataDiaryDao) : ViewModel() {
    fun insertData(dataDiary: DataDiary) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insertData(dataDiary)
            }
        }
    }
}
