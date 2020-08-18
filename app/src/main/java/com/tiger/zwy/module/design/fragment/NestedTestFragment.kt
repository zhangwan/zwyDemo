package com.tiger.zwy.module.design.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tiger.zwy.R
import kotlinx.android.synthetic.main.fragment_1.*

class NestedTestFragment : Fragment() {
    var mRecyclerView: RecyclerView? = null

    companion object {
        fun getInstance(text: String): NestedTestFragment {
            val fragment = NestedTestFragment()
            val bundle = Bundle()
            bundle.putString("text", text)
            fragment.arguments = bundle
            return fragment
        }
    }

    var mText: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mText = arguments?.getString("text", "")
        var linearLayoutManager = LinearLayoutManager(context)
        mRecyclerView?.layoutManager = linearLayoutManager

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_1, container, false)
        mRecyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        return view
    }
}