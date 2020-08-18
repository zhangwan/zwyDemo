package com.tiger.zwy.module.test.view;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.tiger.zwy.R;


import java.math.BigDecimal;

/**
 * Created By HuiT
 * On 2019/6/24
 */
public class LineChartMarkerView extends MarkerView {

    private TextView mTvMonth;
    private TextView mTvChart1;
    public String valueUnit = "";
    public String positionUnit = "";
    public int newScale = 2;
    /**
     * type 1销售统计，2 昨日用户统计，3总览用户统计
     */
    public int type = 0;

    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     *
     * @param context
     */
    public LineChartMarkerView(Context context) {
        super(context, R.layout.item_chart_des_marker_item_3);
        mTvMonth = findViewById(R.id.tv_chart_month);
        mTvChart1 = findViewById(R.id.tv_chart_1);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        super.refreshContent(e, highlight);
        IDataSet entry = getChartView().getData().getDataSetByIndex(highlight.getDataSetIndex());
        ValueFormatter formatter = getChartView().getXAxis().getValueFormatter();
        String value = formatter.getFormattedValue(e.getX());


        valueUnit ="%";
        positionUnit ="天";
        mTvChart1.setText(concat(e.getY(), valueUnit, newScale));

        value = value + positionUnit;
        mTvMonth.setText(value);
    }


    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }


    public String concat(float money, String values, int newScale) {
        return new BigDecimal(money).setScale(newScale, BigDecimal.ROUND_HALF_UP).toPlainString() + values;
    }

}
