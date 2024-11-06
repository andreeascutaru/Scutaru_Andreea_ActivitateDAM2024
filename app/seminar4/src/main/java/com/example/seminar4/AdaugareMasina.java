package com.example.seminar4;

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

public class AdaugareMasina extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adaugare_masina);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //aici aveam aia cu spinner

        Intent intent= getIntent();
        if(intent.hasExtra("automobil")){
            EditText etMarca = findViewById(R.id.marcaET);
            String marca = etMarca.getText().toString();

            EditText etModel = findViewById(R.id.modelET);
            String model = etModel.getText().toString();

            EditText etAnFabricatie = findViewById(R.id.anFabricatieET);
            int anFabricatie = Integer.parseInt(etAnFabricatie.getText().toString());

            EditText etKilometraj = findViewById(R.id.kilometrajET);
            int kilometraj = Integer.parseInt(etKilometraj.getText().toString());

            EditText etCuloare = findViewById(R.id.culoareET);
            String culoare = etCuloare.getText().toString();

            RadioGroup rgStare = findViewById(R.id.stare);
            int idSelectat = rgStare.getCheckedRadioButtonId();

            String stare = "";
            if(idSelectat == R.id.faraAvarii)
            {RadioButton rbNeavariat = findViewById(R.id.faraAvarii);
                stare = rbNeavariat.getText().toString();}
            else
            {
                if(idSelectat == R.id.avarii)
                {
                    RadioButton rbAvariat = findViewById(R.id.avarii);
                    stare = rbAvariat.getText().toString();
                }
            }

            ArrayList<String> dotari = new ArrayList<>();
            CheckBox cbIncalzireScaune = findViewById(R.id.incalzireScaune);
            CheckBox cbSenzori = findViewById(R.id.senzori);
            CheckBox cbCamera = findViewById(R.id.camera);
            if(cbIncalzireScaune.isChecked())
                dotari.add(cbIncalzireScaune.getText().toString());
            if(cbSenzori.isChecked())
                dotari.add(cbSenzori.getText().toString());
            if(cbCamera.isChecked())
                dotari.add(cbCamera.getText().toString());

            Spinner spSursaEnergie = findViewById(R.id.sursaEnergie);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(AdaugareMasina.this, R.array.sursaEnergie, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spSursaEnergie.setAdapter(adapter);
            String sursaEnergie = spSursaEnergie.getSelectedItem().toString();

            Switch swTransmisie = findViewById((R.id.transmisie));
            String transmisie = "";
            if(swTransmisie.isChecked())
                transmisie = swTransmisie.getTextOn().toString();
            else
                transmisie = swTransmisie.getTextOff().toString();
            RatingBar rbConditie = findViewById(R.id.conditie);
            float conditie = rbConditie.getRating();
        }

        Button btnAdaugare = findViewById(R.id.adaugatiMasina);
        btnAdaugare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etMarca = findViewById(R.id.marcaET);
                String marca = etMarca.getText().toString();

                EditText etModel = findViewById(R.id.modelET);
                String model = etModel.getText().toString();

                EditText etAnFabricatie = findViewById(R.id.anFabricatieET);
                int anFabricatie = Integer.parseInt(etAnFabricatie.getText().toString());

                EditText etKilometraj = findViewById(R.id.kilometrajET);
                int kilometraj = Integer.parseInt(etKilometraj.getText().toString());

                EditText etCuloare = findViewById(R.id.culoareET);
                String culoare = etCuloare.getText().toString();

                RadioGroup rgStare = findViewById(R.id.stare);
                int idSelectat = rgStare.getCheckedRadioButtonId();

                String stare = "";
                if(idSelectat == R.id.faraAvarii)
                {RadioButton rbNeavariat = findViewById(R.id.faraAvarii);
                    stare = rbNeavariat.getText().toString();}
                else
                {
                    if(idSelectat == R.id.avarii)
                    {
                        RadioButton rbAvariat = findViewById(R.id.avarii);
                        stare = rbAvariat.getText().toString();
                    }
                }

                ArrayList<String> dotari = new ArrayList<>();
                CheckBox cbIncalzireScaune = findViewById(R.id.incalzireScaune);
                CheckBox cbSenzori = findViewById(R.id.senzori);
                CheckBox cbCamera = findViewById(R.id.camera);
                if(cbIncalzireScaune.isChecked())
                    dotari.add(cbIncalzireScaune.getText().toString());
                if(cbSenzori.isChecked())
                    dotari.add(cbSenzori.getText().toString());
                if(cbCamera.isChecked())
                    dotari.add(cbCamera.getText().toString());

                Spinner spSursaEnergie = findViewById(R.id.sursaEnergie);
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(AdaugareMasina.this, R.array.sursaEnergie, android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spSursaEnergie.setAdapter(adapter);
                String sursaEnergie = spSursaEnergie.getSelectedItem().toString();

                Switch swTransmisie = findViewById((R.id.transmisie));
                String transmisie = "";
                if(swTransmisie.isChecked())
                    transmisie = swTransmisie.getTextOn().toString();
                else
                    transmisie = swTransmisie.getTextOff().toString();
                RatingBar rbConditie = findViewById(R.id.conditie);
                float conditie = rbConditie.getRating();
                Automobil automobil = new Automobil(marca, model, anFabricatie, kilometraj, culoare, stare, dotari, sursaEnergie, transmisie, conditie);
                Intent it = new Intent();
                it.putExtra("automobil", automobil);
                setResult(RESULT_OK, it);
                finish();

            }
        });
    }
}