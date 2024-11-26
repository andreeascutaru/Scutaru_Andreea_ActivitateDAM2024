package com.example.seminar4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ImagineAdapter extends BaseAdapter {
    private List<ImagineDomeniu> imagini = null;
    private Context ctx;
    private int imagine_layout;

    public ImagineAdapter(List<ImagineDomeniu> imagini, Context ctx, int imagine_layout) {
        this.imagini = imagini;
        this.ctx = ctx;
        this.imagine_layout = imagine_layout;
    }

    @Override
    public int getCount() {
        return imagini.size();
    }

    @Override
    public Object getItem(int i) {
        return imagini.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater  inflater  = LayoutInflater.from(ctx);
        View view = inflater.inflate(imagine_layout, parent, false);

        ImagineDomeniu imagine = (ImagineDomeniu) getItem(position);
        ImageView img = view.findViewById(R.id.imagineIV);
        TextView text = view.findViewById(R.id.textAfisatTV);

        img.setImageBitmap(imagine.getImagine());
        text.setText(imagine.getTextAfisat());

        return view;
    }
}
