package com.o5appstudio.travelappui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.o5appstudio.travelappui.databinding.ActivityDetailScreenBinding
import com.o5appstudio.travelappui.model.TopTrip

class DetailScreen : AppCompatActivity() {

    private lateinit var binding: ActivityDetailScreenBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<TopTrip>("data")
//        val placeName  = intent.getStringExtra("place")
//        val image = intent.getStringExtra("image")
//        val isFav = intent.getStringExtra("isFav")

        var isFav = data?.isFav

        data?.image?.let { binding.placeImge.setImageResource(it) }

        if (data != null) {
            binding.placeNameDetail.text = data.place
            binding.placeNameHeading.text = data.place
            binding.countryName.text = data.country
            binding.favIcon.setImageResource(if(isFav == true) R.drawable.favorite else R.drawable.unfavorite)

            DrawableCompat.setTint(
                DrawableCompat.wrap(binding.favIcon.getDrawable()),
                ContextCompat.getColor(this, if(isFav == true) R.color.themeApp else R.color.lightGrayApp)
            );

        }

        binding.favIcon.setOnClickListener {
            if(isFav == true){
                isFav = false
                binding.favIcon.setImageResource(R.drawable.unfavorite)
            } else{
                isFav = true
                binding.favIcon.setImageResource(R.drawable.favorite)
            }
        }

        binding.backBtn.setOnClickListener {
            finish()
        }



    }

}