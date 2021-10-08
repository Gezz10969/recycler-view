package com.example.recyclerviewkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.gessel.knowyourlanguage.Language
import com.bangkit.gessel.knowyourlanguage.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridLanguageAdapter(val listLanguage: ArrayList<Language>) : RecyclerView.Adapter<GridLanguageAdapter.GridViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(vG: ViewGroup, p1: Int): GridViewHolder {
        val view: View = LayoutInflater.from(vG.context).inflate(R.layout.item_grid_kyl, vG, false)
        return GridViewHolder(view)
    }
    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listLanguage[position].photo)
            .apply(RequestOptions().override(550, 750))
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listLanguage[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listLanguage.size
    }

    inner class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Language)
    }
}