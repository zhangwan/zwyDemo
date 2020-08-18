package com.tiger.zwy.module.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.tiger.zwy.R
import com.tiger.zwy.base.BaseActivity
import com.tiger.zwy.bean.SalesStatisticsBean
import com.tiger.zwy.module.test.view.StatisticsChartUtil
import kotlinx.android.synthetic.main.activity_line_chart.*

/**
 * @author zwy
 * create at 2020/7/20 0020
 * description:
 */
class TestChartActivity :AppCompatActivity(){
    var data= arrayListOf<SalesStatisticsBean>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_line_chart)
        loadSalesStatisticsData()
        StatisticsChartUtil.setLineCharConfig(lineChart, this, 1)

    }

    fun loadSalesStatisticsData() {
        var bean:SalesStatisticsBean?=null
        for (i in 0..4){
            bean=SalesStatisticsBean()
            bean.timeLabel="2020-7-2${i}"
            var k=10+i*3
            if(i%2==1){
                 k=25
            }

            bean.totalAmt=k.toDouble()
            data.add(bean)
        }
        setLineChartData(data)

    }
    /**
     * 折线图数据填充
     */
    private fun setLineChartData(data: ArrayList<SalesStatisticsBean>) {
        data ?: return
        val dataSets = ArrayList<ILineDataSet>()
        val totalAmts = ArrayList<Entry>()
        val valueFormatter = ArrayList<String>()

        for (i in 0 until data.size) {
            var bean = data[i]
            totalAmts.add(Entry(i.toFloat(), bean.totalAmt?.toFloat() ?: 0f))
            var times = bean.timeLabel?.split("-") ?: arrayListOf()
            valueFormatter.add("${times[1]}.${times[2]}")

        }

        var values = arrayListOf(totalAmts)
        var labels = arrayListOf("")
        var colors = arrayListOf(R.color.yellow)
        for (i in 0 until values.size) {
            // create a dataset and give it a type
            val lineDataSet = LineDataSet(values[i], labels[i])
            // 设置曲线颜色
            lineDataSet.color = ContextCompat.getColor(this, colors[i])
            // 设置平滑曲线
            lineDataSet.mode = LineDataSet.Mode.HORIZONTAL_BEZIER
            lineDataSet.setDrawCircles(false)
            // 不显示坐标点的小圆点

            // 不显示坐标点的数据
            lineDataSet.setDrawValues(false)
            // 不显示定位线
            lineDataSet.isHighlightEnabled = true

            lineDataSet.setCircleColor(ContextCompat.getColor(this, R.color.yellow))
            lineDataSet.lineWidth = 1f
            lineDataSet.circleRadius = 3f
            lineDataSet.setDrawCircleHole(false)

            lineDataSet.valueTextSize = 10f
            dataSets.add(lineDataSet)
        }
        val data = LineData(dataSets)
        lineChart.data = data
        //绘制标签  指x轴上的对应数值

        lineChart.xAxis.valueFormatter = IndexAxisValueFormatter(valueFormatter)
        lineChart.xAxis.setDrawLabels(true)
        lineChart.invalidate()
    }
}