package com.example.restaurantslistyelp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.restaurantslistyelp.R
import com.example.restaurantslistyelp.data.Business
import com.squareup.picasso.Picasso

class Restaurants_list_Adapter(data: ArrayList<Business>) : RecyclerView.Adapter<Restaurants_list_Adapter.HomeViewHolder>(){

    private var data = data

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.restaurant_list_item, parent, false))
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = data?.get(position)
        Log.i("HomeViewHolder",""+item)
        holder.bindView(item)
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(item: Business?) {

            val rest_name = itemView.findViewById<TextView>(R.id.tv_rest_name)
            val rest_iv = itemView.findViewById<ImageView>(R.id.iv_rest_pic)
            val rest_ratings = itemView.findViewById<TextView>(R.id.tv_ratings)
            val rest_cost = itemView.findViewById<TextView>(R.id.costly)
            val rest_phone = itemView.findViewById<TextView>(R.id.rest_phone)
            val rest_loc = itemView.findViewById<TextView>(R.id.rest_location)
            val rest_open = itemView.findViewById<TextView>(R.id.is_open)

            if (item != null) {
                Picasso.get().load(item.image_url).into(rest_iv)
                val open = if (!item.is_closed) "Open" else "Closed"
                val location = (item.location!!.display_address).toString().replace("[","").replace("]","")
                Log.i("Add",""+location);
                rest_name.setText(item.name)
                rest_ratings.setText(item.rating.toString()+" ("+item.review_count+")")
                rest_cost.setText(item.price)
                rest_phone.setText(item.phone)
                rest_loc.setText(location.toString())
                rest_open.setText(open)
            }
        }

    }

}