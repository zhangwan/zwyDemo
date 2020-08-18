package com.tiger.zwy.module.design.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;

public class NestedScrollingParentLayout extends LinearLayout implements NestedScrollingParent {
    private int mTopViewHeight;
    private ValueAnimator mValueAnimator;
    private NestedScrollingParentHelper mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);


    public NestedScrollingParentLayout(Context context) {
        this(context, null);
    }

    public NestedScrollingParentLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NestedScrollingParentLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int axes) {
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int axes) {
        mNestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes);
    }

    /**
     * 再嵌套滑动的子View未滑动之前，判断父View是否优先与子View处理（也就是父View可以先消耗，然后在给子View消耗）
     *
     * @param target   具体嵌套滑动的那个子类
     * @param dx       水平方向嵌套华东的子view想要变化的距离
     * @param dy       垂直方向嵌套滑动的子View想要变化的距离 dy<0向下滑动 dy>0向上滑动
     * @param consumed 这个参数要我们在实现这个函数的时候指定，回头告诉子View当前父View消耗的距离
     *                 consumes[0] 水平消耗的距离，consumed[1] 垂直消耗的距离，好让子View做出相应的调整
     */
    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(target, dx, dy, consumed);
        boolean hideTop = dy > 0 && getScaleY() < mTopViewHeight;
        boolean showTop = dy < 0 && getScaleY() >= 0 && !target.canScrollVertically(-1);
        if (hideTop || showTop) {
            scrollBy(0, dy);
            consumed[1] = dy;
        }
    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override
    public void onStopNestedScroll(View child) {
        mNestedScrollingParentHelper.onStopNestedScroll(child);
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        final int distance = Math.abs(getScrollY());
        final int duration;
        if (velocityY > 0) {//向上滑动
            duration = 3 * Math.round(1000 * (distance / velocityY));
            startAnimation(duration, getScrollY(), mTopViewHeight);
        } else if (velocityY < 0) {//向下滑动
            final float distanceRatio = (float) distance / getHeight();
            duration = (int) ((distanceRatio + 1) * 150);
            startAnimation(duration, getScrollY(), 0);
        }
        return true;
    }

    @Override
    public int getNestedScrollAxes() {
        return mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mTopViewHeight=getChildAt(0).getMeasuredHeight();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        ViewGroup.LayoutParams layoutParams=getChildAt(2).getLayoutParams();
        layoutParams.height=getMeasuredHeight()-getChildAt(1).getMeasuredHeight();
        getChildAt(2).setLayoutParams(layoutParams);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void scrollTo(int x, int y) {
        if(y<0){
            y=0;
        }
        if(y>mTopViewHeight){
            y=mTopViewHeight;
        }

        super.scrollTo(x, y);

    }

    private void startAnimation(int duration, int startY, int endY) {
           if(mValueAnimator==null){
               mValueAnimator=new ValueAnimator();
               mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                   @Override
                   public void onAnimationUpdate(ValueAnimator animation) {
                       int animatedValue= (int) animation.getAnimatedValue();
                       scrollTo(0,animatedValue);
                   }
               });
           }else {
               mValueAnimator.cancel();
           }
           mValueAnimator.setInterpolator(new DecelerateInterpolator());
           mValueAnimator.setIntValues(startY,endY);
           mValueAnimator.setDuration(duration);
           mValueAnimator.start();
    }
}
