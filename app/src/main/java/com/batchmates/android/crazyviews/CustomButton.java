package com.batchmates.android.crazyviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Android on 7/27/2017.
 */

public class CustomButton extends Button {

    private boolean moving=true;
    private boolean mocking=true;
    private Animation animation;
    Context view;
    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        view=context;
        TypedArray typedArray=context.obtainStyledAttributes(R.styleable.CustomButton);
        moving=typedArray.getBoolean(R.styleable.CustomButton_moving,true);


        if(moving==true)
        {
            animation=new TranslateAnimation(0,1000,0,0);
            animation.setDuration(1000);
            animation.setRepeatMode(Animation.REVERSE);
            animation.setRepeatCount(Animation.INFINITE);
            startAnimation(animation);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(view, "EEEEEEEEEE FINGER!", Toast.LENGTH_SHORT).show();
        return super.onTouchEvent(event);
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

}
