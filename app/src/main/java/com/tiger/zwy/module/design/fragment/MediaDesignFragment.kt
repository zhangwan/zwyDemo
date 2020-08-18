package com.tiger.zwy.module.design.fragment

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.ListFragment
import com.tiger.zwy.module.design.NestedScrolling1Activity

class MediaDesignFragment : ListFragment() {
    companion object {
        fun getInstance(): MediaDesignFragment {
            val fragment = MediaDesignFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    var arrayList = arrayOf("ToolBar",
            "FloatActionButton与Snackbar",
            "MaterialButtonActivity",
            "DrawLayout与NaviagtionView",
            "TextInputActivity",
            "CardView",
            "TabLayout",
            "CoordinatorLayout",
            "Translucent",
            "BottomSheets",
            "ViewPager2Activity",
            "BottomAppBarActivity",
            "ChipsActivity",
            "ZActivity",
            "NestScrollActivity",
            "NestedTraditionActivity",
            "NestedScrolling1Activity",
            "NestedScrollViewActivity"
    )
    var arrayAdapter: ArrayAdapter<String>? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arrayAdapter = ArrayAdapter(activity!!, android.R.layout.simple_list_item_1, arrayList)
        listAdapter = arrayAdapter
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        var item=arrayAdapter?.getItem(position)
        Toast.makeText(activity!!,item,Toast.LENGTH_LONG).show()
        var gotoAct:Intent?=null;
        when(position){
            0->{

            }
            1->{

            }
            2->{

            }
            16->{
                gotoAct=Intent(activity!!,NestedScrolling1Activity::class.java)
                startActivity(gotoAct)
            }
        }
    }
}