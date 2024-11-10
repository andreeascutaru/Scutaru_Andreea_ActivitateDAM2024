package com.example.repetattest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    /*
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("mesaj", "eroare");
        Log.w("mesaj", "warning");
    }*/

    public void Deschide(View view)
    {
        Intent it = new Intent(this, MainActivity2.class);
        it.putExtra("mesaj", "Mesaj transmis");
        it.putExtra("nr1", "11");
        it.putExtra("nr2", "10");
        startActivity(it);
    }
}