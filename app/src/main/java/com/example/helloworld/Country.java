package com.example.helloworld;

import android.net.Uri;

public class Country {
    private String name;
    private int population;
    private Uri flagUri;

    public Country(String name, int population, Uri flagUri) {
        this.name = name;
        this.population = population;
        this.flagUri = flagUri;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public Uri getFlagUri() {
        return flagUri;
    }

}
