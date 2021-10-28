package org.d3ifcool.MySkin.tips

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.NavController
import org.d3ifcool.MySkin.R

class TipsAndTricks : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tips_and_tricks)

       val pindah = findViewById<ImageView>(R.id.imageTips)

        pindah.setOnClickListener {
            val intent = Intent(this, TipsActivity::class.java)
            startActivity(intent)
        }

        val pindah2 = findViewById<ImageView>(R.id.imageViewTrick)
        pindah2.setOnClickListener {
            val intent = Intent(this, TricksActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}