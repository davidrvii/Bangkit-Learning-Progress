package com.example.myfavnba

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class nbaPlayerAdapter (private val nbaPlayer: ArrayList<nbaPlayer>) : RecyclerView.Adapter<nbaPlayerAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnitemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.nba_players, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = nbaPlayer.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, tim, photo) = nbaPlayer[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvTim.text = tim
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(nbaPlayer[holder.adapterPosition]) }
    }

    class ListViewHolder (itemView: View) : RecyclerView.ViewHolder (itemView){
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvTim: TextView = itemView.findViewById(R.id.tv_tim)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: nbaPlayer)
    }
}