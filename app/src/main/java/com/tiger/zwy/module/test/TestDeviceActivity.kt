package com.tiger.zwy.module.test

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.tiger.zwy.R
import com.tiger.zwy.utils.TestUtils

class TestDeviceActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rxjava_test)
        val deviceId = TestUtils.getDeviceId(this)
        val mac = TestUtils.getMacAddress()
        val model = Build.MODEL
        val carrier = Build.MANUFACTURER


        Log.i("i====", "deviceId:$deviceId")
        Log.i("i====", "mac:$mac")
        Log.i("i====", "model:$model")
        Log.i("i====", "carrier:$carrier")
    }
}