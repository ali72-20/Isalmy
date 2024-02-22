package com.example.islamy.ui.hadethDetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.databinding.HadethContentBinding
import com.example.islamy.databinding.HadethTxtBinding
import com.example.islamy.ui.home.hadeth.hadethAdapter
import com.example.islamy.ui.model.hadethContentInformation

class hadethDetailsRecyclerView(private val list : List<String>) : RecyclerView.Adapter<hadethDetailsRecyclerView.myViewHolder>(){

    class myViewHolder(private val itemBining : HadethTxtBinding) : RecyclerView.ViewHolder(itemBining.root){
        fun bind(txt : String){
           itemBining.hadethContnet.text = txt
        }
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val txt = list[position]
        holder.bind(txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val viewBinding = HadethTxtBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return myViewHolder(viewBinding)
    }
    override fun getItemCount(): Int = list.size
}