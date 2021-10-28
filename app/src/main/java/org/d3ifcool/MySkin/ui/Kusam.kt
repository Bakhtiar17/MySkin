package org.d3ifcool.MySkin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.databinding.KusamBinding


class Kusam : Fragment(R.layout.kusam){

    private lateinit var binding: KusamBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = KusamBinding.inflate(layoutInflater,container,false)
        return binding.root

    }
}
