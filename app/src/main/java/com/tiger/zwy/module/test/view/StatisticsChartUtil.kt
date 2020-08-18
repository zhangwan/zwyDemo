package com.tiger.zwy.module.test.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.tiger.zwy.R


/**
 * Created By HuiT
 * On 2019/6/21
 */
object StatisticsChartUtil {
    /**type 1  销售统计，2 昨日用户统计，3总览统计*/
    fun setLineCharConfig(lineChart: LineChart, activity: AppCompatActivity, type: Int) {

        lineChart.setDrawGridBackground(false)
        lineChart.setTouchEnabled(true)
        lineChart.isDragYEnabled = false
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        lineChart.xAxis.textColor = ContextCompat.getColor(activity, R.color.color_333333)
        lineChart.xAxis.textSize = 12f
        lineChart.xAxis.valueFormatter = IndexAxisValueFormatter()
        lineChart.axisLeft.setDrawAxisLine(false)
        lineChart.axisRight.setDrawAxisLine(false)
        lineChart.setScaleEnabled(false)
        lineChart.isDragYEnabled = false
        lineChart.setNoDataText(activity.getString(R.string.txt_no_data))//无数据的时显示的文字
        lineChart.xAxis.setAvoidFirstLastClipping(true)

        //去掉纵向网格线和顶部边线：
        lineChart.xAxis.setDrawAxisLine(true)
        lineChart.axisLeft.setDrawGridLines(false)
        lineChart.axisLeft.isEnabled = false
        lineChart.axisRight.setDrawGridLines(false)
        lineChart.axisRight.isEnabled = false
        lineChart.xAxis.gridColor = ContextCompat.getColor(activity, R.color.color_F5F5F5)
        var description = Description()
        description.text = ""
        lineChart.description = description

        lineChart.setPinchZoom(false)

        lineChart.setDrawMarkers(true)
        var markerView = LineChartMarkerView(activity)
        markerView.type = type
        markerView.chartView = lineChart
        lineChart.marker = markerView

        lineChart.setBackgroundColor(Color.WHITE)
        lineChart.legend.isEnabled = false
    }
}