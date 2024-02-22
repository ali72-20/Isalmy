package com.example.islamy.ui.hadethDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamy.ui.suraDeatails.myConst
import com.example.islamy.databinding.ActivityHadethDetailsBinding

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var binding:ActivityHadethDetailsBinding
    var HadethIndex :Int = 0
    lateinit var  HadethTitle : String
    lateinit var  HadethContent : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.hadethToolBar)
        HadethTitle = intent.getStringExtra(myConst.HadethTitle)?:""
        HadethContent = intent.getStringExtra(myConst.HadethContent)?:""
        initVeiew()
    }

    private fun initVeiew() {
        binding.hadethTitle.text = HadethTitle
        binding.hadethContnet.hadethContentScroll.text = HadethContent
        title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}