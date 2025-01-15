package com.example.proiectrepetat;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Masina implements Parcelable {
    private String marca;
    private int anFabricatie;
    private String stare;//radiobutton
    private ArrayList<String> dotari;//checkbox
    private String sursaEnergie;//spinner
    private String transmisie;//switch
    private float conditie;//ratingBar

    public Masina(String marca, int anFabricatie, String stare, ArrayList<String> dotari, String sursaEnergie, String transmisie,float conditie) {
        this.marca = marca;
        this.anFabricatie = anFabricatie;
        this.stare = stare;
        this.dotari = dotari;
        this.sursaEnergie = sursaEnergie;
        this.transmisie=transmisie;
        this.conditie = conditie;
    }

    public Masina(){
        this.marca = "";
        this.anFabricatie = 0;
        this.stare = "";
        this.dotari = new ArrayList<>();
        this.sursaEnergie = "";
        this.transmisie="";
        this.conditie = 0;
    }

    protected Masina(Parcel in) {
        marca = in.readString();
        anFabricatie = in.readInt();
        stare = in.readString();
        dotari = in.createStringArrayList();
        sursaEnergie = in.readString();
        transmisie = in.readString();
        conditie = in.readFloat();
    }

    public static final Creator<Masina> CREATOR = new Creator<Masina>() {
        @Override
        public Masina createFromParcel(Parcel in) {
            return new Masina(in);
        }

        @Override
        public Masina[] newArray(int size) {
            return new Masina[size];
        }
    };

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public String getStare() {
        return stare;
    }

    public void setStare(String stare) {
        this.stare = stare;
    }

    public ArrayList<String> getDotari() {
        return dotari;
    }

    public void setDotari(ArrayList<String> dotari) {
        this.dotari = dotari;
    }

    public String getSursaEnergie() {
        return sursaEnergie;
    }

    public void setSursaEnergie(String sursaEnergie) {
        this.sursaEnergie = sursaEnergie;
    }

    public String getTransmisie() {
        return transmisie;
    }

    public void setTransmisie(String transmisie) {
        this.transmisie = transmisie;
    }

    public float getConditie() {
        return conditie;
    }

    public void setConditie(float conditie) {
        this.conditie = conditie;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Masina{");
        sb.append("marca='").append(marca).append('\'');
        sb.append(", anFabricatie=").append(anFabricatie);
        sb.append(", stare='").append(stare).append('\'');
        sb.append(", dotari=").append(dotari);
        sb.append(", sursaEnergie='").append(sursaEnergie).append('\'');
        sb.append(", transmisie='").append(transmisie).append('\'');
        sb.append(", conditie=").append(conditie);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(marca);
        parcel.writeInt(anFabricatie);
        parcel.writeString(stare);
        parcel.writeStringList(dotari);
        parcel.writeString(sursaEnergie);
        parcel.writeString(transmisie);
        parcel.writeFloat(conditie);
    }
}
