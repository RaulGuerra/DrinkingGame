package com.cs4750.android.truthordrink;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class SpinBottle extends AppCompatActivity {

    Button b_spin;
    ImageView iv_bottle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spin_bottle);

        b_spin = (Button) findViewById(R.id.b_spin);
        iv_bottle = (ImageView) findViewById(R.id.iv_bottle);

        b_spin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int spinDegrees;
                Random r = new Random();
                spinDegrees = r.nextInt(3600);
                RotateAnimation rotateBottle = new RotateAnimation(0, spinDegrees,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);

                rotateBottle.setDuration(2000);
                rotateBottle.setFillAfter(true);
                rotateBottle.setInterpolator(new AccelerateDecelerateInterpolator());

                iv_bottle.startAnimation(rotateBottle);

            }
        });
    }
}