package org.d3ifcool.MySkin.diary

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
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

    private var actionMode: ActionMode? = null
    private val actionModeCallback = object : ActionMode.Callback {
        override fun onActionItemClicked(mode: ActionMode?,
                                         item: MenuItem?): Boolean {
            if (item?.itemId == R.id.menu_delete) {
                deleteData()
                return true
            }
            return false
        }
        override fun onCreateActionMode(mode: ActionMode?,
                                        menu: Menu?): Boolean {
            mode?.menuInflater?.inflate(R.menu.diary_delete_mode, menu)
            return true
        }
        override fun onPrepareActionMode(mode: ActionMode?,
                                         menu: Menu?): Boolean {
            return true
        }
        override fun onDestroyActionMode(mode: ActionMode?) {
            actionMode = null
        }
    }

    private val viewModel: MainDiaryViewModel by lazy {
        val dataSource = DataDiaryDb.getInstance(this).dao
        val factory = MainViewModelFactory(dataSource)
        ViewModelProvider(this, factory).get(MainDiaryViewModel::class.java)
    }

    private val handler = object : MainAdapter.ClickHandler {
        override fun onLongClick(): Boolean {
            if (actionMode != null) return false
            actionMode = startSupportActionMode(actionModeCallback)
            return true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DiaryPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myAdapter = MainAdapter(handler)
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

    private fun deleteData() {
        Log.d("MainActivity", "Delete clicked!")
        actionMode?.finish()
    }
}