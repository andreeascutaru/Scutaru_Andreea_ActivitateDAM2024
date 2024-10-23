package com.example.seminar4;
import java.io.Serializable;
import java.util.ArrayList;

public class Automobil implements Serializable{
    private String marca;
    private String model;
    private int anFabricatie;
    private int kilometraj;
    private String culoare;
    private String stare;
    private ArrayList<String> dotari;
    public Automobil(String marca, String model, int anFabricatie, int kilometraj, String culoare, String stare, ArrayList<String> dotari) {
        this.marca = marca;
        this.model = model;
        this.anFabricatie = anFabricatie;
        this.kilometraj = kilometraj;
        this.culoare = culoare;
        this.stare = stare;
        this.dotari = dotari;
    }

    public Automobil()
    {
        this.marca = "Peugeot";
        this.model = "208";
        this.anFabricatie = 2023;
        this.kilometraj = 14000;
        this.culoare = "Gri";
        this.stare = "Neavariata";
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public int getKilometraj() {
        return kilometraj;
    }

    public void setKilometraj(int kilometraj) {
        this.kilometraj = kilometraj;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Automobil{");
        sb.append("marca='").append(marca).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", anFabricatie=").append(anFabricatie);
        sb.append(", kilometraj=").append(kilometraj);
        sb.append(", culoare='").append(culoare).append('\'');
        sb.append(", stare='").append(stare).append('\'');
        sb.append(", dotari='").append(dotari).append('\'');
        sb.append('}');
        return sb.toString();
    }
}



