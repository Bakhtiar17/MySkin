package org.d3ifcool.MySkin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.databinding.KeriputBinding
import org.d3ifcool.MySkin.databinding.KusamBinding


class Keriput: Fragment(R.layout.keriput){

    private lateinit var binding: KeriputBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = KeriputBinding.inflate(layoutInflater,container,false)
        return binding.root

    }
}
