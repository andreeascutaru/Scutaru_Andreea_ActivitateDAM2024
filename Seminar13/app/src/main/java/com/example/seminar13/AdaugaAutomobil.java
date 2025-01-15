package com.example.seminar13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AdaugaAutomobil extends AppCompatActivity {
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_automobil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.btnAdaugareAutomobil);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etMarca = findViewById(R.id.edMarca);
                String marca = etMarca.getText().toString();

                EditText etAnFabricatie = findViewById(R.id.edAnFabricatie);
                int anFabricatie = Integer.parseInt(etAnFabricatie.getText().toString());

                Automobil automobil = new Automobil(anFabricatie, marca);

                CheckBox cb = findViewById(R.id.cbFavorite);
                if(cb.isChecked()){
                    databaseReference = FirebaseDatabase.getInstance().getReference("test");
                    databaseReference.push().setValue(automobil).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(AdaugaAutomobil.this, "Automobil salvat cu succes in Firebase", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(AdaugaAutomobil.this, "Eroare la adaugarea in Firebase" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

                finish();
            }
        });
    }
}