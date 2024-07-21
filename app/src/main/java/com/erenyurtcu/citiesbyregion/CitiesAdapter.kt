package com.erenyurtcu.citiesbyregion

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erenyurtcu.citiesbyregion.databinding.RecyclerRowBinding

class CitiesAdapter(val citiesList: ArrayList<Cities>) : RecyclerView.Adapter<CitiesAdapter.CitiesViewHolder>() {

    class CitiesViewHolder(val binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CitiesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return citiesList.size
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        val city = citiesList[position]
        holder.binding.textViewRecyclerView.text = city.name

        holder.itemView.setOnClickListener {
            Log.d("CitiesAdapter", "City clicked: ${city.name}")
            MySingleton.selectedCity = city
            val intent = Intent(holder.itemView.context, IntroductionActivity::class.java)
            Log.d("CitiesAdapter", "Starting IntroductionActivity for city: ${city.name}")
            holder.itemView.context.startActivity(intent)
        }
    }
}
