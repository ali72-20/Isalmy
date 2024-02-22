package com.example.islamy.ui.home.azkar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.islamy.databinding.FragementAzkarBinding

class AzkarFragment : Fragment() {
    lateinit var binding : FragementAzkarBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragementAzkarBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}