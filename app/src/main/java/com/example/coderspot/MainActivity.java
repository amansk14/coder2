package com.example.coderspot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.coderspot.common.Activity_registrtn_and_login_panel;
import com.example.coderspot.common.OnBording;

public class MainActivity extends AppCompatActivity {


    private static int SPLASH_TIME_OUT = 5000;

    //hookie
    View first, second, third, fourth, fifth, sixth, seventh, eighth, ninth;
    TextView t1, t2, t3;

    //animations code
    Animation topanim, bottomanim, middleanim;

    SharedPreferences onBording;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        topanim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottomanim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        middleanim = AnimationUtils.loadAnimation(this, R.anim.middle_anim);

        //hooke

        first = findViewById(R.id.first_line);
        second = findViewById(R.id.second_line);
        third = findViewById(R.id.third_line);
        fourth = findViewById(R.id.fourth_line);
        fifth = findViewById(R.id.fifth_line);
        sixth = findViewById(R.id.sixth_line);



        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);

        //Setting Animation
        first.setAnimation(topanim);
        second.setAnimation(topanim);
        third.setAnimation(topanim);
        fourth.setAnimation(topanim);
        fifth.setAnimation(topanim);
        sixth.setAnimation(topanim);


        t1.setAnimation(middleanim);
        t2.setAnimation(middleanim);

        t3.setAnimation(bottomanim);

        //splash screen

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBording = getSharedPreferences("onBording", MODE_PRIVATE);

                boolean isFirstTime = onBording.getBoolean("firstTime", true);

                if (isFirstTime) {

                    SharedPreferences.Editor editor = onBording.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();
                    Intent intent = new Intent(getApplicationContext(), OnBording.class);
                    startActivity(intent);
                } else {

                    Intent intent = new Intent(getApplicationContext(), Activity_registrtn_and_login_panel.class);
                    startActivity(intent);

                }
                finish();
            }
        }, SPLASH_TIME_OUT);

    }
}



