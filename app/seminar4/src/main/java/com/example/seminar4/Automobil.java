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
    private String sursaEnergie;
    private String transimisie;
    private float conditie;
    public Automobil(String marca, String model, int anFabricatie, int kilometraj, String culoare, String stare, ArrayList<String> dotari, String sursaEnergie, String transimisie, float conditie) {
        this.marca = marca;
        this.model = model;
        this.anFabricatie = anFabricatie;
        this.kilometraj = kilometraj;
        this.culoare = culoare;
        this.stare = stare;
        this.dotari = dotari;
        this.sursaEnergie = sursaEnergie;
        this.transimisie = transimisie;
        this.conditie = conditie;
    }

    public Automobil()
    {
        this.marca = "Peugeot";
        this.model = "208";
        this.anFabricatie = 2023;
        this.kilometraj = 14000;
        this.culoare = "Gri";
        this.stare = "Neavariata";
        this.sursaEnergie="Benzina";
        this.transimisie = "Automata";
        this.conditie = 5;
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

    public String getSursaEnergie() {
        return sursaEnergie;
    }

    public void setSursaEnergie(String sursaEnergie) {
        this.sursaEnergie = sursaEnergie;
    }

    public String getTransimisie() {
        return transimisie;
    }

    public void setTransimisie(String transimisie) {
        this.transimisie = transimisie;
    }

    public float getConditie() {
        return conditie;
    }

    public void setConditie(float conditie) {
        this.conditie = conditie;
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
        sb.append(", sursaEnergie='").append(sursaEnergie).append('\'');
        sb.append(", transmisie='").append(transimisie).append('\'');
        sb.append(", conditie='").append(conditie).append('\'');
        sb.append('}');
        return sb.toString();
    }
}



