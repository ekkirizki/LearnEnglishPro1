package com.example.learnenglishpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    CardView bankSoal, materi,quiz,feedback,groupchat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        bankSoal = findViewById(R.id.bankcardId);
//
//        bankSoal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomeActivity.this, MainActivity.class));
//            }
//        });
//
//        materi = findViewById(R.id.materi);
//
//        materi.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomeActivity.this, materi.class));
//            }
//        });
//
//        quiz = findViewById(R.id.quiz);
//
//        quiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomeActivity.this,QuizActivity.class));
//
//            }
//        });
//
//        feedback = findViewById(R.id.feedback);
//
//        feedback.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomeActivity.this,FeedbackActivity.class));
//
//            }
//        });
//
//        groupchat = findViewById(R.id.groupchat);
//
//        groupchat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(HomeActivity.this,ChatActivity.class));
//            }
//        });
    }

    public void Dict(View view) {
        startActivity(new Intent(HomeActivity.this, Kamus2.class));
    }

    public void Course(View view) {
        startActivity(new Intent(HomeActivity.this,materi.class));
    }

    public void Quiz(View view) {
        startActivity(new Intent(HomeActivity.this,QuizActivity.class));
    }

    public void FeedBack(View view) {
        startActivity(new Intent(HomeActivity.this,FeedbackActivity.class));
    }

    public void GroupChat(View view) {
        startActivity(new Intent(HomeActivity.this,ChatActivity.class));
    }
}
