package org.junior.visualnuts;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CountriesDetails {

    public static void main(String[] args) {
        
        ObjectMapper mapper = new ObjectMapper();
        
        
        
        
        InputStream inputStream = VisualNuts.class.getClassLoader().getResourceAsStream("countries.json");
        try {
            Country[] Countries = mapper.readValue(inputStream, Country[].class);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        JSONParser jsonParser = new JSONParser();
        JSONArray a = null;
        try {
            a = (JSONArray)jsonParser.parse(new InputStreamReader(inputStream, "UTF-8"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        

        for (Object o : a)
        {
          JSONObject country = (JSONObject) o;

          String abbreviation = (String) country.get("country");
          System.out.println("abbreviation: " + abbreviation);

         
          JSONArray languages = (JSONArray) country.get("languages");

          for (Object c : languages)
          {
            System.out.println(c+"");
          }
        }

    }
    
    public static int getNumberOfCountries() {
        return 0;
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
    
    class Country {
        
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
}

