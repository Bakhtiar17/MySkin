package org.d3ifcool.MySkin.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.databinding.MasalahKulitBinding

class Masalah_kulit : Fragment(R.layout.masalah_kulit) {

    private lateinit var binding: MasalahKulitBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = MasalahKulitBinding.inflate(layoutInflater, container, false)
        binding.but3.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_masalah_kulit_to_flek
            )
        }
        binding.but2.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_masalah_kulit_to_jerawat
            )
        }
        binding.but1.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_masalah_kulit_to_kusam42
            )
        }
        binding.but4.setOnClickListener { view: View ->
            view.findNavController().navigate(
                R.id.action_masalah_kulit_to_keriput
            )
        }
        return binding.root
    }
}


