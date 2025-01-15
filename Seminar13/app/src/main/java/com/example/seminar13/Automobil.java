package com.example.seminar13;

public class Automobil {
    private String marca;
    private int anFabricatie;

    public Automobil(int anFabricatie, String marca) {
        this.marca = marca;
        this.anFabricatie = anFabricatie;
    }

    public Automobil() {
        this.marca = "test";
        this.anFabricatie = 100;
    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Automobil{");
        sb.append("marca='").append(marca).append('\'');
        sb.append(", anFabricatie=").append(anFabricatie);
        sb.append('}');
        return sb.toString();
    }
}
