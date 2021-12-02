package org.d3ifcool.MySkin.diary

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.data.DataDiary
import org.d3ifcool.MySkin.databinding.DialogDiaryMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainDiaryDialog : DialogFragment() {
    private lateinit var binding: DialogDiaryMainBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(requireContext())
        binding = DialogDiaryMainBinding.inflate(inflater, null, false)
        val builder = AlertDialog.Builder(requireContext()).apply {
            setTitle(R.string.tambah_diary)
            setView(binding.root)


            setPositiveButton(R.string.simpan) { _, _ ->
                val dataDiary= getData() ?: return@setPositiveButton
                val listener = requireActivity() as DialogListener
                listener.processDialog(dataDiary)
            }
            setNegativeButton(R.string.batal) { _, _ -> dismiss() }
        }
        return builder.create()

    }

    interface DialogListener {
        fun processDialog(dataDiary: DataDiary)
    }

    private fun getData(): DataDiary? {
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm")
        val currentDate = sdf.format(Date())

        if (binding.judulEditText.text.isEmpty()) {
            showMessage(R.string.judul_wajib_diisi)
            return null
        }
        if (binding.isiEditText.text.isEmpty()) {
            showMessage(R.string.deskripsi_wajib_diisi)
            return null
        }

        return DataDiary(
            judul = binding.judulEditText.text.toString(),
            isi= binding.isiEditText.text.toString(),
            tanggal = currentDate
        )
    }

    private fun showMessage(messageResId: Int) {
        Toast.makeText(requireContext(), messageResId, Toast.LENGTH_LONG).apply {
            setGravity(Gravity.CENTER, 0, 0)
            show()
        }
    }
}