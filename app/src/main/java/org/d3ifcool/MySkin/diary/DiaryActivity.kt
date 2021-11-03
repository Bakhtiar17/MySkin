package org.d3ifcool.MySkin.diary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.data.DataDiary
import org.d3ifcool.MySkin.data.DataDiaryDb
import org.d3ifcool.MySkin.databinding.DiaryPageBinding

class DiaryActivity: AppCompatActivity(), MainDiaryDialog.DialogListener {
    private lateinit var binding: DiaryPageBinding
    private lateinit var myAdapter: MainAdapter

    private val viewModel: MainDiaryViewModel by lazy {
        val dataSource = DataDiaryDb.getInstance(this).dao
        val factory = MainViewModelFactory(dataSource)
        ViewModelProvider(this, factory).get(MainDiaryViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DiaryPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myAdapter = MainAdapter()
        with(binding.recyclerView) {
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            setHasFixedSize(true)
            adapter = myAdapter
        }

        viewModel.data.observe(this, { myAdapter.submitList(it) })
        binding.fab.setOnClickListener {

            MainDiaryDialog().show(supportFragmentManager, "MainDiaryDialog")
        }

    }

    override fun processDialog(dataDiary: DataDiary) {

        viewModel.insertData(dataDiary)

    }
}