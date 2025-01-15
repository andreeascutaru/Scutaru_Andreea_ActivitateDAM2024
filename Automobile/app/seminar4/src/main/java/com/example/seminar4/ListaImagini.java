package com.example.seminar4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ListaImagini extends AppCompatActivity {


    List<ImagineDomeniu> imagini = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_imagini);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        List <Bitmap> listaImagini = new ArrayList<>();
        List<String> linkuriImagini = new ArrayList<>();

        linkuriImagini.add("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8b/Ferrari_F8_Tributo_Genf_2019_1Y7A5665.jpg/1200px-Ferrari_F8_Tributo_Genf_2019_1Y7A5665.jpg");
        linkuriImagini.add("https://static.automarket.ro/img/auto_resized/db/article/119/219/792393l-1000x640-b-677aa986.jpg");
        linkuriImagini.add("https://upload.wikimedia.org/wikipedia/commons/thumb/d/d0/Bugatti_Bolide_Milano.jpg/640px-Bugatti_Bolide_Milano.jpg");
        linkuriImagini.add("https://hips.hearstapps.com/hmg-prod/images/aston-martin-valhalla-101-1626200852.jpg");
        linkuriImagini.add("https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/McLaren_P1.jpg/1200px-McLaren_P1.jpg");

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {

                for (String link : linkuriImagini) {
                    HttpURLConnection connection = null;
                    try {
                        URL url = new URL(link);
                        connection = (HttpURLConnection) url.openConnection();
                        InputStream inputStream = connection.getInputStream();
                        listaImagini.add(BitmapFactory.decodeStream(inputStream));

                    } catch (MalformedURLException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        imagini = new ArrayList<>();
                        imagini.add(new ImagineDomeniu("Ferrari", listaImagini.get(0), "https://en.wikipedia.org/wiki/Ferrari_F8"));
                        imagini.add(new ImagineDomeniu("Lamborghini", listaImagini.get(1), "https://www.automarket.ro/stiri/acesta-este-noul-lamborghini-temerario-primul-lamborghini-din-istorie-cu-119219.html"));
                        imagini.add(new ImagineDomeniu("Bugatti", listaImagini.get(2), "https://en.wikipedia.org/wiki/Bugatti_Bolide"));
                        imagini.add(new ImagineDomeniu("Aston Martin", listaImagini.get(3), "https://www.caranddriver.com/aston-martin/valhalla"));
                        imagini.add(new ImagineDomeniu("", listaImagini.get(4), "https://en.wikipedia.org/wiki/McLaren_P1"));

                        ListView lv = findViewById(R.id.lvImagini);
                        ImagineAdapter adapter = new ImagineAdapter(imagini, getApplicationContext(), R.layout.imagine_layout);
                        lv.setAdapter(adapter);
                    }
                });
            }
        });
        ListView lv = findViewById(R.id.lvImagini);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Intent it = new Intent(getApplicationContext(), WebViewActivity.class);
                        it.putExtra("link", imagini.get(i).getLink());
                        startActivity(it);
                    }
                });


    }
}