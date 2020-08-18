package com.tiger.zwy.adapter


import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tiger.zwy.R
import kotlinx.android.synthetic.main.item_main.view.*
import java.lang.reflect.Array

class MainAdapter(private  val  context: Context,var data:MutableList<String>) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    var itemListener:((position:Int)->Unit)?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MainViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main,parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        with(holder.itemView){
            tv_name.text = data[position]
            tv_name.setOnClickListener {
                itemListener?.invoke(position)
            }
        }
    }
    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view)

}