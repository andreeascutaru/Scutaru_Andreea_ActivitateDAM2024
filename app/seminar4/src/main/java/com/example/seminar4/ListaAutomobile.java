package com.example.seminar4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ListaAutomobile extends AppCompatActivity {

    private List<Automobil> automobile = null;
    private int idModificat = 0;
    private AutomobilAdapter adapter = null;
    private AutomobilDatabase automobilDatabase = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_automobile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Intent it = getIntent();
        //automobile = it.getParcelableArrayListExtra("automobile");

        ListView lv = findViewById(R.id.automobileLV);

        //ArrayAdapter<Automobil> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, automobile);
        //lv.setAdapter(adapter);

        automobilDatabase = Room.databaseBuilder(this, AutomobilDatabase.class, "AutomobileDB").build();

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        //adapter = new AutomobilAdapter(automobile, getApplicationContext(), R.layout.date_introduse);
        //lv.setAdapter(adapter);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    automobile = automobilDatabase.getDaoObject().getAutomobile();
                }finally{
                    handler.post(() -> {
                        adapter = new AutomobilAdapter(automobile, getApplicationContext(), R.layout.date_introduse);
                        lv.setAdapter(adapter);
                    });
                }
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentModifica = new Intent(getApplicationContext(), AdaugareMasina.class);
                intentModifica.putExtra("automobil", automobile.get(i));
                idModificat=i;
                startActivityForResult(intentModifica, 209);
                Toast.makeText(getApplicationContext(), automobile.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //automobile.remove(i);
                //adapter.notifyDataSetChanged();
                SharedPreferences sp = getSharedPreferences("obiecteFavorite", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString(automobile.get(i).getKey(), automobile.get(i).toString());
                editor.commit();
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==209){
                automobile.set(idModificat, data.getParcelableExtra("automobil"));
                adapter.notifyDataSetChanged();
            }
        }
    }
}