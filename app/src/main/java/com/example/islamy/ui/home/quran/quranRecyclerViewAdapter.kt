package com.example.islamy.ui.home.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamy.databinding.ItemChaperTitleBinding
import java.util.StringTokenizer

class quranRecyclerViewAdapter(val chapterList:List<String>) :
    RecyclerView.Adapter<quranRecyclerViewAdapter.myViewHolder>() {

        var onItemClickListner : OnItemClickListner? = null
        fun interface OnItemClickListner{
            fun onItemClick(item:String, position: Int)
        }
        class myViewHolder(private val itemBinind:ItemChaperTitleBinding) : RecyclerView.ViewHolder(
            itemBinind.root
        ){
            fun bind(title:String){
                itemBinind.suraTitle.text = title
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val viewBinding :ItemChaperTitleBinding = ItemChaperTitleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return myViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = chapterList.size

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val title : String = chapterList[position]
        holder.bind(title)
        onItemClickListner?.let {listner->
            holder.itemView.setOnClickListener {
               listner.onItemClick(title, position)
            }
        }
    }


}