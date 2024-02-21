package com.example.islamy.ui.suraDeatails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.databinding.SuraVerseBinding

class suraVerseRecycleView(private val versesList: List<String>) : RecyclerView.Adapter<suraVerseRecycleView.myViewHolder>() {
    class myViewHolder(private val itemBinding : SuraVerseBinding) :
        RecyclerView.ViewHolder(itemBinding.root){
            fun bind(verse:String){
                itemBinding.suraVerse.text = verse
            }
    }

    override fun getItemCount(): Int = versesList.size

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val verse = versesList[position]
        holder.bind(verse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val viewBinding = SuraVerseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return myViewHolder(viewBinding)
    }
}