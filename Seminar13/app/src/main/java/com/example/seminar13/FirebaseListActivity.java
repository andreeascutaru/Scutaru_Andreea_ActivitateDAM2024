package com.example.seminar13;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseListActivity extends AppCompatActivity {

    private ListView listView;
    private DatabaseReference databaseReference;
    private List<Automobil> listaAutomobile;
    private ArrayAdapter<Automobil> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_list);

        listView = findViewById(R.id.firebaseListView);
        listaAutomobile = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaAutomobile);
        listView.setAdapter(adapter);

        FirebaseApp.initializeApp(this);
        databaseReference = FirebaseDatabase.getInstance().getReference("test");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaAutomobile.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Automobil automobil = dataSnapshot.getValue(Automobil.class);
                    if (automobil != null) {
                        listaAutomobile.add(automobil);
                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(FirebaseListActivity.this,
                        "Eroare la citirea din Firebase: " + error.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}