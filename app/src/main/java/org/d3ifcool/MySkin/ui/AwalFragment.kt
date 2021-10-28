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
    private lateinit var binding: FragmentAwalBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentAwalBinding.inflate(layoutInflater, container, false)

        binding.button3.setOnClickListener { view: View -> view.findNavController().navigate(
            R.id.action_awalFragment_to_diaryDummy
        )
        }

        binding.button2.setOnClickListener { view: View -> view.findNavController().navigate(
            R.id.action_awalFragment_to_tipsAndTricks
        )
        }

        binding.button4.setOnClickListener { view: View -> view.findNavController().navigate(
            R.id.action_awalFragment_to_video
        )
        }
        return binding.root
    }

}
