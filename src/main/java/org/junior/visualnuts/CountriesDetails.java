package org.junior.visualnuts;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CountriesDetails {

    public static Country[] countries;
    
    public static void main(String[] args) {
      
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = VisualNuts.class.getClassLoader().getResourceAsStream("countries.json");
            countries = mapper.readValue(inputStream, Country[].class);
            Arrays.stream(countries).forEach(x -> System.out.println(x.getLanguages()));
            
            System.out.println("Number of Countries: " + getNumberOfCountries());
        } catch (IOException  e) {
            e.printStackTrace();
        }

    }
    
    public static int getNumberOfCountries() {
        return countries.length;
    }
    
    public static String getCountryWithTheMostOfficialLanguage() {
        return "";
    }
    
    public static void countsAllOfficialLanguages() {
        System.out.println("");
    }
    
    public static int getCountryWithHighestNumberOfLanguages() {
        return 0;
    }
    
    
}

