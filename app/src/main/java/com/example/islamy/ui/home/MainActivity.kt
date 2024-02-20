package com.example.islamy.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.islamy.R
import com.example.islamy.databinding.ActivityMainBinding
import com.example.islamy.databinding.FragmentRadioBinding
import com.example.islamy.ui.home.hadeth.hadethFragment
import com.example.islamy.ui.home.quran.quranFragment
import com.example.islamy.ui.home.radio.radioFragment
import com.example.islamy.ui.home.sebha.sebhaFragment
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initViews()
    }

    private fun initViews() {
        viewBinding.content
            .bottomNavBar
            .setOnItemSelectedListener { item ->
                val currentFragment : Fragment = when (item.itemId) {
                    R.id.nav_quran -> {
                        quranFragment()
                    }

                    R.id.nav_hadeth -> {
                        hadethFragment()
                    }

                    R.id.nav_sebha -> {
                        sebhaFragment()
                    }

                    R.id.nav_radio -> {
                        radioFragment()
                    }

                    else -> {
                        quranFragment()
                    }
                }
                pushFragment(currentFragment)
                true
            }
        viewBinding.content.bottomNavBar
            .selectedItemId = R.id.nav_quran
    }
    private fun pushFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container,fragment)
            .commit()

    }
}


