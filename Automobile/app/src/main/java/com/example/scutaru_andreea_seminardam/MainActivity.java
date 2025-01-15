package com.example.scutaru_andreea_seminardam;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Actiune", "onStart");
        Log.w("Actiune", "Warning");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Actiune", "onResume");
        Log.w("Actiune", "Warning");
        Toast.makeText(this, R.string.mesaj, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Actiune", "onPause");
        Log.w("Actiune", "Warning");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Actiune", "onStop");
        Log.w("Actiune", "Warning");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Actiune", "onDestroy");
        Log.w("Actiune", "Warning");
    }
}