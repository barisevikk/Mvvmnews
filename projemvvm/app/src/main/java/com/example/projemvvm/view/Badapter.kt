package com.example.firestoremvvm.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firestoremvvm.data.Anasayfamodell
import com.example.projemvvm.R


import com.example.projemvvm.databinding.BicardtasarimBinding


class Badapter(var context: Context,var barraylist: List<Anasayfamodell>):RecyclerView.Adapter<Badapter.cardtemsili>() {

    inner class cardtemsili(binding: BicardtasarimBinding):RecyclerView.ViewHolder(binding.root){
        var binding:BicardtasarimBinding
        init {
            this.binding=binding

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardtemsili {
        var inflaterr=LayoutInflater.from(context)
        var binding:BicardtasarimBinding=DataBindingUtil.inflate(inflaterr, R.layout.bicardtasarim, parent,false)
        return cardtemsili(binding)
    }

    override fun onBindViewHolder(holder: cardtemsili, position: Int) {
        var tasarim=barraylist[position]
        holder.binding.baslik.text=tasarim.baslik
        Glide.with(context).load(barraylist[position].image).into(holder.binding.imageView)
        holder.binding.icerik.text=tasarim.icerik
       // Picasso.get().load(postList[position].downloadUrl).into(holder.binding.recyclerImageView)


    }

    override fun getItemCount(): Int {
        return barraylist.size
    }
}