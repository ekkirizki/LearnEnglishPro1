package com.example.learnenglishpro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class Youtube extends AppCompatActivity implements YouTubePlayer.OnInitializedListener{
private YouTubePlayerFragment playerFragment;
private YouTubePlayer mPlayer;
private String YouTubeKey = "AIzaSyAvRnouiwkf3_gwtv-0kpxBpmtVNYuXYyM";

FirebaseFirestore db;
FirebaseAuth mAuth;
FirebaseUser mUser;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_youtube);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();

        playerFragment =
        (YouTubePlayerFragment) getFragmentManager().findFragmentById(R.id.youtube_player_fragment);

        playerFragment.initialize(YouTubeKey, this);

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
        mPlayer.loadVideo("9rLZYyMbJic");
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