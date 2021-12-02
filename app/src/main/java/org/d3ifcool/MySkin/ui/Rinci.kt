package org.d3ifcool.MySkin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.databinding.RinciBinding


class Rinci: Fragment(R.layout.rinci){

    private lateinit var binding: RinciBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = RinciBinding.inflate(layoutInflater,container,false)
        return binding.root

    }
}
