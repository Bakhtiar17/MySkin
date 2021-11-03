package org.d3ifcool.MySkin.diary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.databinding.DiaryPageBinding

class DiaryActivity: AppCompatActivity(), MainDiaryDialog.DialogListener {
    private lateinit var binding: DiaryPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DiaryPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {

            MainDiaryDialog().show(supportFragmentManager, "MainDiaryDialog")
        }

    }

    override fun processDialog() {
        Log.d("DiaryActivity", "Dialog button clicked!")
    }
}