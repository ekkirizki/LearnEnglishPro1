/*
 * Created by omrobbie.
 * Copyright (c) 2018. All rights reserved.
 * Last modified 10/21/17 11:53 AM.
 */

package com.example.learnenglishpro;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static final String ITEM_WORD = "ITEM_WORD";
    public static final String ITEM_TRANSLATE = "ITEM_TRANSLATE";

    @BindView(R.id.tv_word)
    TextView word;

    @BindView(R.id.tv_translate)
    TextView translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        word.setText(getIntent().getStringExtra(ITEM_WORD));
        translate.setText(getIntent().getStringExtra(ITEM_TRANSLATE));

        word = findViewById(R.id.tv_word);
        translate = findViewById(R.id.tv_translate);
        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        if (prefs.getBoolean("bigSize", false)) {
            word.setTextSize(getResources().getDimension(R.dimen.big) + 12);
            translate.setTextSize(getResources().getDimension(R.dimen.big) - 18);
        } else {
            word.setTextSize(getResources().getDimension(R.dimen.small) + 12);
            translate.setTextSize(getResources().getDimension(R.dimen.small) - 12);
        }
//        word.setText(getIntent().getStringExtra("judul"));
//        judul.setText(prefs.getBoolean("bigSize", false)+""+getResources().getDimension(R.dimen.small));
//        translate.setText(getIntent().getStringExtra("author") + " | " + getIntent().getStringExtra("date"));
    }

    private void setupSharedPreferences() {
        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        toggleTheme(prefs.getBoolean("nightMode", false));

    }

    public void toggleTheme(Boolean bo) {
        if (bo) {
            setTheme(R.style.dark);
        } else {
            setTheme(R.style.light);
        }
    }
}
