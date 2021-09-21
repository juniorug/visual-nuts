package org.junior.visualnuts;

import java.util.ArrayList;
import java.util.List;

public class Country {

    String country;

    List<String> languages;

    Country() {
        this.languages = new ArrayList<String>();
    }

    public Country(String country, List<String> languages) {
        this.country = country;
        this.languages = languages;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

}
