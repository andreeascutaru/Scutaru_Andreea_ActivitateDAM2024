package com.example.seminar4;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class ListaImagini extends AppCompatActivity {

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

        List<String> linkuriImagini = new ArrayList<>();
        linkuriImagini.add("https://assets.protv.ro/assets/incont/2013/12/29/image_galleries/39274/compania-care-a-fabricat-100-de-masini-in-19-ani-povestea-cele-mai-exclusiviste-marci-auto-din-lume-ldquo_3_size9.jpg");
        linkuriImagini.add("https://likewolf.com/img/luxury-car-brands.jpg");
        linkuriImagini.add("https://blog.sothebysrealty.co.uk/hubfs/Richest%20Car%20Collections-jpg.jpeg");
        linkuriImagini.add("https://imgsrv2.voi.id/qNbBVfrnezjjzBbgYyUCzguQzcacv1nunZGYQq_XmcM/auto/1200/675/sm/1/bG9jYWw6Ly8vcHVibGlzaGVycy8xNjI3OTMvMjAyMjA0MjcyMzM2LW1haW4uY3JvcHBlZF8xNjUxMDc3NDUxLmpwZw.jpg");
        linkuriImagini.add("https://cdn.romania-insider.com/sites/default/files/styles/amp_1200x675_16_9/public/2024-03/tiriac_collection_-_photo_tiriac_collection_on_fb.jpeg");

    }
}