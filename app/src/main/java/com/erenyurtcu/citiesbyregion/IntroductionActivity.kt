package com.erenyurtcu.citiesbyregion

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.erenyurtcu.citiesbyregion.databinding.ActivityIntroductionBinding

class IntroductionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroductionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroductionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val selectedCity = MySingleton.selectedCity
        if (selectedCity != null) {
            Log.d("IntroductionActivity", "Selected city: ${selectedCity.name}")
            binding.imageView.setImageResource(selectedCity.image)
            binding.nameTextView.text = "Name: ${selectedCity.name}"
            binding.regionTextView.text = "Region: ${selectedCity.region}"
        } else {
            Log.e("IntroductionActivity", "Selected city is null")
        }
    }
}
