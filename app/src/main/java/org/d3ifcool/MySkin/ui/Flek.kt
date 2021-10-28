package org.d3ifcool.MySkin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.databinding.FlekBinding
import org.d3ifcool.MySkin.databinding.KusamBinding


class Flek : Fragment(R.layout.flek){

    private lateinit var binding: FlekBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FlekBinding.inflate(layoutInflater,container,false)
        return binding.root

    }
}
