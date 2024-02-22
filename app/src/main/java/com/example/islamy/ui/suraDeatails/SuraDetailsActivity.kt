package com.example.islamy.ui.suraDeatails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamy.databinding.ActivitySuraDetailsBinding

class SuraDetailsActivity : AppCompatActivity() {
    private var chapterIndex:Int = 0
    private lateinit var chapterTitle:String
    private lateinit var binding : ActivitySuraDetailsBinding
    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.surToolBar)
        chapterIndex = intent.getIntExtra(myConst.ChapterIndex,0)
        chapterTitle = intent.getStringExtra(myConst.ChapterTitle)?:""
        initView()
        readSuraFile()
    }

    private fun readSuraFile() {
        val inputStream = assets.open("$chapterIndex.txt")
        val suraContent =  inputStream.bufferedReader().use {
            it.readText()
        }
        val lines = suraContent.trim().split("\n")
        initRecyclerView(lines)
    }
    private lateinit var adapter : suraVerseRecycleView
    private fun initRecyclerView(lines: List<String>) {
        adapter = suraVerseRecycleView(lines)
        binding.contentChapter.sureVerseRec.adapter = adapter
    }

    private fun initView() {
        binding.suraTitle.text = chapterTitle
        title = null
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}