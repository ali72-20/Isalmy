package com.example.islamy.ui.home.hadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.fragment.app.Fragment
import com.example.islamy.Constants.myConst
import com.example.islamy.databinding.FragmentHadethBinding
import com.example.islamy.ui.hadethDetails.HadethDetailsActivity

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
    lateinit var hadethTitleList :  MutableList<String>
    lateinit var adapter: hadethAdapter
    private fun initViews() {
        initHadethList()
        adapter = hadethAdapter(hadethTitleList)
        adapter.onItemClickListner = hadethAdapter.OnItemClickListner { title, position ->
            startHadethDetails(title,position)
        }
        viewBinding.hadethRecyclerView.adapter = adapter
    }

    private fun startHadethDetails(title: String, position: Int) {
        val intent = Intent(activity,HadethDetailsActivity::class.java)
        intent.putExtra(myConst.HadethTitle,title)
        intent.putExtra(myConst.HadethIndex,position + 1)
        startActivity(intent)
    }

    private fun initHadethList() {
        hadethTitleList = mutableListOf()
        for(i in 1..50 step 1){
            hadethTitleList.add("الحديث رقم $i")
        }
    }
}