package org.d3ifcool.MySkin.ui

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.databinding.FragmentAwalBinding
import org.d3ifcool.MySkin.databinding.MasalahKulitBinding

class masalah_kulit : Fragment(R.layout.masalah_kulit){

    private lateinit var binding: MasalahKulitBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = MasalahKulitBinding.inflate(layoutInflater,container,false)
        return binding.root

    }
}


