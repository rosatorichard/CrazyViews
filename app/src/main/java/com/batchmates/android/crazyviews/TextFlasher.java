package com.batchmates.android.crazyviews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.widget.TextView;

/**
 * Created by Android on 7/27/2017.
 */

public class TextFlasher extends TextView {

    boolean fade=false;
    private Animation animation;
    private int duration=1000;

    public TextFlasher(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.TextFlasher);
        fade=typedArray.getBoolean(R.styleable.TextFlasher_fade,false);
        duration=typedArray.getInt(R.styleable.TextFlasher_duration,1000);

        if(fade==true)
        {
            animation=new AlphaAnimation(1,0);
        }
        else {
            animation = new AlphaAnimation(0, 1);
        }
        animation.setDuration(duration);
        animation.setRepeatCount(Animation.INFINITE);
        startAnimation(animation);
    }

    public boolean isFade() {
        return fade;
    }

    public void setFade(boolean fade) {
        this.fade = fade;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

//    private int borderWidthLeft = dp(4);
//
//    private int borderWidthRight = dp(4);
//
//    private int borderWidthTop = dp(4);
//
//    private int borderWidthBottom = dp(4);
//
//    private int boderColor = Color.BLACK;
//
//    private int backgroundColor = Color.BLUE;
//
//    private int textColor = Color.WHITE;
//
//    private int textSize = sp(30);
//
//    private Paint backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
//
//    private Paint textPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
//
//    private int backgroundRectWidth = dp(35);
//
//    private int backgroundRectHeight = dp(35);
//
//    private Rect textBgRect = new Rect();
//
//    private String defaultText = "A";
//
//
//    public TextFlasher(Context context) {
//        this(context, null);
//    }
//
//    public TextFlasher(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        init(context);
//        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.AppCompatTextView);
//
//    }
//
//    private void init(Context context) {
//        backgroundPaint.setColor(backgroundColor);
//        textPaint.setColor(textColor);
//        textPaint.setTextAlign(Paint.Align.CENTER);
//        textPaint.setTextSize(textSize);
//        textPaint.setFakeBoldText(true);
//    }
//
//
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        setMeasuredDimension(backgroundRectWidth + borderWidthLeft + borderWidthRight,
//                backgroundRectHeight + borderWidthTop + borderWidthBottom);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        drawBackground(canvas);
//        drawText(canvas);
//    }
//
//    private void drawBackground(Canvas canvas) {
//        canvas.drawColor(boderColor);
//        int left =  borderWidthLeft;
//        int top =  borderWidthTop;
//        int right = borderWidthLeft + backgroundRectWidth;
//        int bottom = borderWidthTop + backgroundRectHeight;
//        textBgRect.set(left, top, right, bottom);
//        canvas.save();
//        canvas.clipRect(textBgRect, Region.Op.REPLACE);
//        canvas.drawRect(textBgRect, backgroundPaint);
//        canvas.restore();
//    }
//
//
//    private void drawText(Canvas canvas) {
//        int bgCenterX = borderWidthLeft + backgroundRectWidth / 2;
//        int bgCenterY = borderWidthTop + backgroundRectHeight / 2;
//        Paint.FontMetrics metric = textPaint.getFontMetrics();
//        int textHeight = (int) Math.ceil(metric.descent - metric.ascent);
//        int x = bgCenterX;
//        int y = (int) (bgCenterY + textHeight / 2 - metric.descent);
//        System.out.println(textHeight);
//        System.out.println(y);
//        System.out.println(bgCenterY);
//        canvas.drawText(defaultText, x, y, textPaint);
//    }
//
//    private int dp(int value) {
//        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
//    }
//
//    private int sp(int value) {
//        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, getResources().getDisplayMetrics());
//    }
}
