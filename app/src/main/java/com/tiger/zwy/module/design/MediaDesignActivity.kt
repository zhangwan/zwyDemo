package com.tiger.zwy.module.design

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tiger.zwy.R
import com.tiger.zwy.module.design.fragment.MediaDesignFragment

class MediaDesignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_design)
        if (savedInstanceState != null) {
            return
        }
        var fragmentManager = supportFragmentManager
        var transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, MediaDesignFragment.getInstance(), MediaDesignFragment::class.java.name)
        transaction.commit()

    }
}