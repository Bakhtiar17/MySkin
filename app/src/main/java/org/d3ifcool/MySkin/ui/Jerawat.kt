package org.d3ifcool.MySkin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.databinding.JerawatBinding


class Jerawat : Fragment(R.layout.jerawat){

        private lateinit var binding:JerawatBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            binding = JerawatBinding.inflate(layoutInflater,container,false)
        return binding.root

    }
}
