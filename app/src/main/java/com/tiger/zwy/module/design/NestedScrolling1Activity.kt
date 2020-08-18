package com.tiger.zwy.module.design

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.tiger.zwy.R
import com.tiger.zwy.module.design.adapter.MyFragmentAdapter
import com.tiger.zwy.module.design.fragment.NestedTestFragment
import kotlinx.android.synthetic.main.activity_nested_scrolling1.*

class NestedScrolling1Activity :AppCompatActivity(){
    var fragmentList= arrayListOf<Fragment>()
    var titles= arrayListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_scrolling1)
        view_pager.orientation=ViewPager2.ORIENTATION_HORIZONTAL
        initData()

    }
    fun initData(){
        for (i in 0 until  4){
            fragmentList.add(NestedTestFragment.getInstance("NestedScrolling机制1"))
        }
        titles.add("首页")
        titles.add("商品")
        titles.add("个人")
        titles.add("关于")

        var mFragmentAdapter= MyFragmentAdapter(this,fragmentList)
        view_pager.adapter=mFragmentAdapter

        TabLayoutMediator(tab,view_pager,TabLayoutMediator.TabConfigurationStrategy{tab, position ->
            tab.text = titles[position]
        }).attach()
    }
}