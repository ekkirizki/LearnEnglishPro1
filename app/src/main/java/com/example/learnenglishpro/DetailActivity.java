/*
 * Created by omrobbie.
 * Copyright (c) 2018. All rights reserved.
 * Last modified 10/21/17 11:53 AM.
 */

package com.example.learnenglishpro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    public static final String ITEM_WORD = "ITEM_WORD";
    public static final String ITEM_TRANSLATE = "ITEM_TRANSLATE";

    @BindView(R.id.tv_word)
    TextView tv_word;

    @BindView(R.id.tv_translate)
    TextView tv_translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        tv_word.setText(getIntent().getStringExtra(ITEM_WORD));
        tv_translate.setText(getIntent().getStringExtra(ITEM_TRANSLATE));
    }
}
