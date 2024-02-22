package com.example.islamy.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamy.ui.suraDeatails.myConst
import com.example.islamy.databinding.FragmentHadethBinding
import com.example.islamy.ui.hadethDetails.HadethDetailsActivity
import com.example.islamy.ui.model.hadethContentInformation

class hadethFragment : Fragment(){
    lateinit var viewBinding : FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding  = FragmentHadethBinding.inflate(layoutInflater, container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }
    lateinit var hadethList :  MutableList<hadethContentInformation>
    lateinit var adapter: hadethAdapter
    private fun initViews() {
        initHadethList()
        adapter = hadethAdapter(hadethList)
        adapter.onItemClickListner = hadethAdapter.OnItemClickListner { title, content ->
            startHadethDetails(title,content)
        }
        viewBinding.hadethRecyclerView.adapter = adapter
    }
    private fun startHadethDetails(title: String, content: String) {
        val intent = Intent(activity,HadethDetailsActivity::class.java)
        intent.putExtra(myConst.HadethTitle,title)
        intent.putExtra(myConst.HadethContent,content)
        startActivity(intent)
    }
    private fun initHadethList() {
        hadethList = mutableListOf()
        val inputStream = context?.assets?.open("ahadeeth.txt")
        val hadethContent = inputStream?.bufferedReader().use {
            it?.readText()
        }
        val alhadeth = hadethContent?.trim()?.split("#")
        alhadeth?.forEach {hadeth->
            val lines = hadeth.trim().split("\n")
            val title = lines[0]
            val newList = lines.toMutableList().apply {
                removeAt(0)
            }
            val content = newList.joinToString("\n")
            val hadethData  = hadethContentInformation(title,content)
           hadethList.add(hadethData)
        }
    }
}