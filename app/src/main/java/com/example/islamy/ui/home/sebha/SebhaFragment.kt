package com.example.islamy.ui.home.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamy.R
import com.example.islamy.databinding.FragmentSebhaBinding

class sebhaFragment : Fragment() {
    lateinit var viewBinding : FragmentSebhaBinding
    var counter : Int = 0
    var currentZekrindex :Int = 0
   lateinit var azkarList:MutableList<String>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentSebhaBinding.inflate(layoutInflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        onSebhaClick()
    }

    private fun onSebhaClick() {
        viewBinding.sebhaBodyImgV.setOnClickListener{
            viewBinding.sebhaBodyImgV.rotation += (360/33).toFloat() // float in kotlin
            if(counter < 33){
                counter++
            }else{
                counter = 0
                currentZekrindex = if(currentZekrindex  < azkarList.size - 1) ++currentZekrindex else 0
                viewBinding.zeker.text = azkarList[currentZekrindex]
            }
            viewBinding.counter.text = counter.toString()
        }
    }
}