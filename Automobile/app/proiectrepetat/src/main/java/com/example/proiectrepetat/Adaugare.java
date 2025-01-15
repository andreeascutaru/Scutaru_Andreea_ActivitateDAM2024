package com.example.proiectrepetat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class Adaugare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.adaugare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.btnAdaugare);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etMarca=findViewById(R.id.marcaET);
                String marca= etMarca.getText().toString();

                EditText etAnFabricatie = findViewById(R.id.anFabricatieET);
                int anFabricatie = Integer.parseInt(etAnFabricatie.getText().toString());

                RadioGroup rgStare = findViewById(R.id.stareRG);
                int idSelectat = rgStare.getCheckedRadioButtonId();
                String stare = "";

                if(idSelectat==R.id.neavariataRB){
                    RadioButton rbNeavariata = findViewById(R.id.neavariataRB);
                    stare = rbNeavariata.getText().toString();
                }
                else {
                    if (idSelectat == R.id.avariataRB) {
                        RadioButton rbAvariata = findViewById(R.id.avariataRB);
                        stare = rbAvariata.getText().toString();
                    }
                }

                ArrayList<String> dotari = new ArrayList<>();
                CheckBox cbCamera = findViewById(R.id.cameraCB);
                CheckBox cbSenzori = findViewById(R.id.senzoriCB);
                if(cbCamera.isChecked()){
                    dotari.add(cbCamera.getText().toString());
                }
                if(cbSenzori.isChecked()){
                    dotari.add(cbSenzori.getText().toString());
                }

                Spinner spSursaEnergie = findViewById(R.id.sursaEnergieSP);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Adaugare.this, R.array.sursaEnergie, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spSursaEnergie.setAdapter(adapter);
                String sursaEnergie = spSursaEnergie.getSelectedItem().toString();

                Switch swTransmisie = findViewById(R.id.transmisieSW);
                String transmisie = "";
                if(swTransmisie.isChecked()){
                    transmisie = swTransmisie.getTextOn().toString();
                }
                else{
                    transmisie = swTransmisie.getTextOff().toString();
                }

                RatingBar rbConditie = findViewById(R.id.conditieRB);
                float conditie = rbConditie.getRating();

                Masina masina = new Masina(marca, anFabricatie, stare, dotari, sursaEnergie, transmisie, conditie);
                Intent it = new Intent();
                it.putExtra("masina", masina);
                setResult(RESULT_OK, it);
                finish();

            }
        });
    }
}