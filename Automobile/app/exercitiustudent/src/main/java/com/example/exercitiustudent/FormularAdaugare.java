package com.example.exercitiustudent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
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

import java.util.Calendar;
import java.util.Date;

public class FormularAdaugare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formular_adaugare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.btnAdaugare);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText etNume = findViewById(R.id.numeEdit);
                String nume = etNume.getText().toString();

                EditText etVarsta = findViewById(R.id.varstaEdit);
                int varsta = Integer.parseInt(etVarsta.getText().toString());

                RadioGroup radioSex = findViewById(R.id.sexRG);
                RadioButton rbSex = findViewById(radioSex.getCheckedRadioButtonId());
                String sex = rbSex.getText().toString();

                Spinner spSpecializare = findViewById(R.id.specializareSpinner);
                String specializare = spSpecializare.getSelectedItem().toString();

                CheckBox cbIntegralist = findViewById(R.id.integralistCB);
                boolean integralist = cbIntegralist.isChecked();

                Switch swLicenta = findViewById(R.id.licentaSW);
                boolean licenta = swLicenta.isChecked();

                RatingBar rbVenit = findViewById(R.id.venitRB);
                float venit = rbVenit.getRating();

                DatePicker dpDataNastere = findViewById(R.id.dataNasteriiDP);
                int year = dpDataNastere.getYear();
                int month = dpDataNastere.getMonth();
                int day = dpDataNastere.getDayOfMonth();
                Calendar calendar = Calendar.getInstance();
                Date dataNasterii = calendar.getTime();

                Student student = new Student(nume, varsta, sex, specializare, integralist, licenta, venit, dataNasterii);

                Intent it = new Intent();
                it.putExtra("student", student);
                setResult(RESULT_OK, it);
                finish();

            }
        });
    }
}

//private String nume;//editText
//private int varsta;//editText
//private String sex;//RadioButton
//private String specializare;//Spinner
//private boolean integralist;//CheckBox
//private boolean licenta;//Switch
//private float venit;//RatingBar
//private Date dataNasterii;//DatePicker