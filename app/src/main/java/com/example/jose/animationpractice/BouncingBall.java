package com.example.jose.animationpractice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BouncingBall extends View {
    private Paint paint;
    private int xAxis;
    private int yAxis;
    private int radius;

    public BouncingBall(Context context) {
        super(context);
    }

    public BouncingBall(Context context,int x, int y, int radius){
        super(context);
        this.xAxis = x;
        this.yAxis = y;
        this.radius = radius;
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(xAxis,yAxis,radius,paint);
    }

    public BouncingBall(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public BouncingBall(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    public void moveBallRandomly(){

    }
}
