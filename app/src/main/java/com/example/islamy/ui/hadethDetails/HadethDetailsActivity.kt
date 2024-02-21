package com.example.islamy.ui.hadethDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamy.Constants.myConst
import com.example.islamy.R
import com.example.islamy.databinding.ActivityHadethDetailsBinding

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var binding:ActivityHadethDetailsBinding
    var HadethIndex :Int = 0
    lateinit var  HadethTitle : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.hadethToolBar)
        HadethIndex = intent.getIntExtra(myConst.HadethIndex,0)
        HadethTitle = intent.getStringExtra(myConst.HadethTitle)?:""
        initVeiew()
    }

    private fun initVeiew() {
       binding.hadethTitle.text = HadethTitle
        title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}