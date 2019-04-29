package com.example.learnenglishpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Youtube extends AppCompatActivity implements YouTubePlayer.OnInitializedListener{
private YouTubePlayerFragment playerFragment;
private YouTubePlayer mPlayer;
private String YouTubeKey = "AIzaSyAvRnouiwkf3_gwtv-0kpxBpmtVNYuXYyM";

FirebaseFirestore db;
FirebaseAuth mAuth;
FirebaseUser mUser;
DocumentReference ref;
DocumentReference PCT, SPasT, SPreT, SPerT;
List<String> Kalimat, RNegative, RPositive;
String Desk, YKey;
TextView JMateri, Deskripsi, Positif, Negatif, Kal;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_youtube);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();
//        PCT = db.collection("Materi").document("Grammar").collection("Past Tense").document("Present Continuous Tense");
//        SPasT = db.collection("Materi").document("Grammar").collection("Past Tense").document("Simple Past Tense");
//        SPreT = db.collection("Materi").document("Grammar").collection("Past Tense").document("Simple Perfect Tense");
//        SPerT = db.collection("Materi").document("Grammar").collection("Past Tense").document("Simple Present Tense");

        JMateri = findViewById(R.id.JMateri);
        Positif = findViewById(R.id.Positiv);
        Deskripsi = findViewById(R.id.Deskripsi);
        Negatif = findViewById(R.id.Negativ);
        Kal = findViewById(R.id.Kalimat);

        playerFragment =
        (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_player_fragment);

        playerFragment.initialize(YouTubeKey, this);

        String data = getIntent().getStringExtra("a");
        ref = db.collection("Materi").document("Grammar").collection("Past Tense").document(data);
        JMateri.setText(data);

        ref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        if (task.isSuccessful()) {
                                DocumentSnapshot document = task.getResult();
                                if (document.exists()) {
                                        Kalimat = (ArrayList<String>) document.get("Contoh Kalimat");
                                        Desk = document.getString("Deskripsi");
                                        RNegative = (ArrayList<String>) document.get("Rumus Negative");
                                        RPositive = (ArrayList<String>) document.get("Rumus Positive");
                                        YKey = document.getString("Youtube");

                                        Negatif.setText(RNegative.toString());
                                        Positif.setText(RPositive.toString());
                                        Kal.setText(Kalimat.toString());
                                        Deskripsi.setText(Desk);

                                        Log.d("Contoh Kalimat", Kalimat.toString());
                                }
                        }
                }
        })
                .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                                Toast.makeText(Youtube.this, "Error!", Toast.LENGTH_SHORT).show();
                                Log.d("Data Ini", e.toString());
                        }
                });
        }

@Override
public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
        boolean wasRestored) {
        mPlayer = player;

        //Enables automatic control of orientation
        mPlayer.setFullscreenControlFlags(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_ORIENTATION);

        //Show full screen in landscape mode always
        mPlayer.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_ALWAYS_FULLSCREEN_IN_LANDSCAPE);

        //System controls will appear automatically
        mPlayer.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CONTROL_SYSTEM_UI);

        if (!wasRestored) {
        //player.cueVideo("9rLZYyMbJic");
        mPlayer.loadVideo(YKey);
        }
        else
        {
        mPlayer.play();
        }
        }

@Override
public void onInitializationFailure(YouTubePlayer.Provider provider,
        YouTubeInitializationResult errorReason) {
        mPlayer = null;
        }
        }