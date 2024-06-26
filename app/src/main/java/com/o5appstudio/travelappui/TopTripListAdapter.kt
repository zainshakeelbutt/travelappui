package com.o5appstudio.travelappui

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.o5appstudio.travelappui.model.TopTrip

class TopTripListAdapter(val context: Context, val tripList: List<TopTrip>) : Adapter<TopTripListAdapter.TripViewHolder>() {

    var currentPosition : Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.top_trip_item, parent, false)
        return  TripViewHolder(view)
    }

    override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
        val pos = tripList[position]
        holder.image.setImageResource(pos.image)
        holder.country.text = pos.country
        holder.place.text = pos.place
        holder.favBtn.setImageResource(if(pos.isFav) R.drawable.favorite else R.drawable.unfavorite)

        holder.favBtn.setOnClickListener {
            pos.isFav = !pos.isFav
            notifyDataSetChanged()
        }

        holder.layout.setOnClickListener {
            val iIntent = Intent(context, DetailScreen::class.java)
            iIntent.putExtra("data", pos)
            iIntent.putExtra("place",pos.place)
            iIntent.putExtra("country",pos.country)
            iIntent.putExtra("image",pos.image.toString())
            iIntent.putExtra("isFav",pos.isFav)

            context.startActivity(iIntent)

        }


    }

    override fun getItemCount(): Int {
        return tripList.size
    }

    class TripViewHolder(itemView: View) : ViewHolder(itemView){
        val layout : ConstraintLayout = itemView.findViewById(R.id.topTripLayout)
        val favBtn:ImageView = itemView.findViewById(R.id.favoriteBtn)
        val image:ImageView = itemView.findViewById(R.id.topTripImage)
        val country: TextView = itemView.findViewById(R.id.country)
        val place:TextView = itemView.findViewById(R.id.topTripPlaceName)

    }

}