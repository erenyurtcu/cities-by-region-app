package com.erenyurtcu.citiesbyregion

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.erenyurtcu.citiesbyregion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var citiesList : ArrayList<Cities>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    val istanbul = Cities("İstanbul","Marmara",R.drawable.istanbul)
    val izmir = Cities("İzmir","Aegean",R.drawable.izmir)
    val ankara = Cities("Ankara","Central Anatolia",R.drawable.ankara)

    citiesList = arrayListOf(istanbul,izmir,ankara)

    val adapter = CitiesAdapter(citiesList)
    binding.citiesRecyclerView.layoutManager = LinearLayoutManager(this)
    binding.citiesRecyclerView.adapter = adapter
    }
}