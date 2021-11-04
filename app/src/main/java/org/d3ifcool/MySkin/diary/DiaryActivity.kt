package org.d3ifcool.MySkin.diary

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.data.DataDiary
import org.d3ifcool.MySkin.data.DataDiaryDb
import org.d3ifcool.MySkin.databinding.DiaryPageBinding

class DiaryActivity: AppCompatActivity(), MainDiaryDialog.DialogListener {
    private lateinit var binding: DiaryPageBinding
    private lateinit var myAdapter: MainAdapter
    private lateinit var navController: NavController

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
        override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            mode?.menuInflater?.inflate(R.menu.diary_delete_mode, menu)
            return true
        }
        override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
            mode?.title = myAdapter.getSelection().size.toString()

            return true
        }
        override fun onDestroyActionMode(mode: ActionMode?) {

            actionMode = null
            myAdapter.resetSelection()

        }
    }

    private val viewModel: MainDiaryViewModel by lazy {
        val dataSource = DataDiaryDb.getInstance(this).dao
        val factory = MainViewModelFactory(dataSource)
        ViewModelProvider(this, factory).get(MainDiaryViewModel::class.java)
    }

    private val handler = object : MainAdapter.ClickHandler {
        override fun onClick(position: Int, dataDiary: DataDiary) {


            if (actionMode != null) {
                myAdapter.toggleSelection(position)
                if (myAdapter.getSelection().isEmpty())
                    actionMode?.finish()
                else
                    actionMode?.invalidate()
                return
            }

            val intent= Intent(this@DiaryActivity, HalamanDiaryActivity::class.java)
            val judul= dataDiary.judul
            val isi= dataDiary.isi
            val tanggal= dataDiary.tanggal
            intent.putExtra("judul", judul)
            intent.putExtra("isi", isi)
            intent.putExtra("tanggal", tanggal)
            startActivity(intent)

        }


        override fun onLongClick(position: Int): Boolean {

        if (actionMode != null) return false
            myAdapter.toggleSelection(position)

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

        viewModel.data.observe(this, {
            myAdapter.submitList(it)
            binding.emptyView.visibility = if (it.isEmpty()) View.VISIBLE
            else View.GONE
        })

        binding.fab.setOnClickListener {

            MainDiaryDialog().show(supportFragmentManager, "MainDiaryDialog")
        }

    }

    override fun processDialog(dataDiary: DataDiary) {

        viewModel.insertData(dataDiary)

    }

    private fun deleteData() = AlertDialog.Builder(this).apply {
        setMessage(R.string.pesan_hapus)
        setPositiveButton(R.string.hapus) { _, _ ->
            viewModel.deleteData(myAdapter.getSelection())
            actionMode?.finish()
        }
        setNegativeButton(R.string.batal) { dialog, _ ->
            dialog.cancel()
            actionMode?.finish()
        }
        show()
    }
}