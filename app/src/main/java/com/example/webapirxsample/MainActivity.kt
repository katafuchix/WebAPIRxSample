package com.example.webapirxsample

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.webapirxsample.view.ActressFragment
import com.example.webapirxsample.view.MainFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val main = MainFragment.createInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager.adapter = TabAdapter(supportFragmentManager,this)
        tab_layout.setupWithViewPager(pager)
    }
}

class TabAdapter(fm: FragmentManager, private val context: Context): FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> { return MainFragment.createInstance() }
            else ->  { return ActressFragment.createInstance() }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0 -> { return "作品検索" }
            else ->  { return "女優検索" }
        }
    }

    override fun getCount(): Int {
        return 2
    }
}