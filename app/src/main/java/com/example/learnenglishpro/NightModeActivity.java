package com.example.learnenglishpro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class NightModeActivity extends AppCompatActivity {

    Switch switch_nightmode, bigSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        //untuk auto day/night
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setTitle("Learn English Pro Night");
//        }

        switch_nightmode = findViewById(R.id.switch_nightmode);
        bigSize = findViewById(R.id.switch_bigsize);
        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);

        int mode = AppCompatDelegate.getDefaultNightMode();
        if (mode == AppCompatDelegate.MODE_NIGHT_YES) {
            switch_nightmode.setChecked(true);
        }
        else{
            switch_nightmode.setChecked(false);
        }
        switch_nightmode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mode = AppCompatDelegate.getDefaultNightMode();
                if (mode == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
            }
        });
        bigSize.setChecked(prefs.getBoolean("bigSize", false));
    }

    public void save(View view) {
        SharedPreferences.Editor editor = getSharedPreferences(getPackageName(), MODE_PRIVATE).edit();
        editor.putBoolean("bigSize", bigSize.isChecked());
        editor.apply();

        if (bigSize.isChecked()){
            bigSize.setTextSize(getResources().getDimension(R.dimen.big));
        }else{
            bigSize.setTextSize(getResources().getDimension(R.dimen.small));
        }
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}