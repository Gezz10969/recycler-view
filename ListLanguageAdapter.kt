package com.bangkit.gessel.knowyourlanguage

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListLanguageAdapter(private val listLanguage: ArrayList<Language>) : RecyclerView.Adapter<ListLanguageAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(vG: ViewGroup, p1: Int): ListViewHolder {
        val view: View = LayoutInflater.from(vG.context).inflate(R.layout.item_list_kyl, vG, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val lang = listLanguage[position]
        Glide.with(holder.itemView.context)
            .load(lang.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.lvName.text = lang.name
        holder.lvDeveloper.text = lang.developer

        if(position % 2 == 0)
        {
            holder.itemView.setBackgroundResource(R.color.white);
        }
        else
        {
            holder.itemView.setBackgroundResource(R.color.odd);
        }

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listLanguage[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listLanguage.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var lvName: TextView = itemView.findViewById(R.id.lang_name)
        var lvDeveloper: TextView = itemView.findViewById(R.id.lang_developer)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Language)
    }
}