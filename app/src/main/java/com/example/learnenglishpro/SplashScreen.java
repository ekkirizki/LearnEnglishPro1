package com.example.learnenglishpro;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
ProgressBar progressBar;
int counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //init();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
//        getSupportActionBar().hide();
        progressBar = findViewById(R.id.progressBar);
        counter = 0;
        new CountDownTimer(3000,100){
            @Override
            public void onTick(long millisUntilFinished) {
                counter++;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    progressBar.setProgress((int)counter*100/(3000/100),true);
                }else{
                    progressBar.setProgress((int)counter*100/(3000/100));
                }
            }

            @Override
            public void onFinish() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    progressBar.setProgress(100,true);
                }else{
                    progressBar.setProgress(100);
                }
                startActivity(new Intent(SplashScreen.this,LoginActivity.class));
                finish();
            }
        }.start();
    }

    /* private void init(){
        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        if (prefs.getBoolean("nightMode", false)) {
            setTheme(R.style.dark);
        } else {
            setTheme(R.style.light);
        }
    }*/
}
