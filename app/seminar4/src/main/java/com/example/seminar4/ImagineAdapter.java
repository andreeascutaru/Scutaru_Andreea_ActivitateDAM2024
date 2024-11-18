package com.example.seminar4;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
