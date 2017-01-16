package com.example.jose.animationpractice;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final long UPDATE_DELAY_TIME_MS = 20;
    private Handler handler;
    private ArrayList<BouncingBall> viewsToUpdate = new ArrayList<>();
    private Random random;
    private int screenWidth;
    private int screenHeight;
    private FrameLayout ballContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ballContainerView = (FrameLayout) findViewById(R.id.ball_container_layout);
        random = new Random();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        screenHeight = displayMetrics.heightPixels;
        screenWidth = displayMetrics.widthPixels;
        handler = new Handler();
        updateBall().run();
    }

    private Runnable updateBall() {
        return () -> {
            for (BouncingBall b : viewsToUpdate) {
                b.invalidate();
            }
            handler.postDelayed(updateBall(), UPDATE_DELAY_TIME_MS);
        };
    }

    public void addBall(View view) {
        int randomXposition = random.nextInt(screenWidth - 30) + 30;
        int randomYposition = random.nextInt(ballContainerView.getHeight() - 30) + 30;
        Log.i("SCREEN HEIGHT", screenHeight+"");
        BouncingBall ball = new BouncingBall(this, randomXposition, randomYposition, 30,screenWidth-30,ballContainerView.getHeight()-30);
        ball.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
        ball.activateMovement(true);
        ballContainerView.addView(ball);
        viewsToUpdate.add(ball);
    }

    public void addThousandBalls(View view){
        for (int i = 0; i < 1000; i++) {
            int randomXposition = random.nextInt(screenWidth - 30) + 30;
            int randomYposition = random.nextInt(ballContainerView.getHeight() - 30) + 30;
            Log.i("SCREEN HEIGHT", screenHeight+"");
            BouncingBall ball = new BouncingBall(this, randomXposition, randomYposition, 30,screenWidth-30,ballContainerView.getHeight()-30);
            ball.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
            ball.activateMovement(true);
            ballContainerView.addView(ball);
            viewsToUpdate.add(ball);
        }
    }

    public void removeBall(View view) {
        if (viewsToUpdate.size() >= 1) {
            BouncingBall entry = viewsToUpdate.get(viewsToUpdate.size() - 1);
            ballContainerView.removeView(entry);
            viewsToUpdate.remove(entry);
        }
    }

    public void clearAllBalls(View view){
        if(viewsToUpdate.size()>=1){
            ballContainerView.removeAllViews();
            viewsToUpdate.clear();
        }
    }

}
