package org.d3ifcool.MySkin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.d3ifcool.MySkin.R

import org.d3ifcool.MySkin.databinding.TestBinding


class Test : Fragment(R.layout.test){

    private lateinit var binding: TestBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = TestBinding.inflate(layoutInflater,container,false)
        binding.rinci.setOnClickListener { view: View -> view.findNavController().navigate(
            R.id.action_test_to_rinci
        ) }
        return binding.root

    }
}
