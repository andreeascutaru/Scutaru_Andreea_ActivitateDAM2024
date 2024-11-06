package com.example.seminar4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AutomobilAdapter extends BaseAdapter {

    private List<Automobil> automobile = null;
    private Context ctx;
    private int dateIntroduseLayout;

    public AutomobilAdapter(List<Automobil> automobile, Context ctx, int dateIntroduseLayout) {
        this.automobile = automobile;
        this.ctx = ctx;
        this.dateIntroduseLayout = dateIntroduseLayout;
    }

    @Override
    public int getCount() {
        return automobile.size();
    }

    @Override
    public Object getItem(int i) {
        return automobile.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View v= inflater.inflate(dateIntroduseLayout, viewGroup, false);
        TextView marcaTV = v.findViewById(R.id.marcaAd);
        TextView modelTV = v.findViewById(R.id.modelAd);
        TextView anFabricatieTV = v.findViewById(R.id.anFabricatieAd);
        TextView kilometrajTV = v.findViewById(R.id.kilometrajAd);
        TextView culoareTV = v.findViewById(R.id.culoareAd);
        TextView stareTV = v.findViewById(R.id.stareAd);
        TextView dotariTV = v.findViewById(R.id.dotariAd);
        TextView sursaEnergieTV = v.findViewById(R.id.sursaEnergieAd);
        TextView transmisieTV = v.findViewById(R.id.transmiseAd);
        TextView conditieTV = v.findViewById(R.id.conditieAd);

        Automobil automobil = (Automobil)getItem(i);

        marcaTV.setText(automobil.getMarca());
        modelTV.setText(automobil.getModel());
        anFabricatieTV.setText(String.valueOf(automobil.getAnFabricatie()));
        kilometrajTV.setText(String.valueOf(automobil.getKilometraj()));
        culoareTV.setText(automobil.getCuloare());
        stareTV.setText(automobil.getStare());
        dotariTV.setText(automobil.getDotariConcatenate());
        sursaEnergieTV.setText(automobil.getSursaEnergie());
        transmisieTV.setText(automobil.getTransimisie());
        conditieTV.setText(String.valueOf(automobil.getConditie()));

        return v;
    }
}
