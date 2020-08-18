package com.tiger.zwy


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState!=null){
            return
        }
        val fragmentManager = supportFragmentManager;
        val transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.frameLayout, MainFragment.getInstance(),  MainFragment::class.java.name)
        transaction.commit()
    }

}