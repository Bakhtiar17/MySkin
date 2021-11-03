package org.d3ifcool.MySkin.diary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3ifcool.MySkin.data.DataDiaryDao

class MainViewModelFactory(private val dataSource: DataDiaryDao) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainDiaryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainDiaryViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unable to construct ViewModel")
    }
}
