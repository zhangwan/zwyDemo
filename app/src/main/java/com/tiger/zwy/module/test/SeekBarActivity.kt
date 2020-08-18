package com.tiger.zwy.module.test

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.tiger.zwy.R
import kotlinx.android.synthetic.main.activity_seekbar.*

/**
 * @author zwy
 * create at 2020/7/22 0022
 * description:
 */
class SeekBarActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seekbar)
        activity_loan_seek.progress = 1000
        tv_.setText("1000")
        activity_loan_seek.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                 tv_.setText(progress.toString())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })

    }
}