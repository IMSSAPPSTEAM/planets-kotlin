package dev.damodaran.planets.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.damodaran.planets.R
import dev.damodaran.planets.api.Planet

class PlanetsAdapter(private val list:List<Planet>, listener:OnPlanetSelectedListener) : RecyclerView.Adapter<PlanetsAdapter.ViewHolder>() {
    var planetClickListener : OnPlanetSelectedListener = listener

    interface OnPlanetSelectedListener {
        fun onPlanetSelected(summary: String,thumbnail:String)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title)
        val summary: TextView = view.findViewById(R.id.summary)
        val thumbnail: ImageView = view.findViewById(R.id.thumbnail)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view=  LayoutInflater.from(parent.context).inflate(
           R.layout.item_planet,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context=holder.itemView.context
       val planet = list[position];
        holder.title.text = planet.name.toUpperCase()
        holder.summary.text = planet.description
        holder.itemView.setOnClickListener {
            planetClickListener.onPlanetSelected(planet.description,
            planet.image)
        }
        Glide.with(context)
            .load(planet.image)
            .centerCrop()
            .into(holder.thumbnail)
    }
}