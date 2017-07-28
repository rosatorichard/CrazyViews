package com.batchmates.android.crazyviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Android on 7/27/2017.
 */

public class CustomLayout extends LinearLayout {

    private boolean funTime=true;
    private boolean sempai=true;
    private Animation animation;

    public CustomLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.CustomLayout);
        funTime=typedArray.getBoolean(R.styleable.CustomLayout_funTime,true);
        sempai=typedArray.getBoolean(R.styleable.CustomLayout_sempai,true);

        if(funTime==true)
        {
            startFunAnimation();

        }
        if(sempai==true)
        {
            noticeMe();
        }

    }

    private void noticeMe() {
        setBackgroundResource(R.drawable.embarassed);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(this.getContext(), "Gigle dont touch my button", Toast.LENGTH_SHORT).show();
        Log.d("TOUCH", "Touched View");
        return false;
    }

    private void startFunAnimation()
    {
        animation=new RotateAnimation(0,60);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(1000);
        animation.setRepeatMode(Animation.REVERSE);
        startAnimation(animation);
    }

    public boolean isFunTime() {
        return funTime;
    }

    public void setFunTime(boolean funTime) {
        this.funTime = funTime;
        if (funTime==false && animation!=null)
        {
            animation.cancel();
        }
        else
        {
            startFunAnimation();
        }
    }

    public boolean isSempai() {
        return sempai;
    }

    public void setSempai(boolean sempai) {
        this.sempai = sempai;
        if (sempai==false)
        {
            setBackgroundColor(Color.WHITE);
        }
        else
        {
            noticeMe();
        }
    }
}
