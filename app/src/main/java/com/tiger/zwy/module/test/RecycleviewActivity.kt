package com.tiger.zwy.module.test

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tiger.zwy.R
import com.tiger.zwy.adapter.RecycleviewAdapter
import com.tiger.zwy.utils.PopuUtil
import com.tiger.zwy.utils.ScreenShoot
import kotlinx.android.synthetic.main.recycleview_activity.*
import java.util.*

/**
 * 作者：Created by xuchao on 2018/8/20.
 * 描述：activity截图
 */
class RecycleviewActivity : AppCompatActivity() {
    private val icons: MutableList<Int> = ArrayList()
    private var mAdapter: RecycleviewAdapter? = null
    private var mRecyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycleview_activity)
        mRecyclerView = findViewById(R.id.recycle_view)
        for (i in 0..2) {
            icons.add(R.drawable.img1)
            icons.add(R.drawable.img2)
        }
        recycle_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        mAdapter = RecycleviewAdapter(icons, this)
        recycle_view.adapter = mAdapter
    }

    fun recycleviewOnClick(view: View?) {
        val bitmap = ScreenShoot.shotRecyclerView(recycle_view)
        PopuUtil.showPopu(this@RecycleviewActivity, ScreenShoot.compressBitmap(bitmap), view)
    }
}