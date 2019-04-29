
package com.example.learnenglishpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class materi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);
    }

    public void Grammar(View view) {
        Intent i = new Intent(this, ListMateri.class);
        i.putExtra("Grammar", "Grammar");
        startActivity(i);
    }
}
