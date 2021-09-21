package org.junior.visualnuts;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    
    public int getLanguagesSize() {
        return languages.size();
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, languages);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Country other = (Country) obj;
        return Objects.equals(country, other.country) && Objects.equals(languages, other.languages);
    }

    @Override
    public String toString() {
        return "Country [country=" + country + ", languages=" + languages + "]";
    }

}
