package org.d3ifcool.MySkin.tips

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import org.d3ifcool.MySkin.R

class TipsAndTriks: Fragment(R.layout.tips_and_tricks) {

    private var isTablet: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        isTablet = resources.getBoolean(R.bool.isTablet)
    }
}