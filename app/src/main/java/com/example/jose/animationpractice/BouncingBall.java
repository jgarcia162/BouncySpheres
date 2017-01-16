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
    private int maximumX;
    private int maximumY;
    private int xSpeed;
    private int ySpeed;
    private boolean movementActivated;
    private boolean movingForward;
    private boolean movingDown;

    public BouncingBall(Context context) {
        super(context);
    }

    public BouncingBall(Context context, int x, int y, int radius, int maxX, int maxY) {
        super(context);
        xAxis = x;
        yAxis = y;
        this.radius = radius;
        maximumX = maxX;
        maximumY = maxY;
        xSpeed = 10;
        ySpeed = 10;
        movingForward = xAxis < maximumX;
        movingDown = yAxis < maximumY;
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(xAxis, yAxis, radius, paint);
        if (movementActivated) {
            moveBallRandomly();
        }
    }

    public BouncingBall(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();

    }

    public BouncingBall(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    public void moveBallRandomly() {
        xAxis += xSpeed;
        yAxis += ySpeed;

        if(xAxis >= maximumX)
            xSpeed = -xSpeed;
        else if(xAxis <= radius){
            xSpeed = -xSpeed;
        }
        if(yAxis >= maximumY)
            ySpeed = -ySpeed;
        else if(yAxis <= radius){
            ySpeed = -ySpeed;
        }
    }

    public void activateMovement(boolean activate) {
        movementActivated = activate;
    }
}
