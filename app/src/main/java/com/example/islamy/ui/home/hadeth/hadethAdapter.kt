package com.example.islamy.ui.home.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamy.databinding.HadethTitleBinding
import com.example.islamy.ui.model.hadethContentInformation

class hadethAdapter(private val hadethList : List<hadethContentInformation>) : RecyclerView.Adapter<hadethAdapter.myViewHolder>(){

    var onItemClickListner : OnItemClickListner?=null
    fun interface OnItemClickListner{
        fun onItemClick(title:String, content: String)
    }
    class myViewHolder(private val itemBinding : HadethTitleBinding) : RecyclerView.ViewHolder(itemBinding.root){
        fun bind(hadethTitle : String){
            itemBinding.hadethTitle.text = hadethTitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val viewBinding = HadethTitleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return myViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = hadethList.size

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val title = hadethList[position].title
        val content = hadethList[position].content
        holder.bind(title)
        onItemClickListner?.let {listner->
            holder.itemView.setOnClickListener {
                listner.onItemClick(title,content)
            }
        }
    }
}