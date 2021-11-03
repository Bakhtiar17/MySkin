package org.d3ifcool.MySkin.diary

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.DialogFragment
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.databinding.DialogDiaryMainBinding

class MainDiaryDialog : DialogFragment() {
    private lateinit var binding: DialogDiaryMainBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = LayoutInflater.from(requireContext())
        binding = DialogDiaryMainBinding.inflate(inflater, null, false)
        val builder = AlertDialog.Builder(requireContext()).apply {
            setTitle(R.string.tambah_diary)
            setView(binding.root)
            setPositiveButton(R.string.simpan) { _, _ ->
                val listener = requireActivity() as DialogListener
                listener.processDialog()
            }
            setNegativeButton(R.string.batal) { _, _ -> dismiss() }
        }
        return builder.create()

    }

    interface DialogListener {
        fun processDialog()

    }
}