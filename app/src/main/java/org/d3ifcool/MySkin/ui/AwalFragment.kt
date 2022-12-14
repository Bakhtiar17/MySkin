package org.d3ifcool.MySkin.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import org.d3ifcool.MySkin.R
import org.d3ifcool.MySkin.databinding.FragmentAwalBinding

class AwalFragment : Fragment(R.layout.fragment_awal) {

    private var isTablet: Boolean = false
    private lateinit var binding: FragmentAwalBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        isTablet = resources.getBoolean(R.bool.isTablet)
        binding = FragmentAwalBinding.inflate(layoutInflater, container, false)

        binding.button0.setOnClickListener { view: View -> view.findNavController().navigate(
            R.id.action_awalFragment_to_test
        ) }

        binding.button.setOnClickListener { view: View -> view.findNavController().navigate(
            R.id.action_awalFragment_to_masalah_kulit
        ) }

        binding.button3.setOnClickListener { view: View -> view.findNavController().navigate(
            R.id.action_awalFragment_to_diaryPage
        )
        }

        binding.button2.setOnClickListener { view: View -> view.findNavController().navigate(
            R.id.action_awalFragment_to_tipsAndTriks
        )
        }

        binding.button4.setOnClickListener { view: View -> view.findNavController().navigate(
            R.id.action_awalFragment_to_video
        )
        }

        return binding.root
    }

}
