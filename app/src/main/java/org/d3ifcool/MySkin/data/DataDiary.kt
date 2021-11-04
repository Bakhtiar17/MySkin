package org.d3ifcool.MySkin.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataDiary(
    @PrimaryKey(autoGenerate = true)
    val id: Int= 0,
    val judul: String,
    val isi: String,
    val tanggal: String
)
