package com.example.learnenglishpro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMateri extends AppCompatActivity {

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private DocumentReference PCT, SPasT, SPreT, SPerT;
    private CollectionReference Past;

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private String id;
    private List<String> ids;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listmateri);

        listView = findViewById(R.id.list_view);

            String data = getIntent().getExtras().getString("Grammar");
            Toast.makeText(this,data,Toast.LENGTH_SHORT).show();
            Past = db.collection("Materi").document("Grammar").collection("Past Tense");
//            PCT = db.collection("Materi").document("Grammar").collection("Past Tense").document("Present Continuous Tense");
//            SPasT = db.collection("Materi").document("Grammar").collection("Past Tense").document("Simple Past Tense");
//            SPreT = db.collection("Materi").document("Grammar").collection("Past Tense").document("Simple Perfect Tense");
//            SPerT = db.collection("Materi").document("Grammar").collection("Past Tense").document("Simple Present Tense");

        Past.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                ids = new ArrayList<>();
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        id = document.getId();
                        ids.add(id);
                    }
                }
                arrayAdapter = new ArrayAdapter<String>(ListMateri.this, android.R.layout.simple_list_item_1, ids);
                listView.setAdapter(arrayAdapter);
            }
        });
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String yourData = ids.get(position);
                Toast.makeText(ListMateri.this,yourData,Toast.LENGTH_LONG).show();
                Intent i = new Intent(ListMateri.this, Youtube.class);
                i.putExtra("a", yourData);
                startActivity(i);
            }
        });
//        listView.OnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               TextView listItem = v.findViewById(android.R.id.text1);
//               String Item = listItem.getText().toString();
//               Toast.makeText(ListMateri.this, Item, Toast.LENGTH_SHORT).show();
//            }
//        });
    }


//        public void saveNote(View v) {
//            String title = editTextTitle.getText().toString();
//            String description = editTextDescription.getText().toString();
//
//            Map<String, Object> note = new HashMap<>();
//            note.put(KEY_TITLE, title);
//            note.put(KEY_DESCRIPTION, description);
//
//            noteRef.set(note)
//                    .addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void aVoid) {
//                            Toast.makeText(ListMateri.this, "Note saved", Toast.LENGTH_SHORT).show();
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(ListMateri.this, "Error!", Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, e.toString());
//                        }
//                    });
//        }

//        public void loadNote(View v) {
//            noteRef.get()
//                    .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            if (documentSnapshot.exists()) {
//                                String title = documentSnapshot.getString(KEY_TITLE);
//                                String description = documentSnapshot.getString(KEY_DESCRIPTION);
//
//                                //Map<String, Object> note = documentSnapshot.getData();
//
//                                textViewData.setText("Title: " + title + "\n" + "Description: " + description);
//                            } else {
//                                Toast.makeText(ListMateri.this, "Document does not exist", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            Toast.makeText(ListMateri.this, "Error!", Toast.LENGTH_SHORT).show();
//                            Log.d(TAG, e.toString());
//                        }
//                    });
//        }

}
