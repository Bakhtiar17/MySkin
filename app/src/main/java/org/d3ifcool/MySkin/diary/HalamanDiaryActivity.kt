package org.d3ifcool.MySkin.diary

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.databinding.HalamanDiaryBinding

class HalamanDiaryActivity: AppCompatActivity() {
    private lateinit var binding: HalamanDiaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HalamanDiaryBinding.inflate(layoutInflater)
        setContentView(R.layout.halaman_diary)
        val judulX=intent.getStringExtra("judul" )
        val isiX=intent.getStringExtra("isi" )
        val tanggalX=intent.getStringExtra("tanggal" )

        val judul= findViewById<TextView>(R.id.judulTextView)
        val isi= findViewById<TextView>(R.id.isiTextView)
        val tanggal= findViewById<TextView>(R.id.tanggalWaktu)

        judul.setText(judulX)
        isi.setText(isiX)
        tanggal.setText(tanggalX)


    }
}