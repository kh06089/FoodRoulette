package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class RouletteActivity extends AppCompatActivity {
    int degree_old = 0, degree = 0;
    Random random;
    ImageView wheel;
    ArrayList<String> names;
    TextView restaurantView;
    String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        names = bundle.getStringArrayList("selected");

        wheel = findViewById(R.id.wheelView);
        Button btnStart = findViewById(R.id.btnStart);
        restaurantView = findViewById(R.id.restaurantView);
        restaurantView.setText("");

        random = new Random();
        btnStart.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                degree_old = degree % 360;
                degree = random.nextInt(36000) + 720;
                selected = names.get(random.nextInt(names.size()-1));
                RotateAnimation rotate = new RotateAnimation(degree_old, degree,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);

                rotate.setDuration(3600);
                rotate.setFillAfter(true);
                rotate.setInterpolator(new DecelerateInterpolator());
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        restaurantView.setText(selected);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                wheel.startAnimation(rotate);
            }
        });


    }
}
