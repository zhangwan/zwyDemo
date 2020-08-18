package com.tiger.zwy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager

import com.tiger.zwy.adapter.MainAdapter
import com.tiger.zwy.module.RxJavaTestActivity
import com.tiger.zwy.module.TestBannerActivity
import com.tiger.zwy.module.album.AlbumActivity
import com.tiger.zwy.module.comment.CommentActivity
import com.tiger.zwy.module.design.MediaDesignActivity
import com.tiger.zwy.module.download.DownloadActivity
import com.tiger.zwy.module.test.*

import kotlinx.android.synthetic.main.fragment_main.*


class MainFragment : Fragment() {
    companion object {
        fun getInstance(): Fragment {
            val fragment = MainFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }
    var strList: Array<String>? = null
    private val mAdapter by lazy { MainAdapter(context!!, arrayListOf()) }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_main, container, false)
        return view
    }


    fun initView() {
        strList = resources.getStringArray(R.array.page_list)
        recycler_view?.layoutManager = LinearLayoutManager(context)
        recycler_view?.adapter = mAdapter
        mAdapter.data = strList!!.toMutableList()
        mAdapter?.notifyDataSetChanged()
        initListener()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    private fun initListener(){
        mAdapter?.itemListener={
            var gotoAct: Intent
            when (it) {
                0 -> {
                    gotoAct = Intent(activity!!, CommentActivity::class.java)
                    startActivity(gotoAct)
                }
                1 -> {
                    gotoAct = Intent(activity!!, TestChartActivity::class.java)
                    startActivity(gotoAct)
                }
                2 -> {
                    gotoAct = Intent(activity!!, LineChartActivity::class.java)
                    startActivity(gotoAct)
                }
                3 -> {
                    gotoAct = Intent(activity!!, SeekBarActivity::class.java)
                    startActivity(gotoAct)
                }
                4 -> {
                    gotoAct = Intent(activity!!, RecycleviewActivity::class.java)
                    startActivity(gotoAct)
                }
                5 -> {
                    gotoAct = Intent(activity!!, TestBannerActivity::class.java)
                    startActivity(gotoAct)
                }
                6 -> {
                    gotoAct = Intent(activity!!, MediaDesignActivity::class.java)
                    startActivity(gotoAct)
                }
                7 -> {
                    gotoAct = Intent(activity!!, RxJavaTestActivity::class.java)
                    startActivity(gotoAct)
                }
                8 -> {
                    gotoAct = Intent(activity!!, TestDeviceActivity::class.java)
                    startActivity(gotoAct)
                }
                9 -> {
                    gotoAct = Intent(activity!!, AlbumActivity::class.java)
                    startActivity(gotoAct)
                }
                10->{
                    gotoAct=Intent(activity!!, DownloadActivity::class.java)
                    startActivity(gotoAct)
                }
            }
        }
    }
}