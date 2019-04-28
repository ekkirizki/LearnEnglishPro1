package com.example.learnenglishpro;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FeedbackActivity extends AppCompatActivity {

    private static final String TAG = "FeedBackActivity";

    FirebaseAuth mAuth;
    FirebaseUser mUser;
    FirebaseFirestore db;
    DocumentReference reff;

    private static final String KEY_BUG = "Bug";
    private static final String KEY_SARAN = "Saran";
    private static final String KEY_DESK = "Deskripsi";
    private static final String KEY_EMAIL = "Email";
    private static final String KEY_USER = "Username";

    RadioButton Isu, Sugest;
    EditText desc;
    Button kirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();

        Isu = findViewById(R.id.id_issues);
        Sugest = findViewById(R.id.id_suggestions);
        desc = findViewById(R.id.id_desc);
    }

    public void Kirim(View view) {

        String EUser = mUser.getEmail();
        String DUser = mUser.getDisplayName();

        String isu = Isu.getText().toString();
        String sugest = Sugest.getText().toString();
        String desk = desc.getText().toString();

        Map<String, Object> FB = new HashMap<>();

        if (Isu.isChecked()){
            FB.put(KEY_BUG, isu);
            FB.put(KEY_DESK, desk);
            FB.put(KEY_EMAIL, EUser);
            FB.put(KEY_USER, DUser);
            db.collection("Feedback").document("Bug").set(FB)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(FeedbackActivity.this, "Feedback saved", Toast.LENGTH_SHORT).show();
                            desc.setText("");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(FeedbackActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, e.toString());
                        }
                    });
        }
        else if (Sugest.isChecked()){
            FB.put(KEY_SARAN, sugest);
            FB.put(KEY_DESK, desk);
            FB.put(KEY_EMAIL, EUser);
            FB.put(KEY_USER, DUser);
            db.collection("Feedback").document("Saran").set(FB)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(FeedbackActivity.this, "Feedback saved", Toast.LENGTH_SHORT).show();
                            desc.setText("");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(FeedbackActivity.this, "Error!", Toast.LENGTH_SHORT).show();
                            Log.d(TAG, e.toString());
                        }
                    });
        }
    }
}
