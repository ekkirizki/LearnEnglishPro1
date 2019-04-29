package com.example.learnenglishpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    CardView bankSoal, materi,quiz,feedback,groupchat;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mAuth = FirebaseAuth.getInstance();

        Toolbar toolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(toolbar);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
//        return super.onCreateOptionsMenu(menu);
    return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, NightModeActivity.class));
                break;

            case R.id.logout:
                mAuth.signOut();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
//        return super.onOptionsItemSelected(item);
        return true;
    }

    public void Dict(View view) {
        startActivity(new Intent(HomeActivity.this, Kamus2.class));
    }

    public void Course(View view) {
        Intent i = new Intent(this, ListMateri.class);
        i.putExtra("Grammar", "Grammar");
        startActivity(i);
    }

//    public void Quiz(View view) {
//        startActivity(new Intent(HomeActivity.this,QuizActivity.class));
//    }

    public void FeedBack(View view) {
        startActivity(new Intent(HomeActivity.this,FeedbackActivity.class));
    }

    public void GroupChat(View view) {
        startActivity(new Intent(HomeActivity.this,ChatActivity.class));
    }

}
