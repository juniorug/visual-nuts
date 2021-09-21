package org.junior.visualnuts;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Before;
import org.junit.Test;

public class CountriesDetailsTest {

    private static final String BELGIUM_ABBREVIATION = "BE";
    private  Country[] countries;
    private Country belgium;

    @Before
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = VisualNuts.class.getClassLoader().getResourceAsStream("countries.json");
        countries = mapper.readValue(inputStream, Country[].class);

        belgium = new Country(BELGIUM_ABBREVIATION, Arrays.asList("nl", "fr", "de"));
    }
    
    @Test
    public void testGetNumberOfCountries() {
 
        assertEquals(5, CountriesDetails.getNumberOfCountries(countries));
       
    }
    
    @Test
    public void getCountryWithTheMostOfficialLanguage() {
 
        Country belgium = new Country(BELGIUM_ABBREVIATION, Arrays.asList("nl", "fr", "de"));
        assertEquals(belgium, CountriesDetails.getCountryWithTheMostOfficialLanguage(countries));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenExceptionThrown_thenExpectationSatisfied() {
        assertEquals(belgium, CountriesDetails.getCountryWithTheMostOfficialLanguage(countries, BELGIUM_ABBREVIATION));
    }
    
    
    @Test
    public void countsAllOfficialLanguages() {
 
        Map<String, Integer> countriesMap = new HashMap<String, Integer>();
        countriesMap.put("BE", 3);
        countriesMap.put("NL", 2);
        countriesMap.put("DE", 1);
        countriesMap.put("ES", 1);
        countriesMap.put("US", 1);
           
        assertEquals(countriesMap, CountriesDetails.countsAllOfficialLanguages(countries));
       
    }
    
    @Test
    public void getCountryWithHighestNumberOfLanguages() {
        assertEquals(belgium, CountriesDetails.getCountryWithHighestNumberOfLanguages(countries));
       
    }
    
    @Test
    public void mostCommonOfficialLanguages() {
 
        Map<String, Long> countriesMap = new HashMap<String, Long>();
        countriesMap.put("de", 2L);
        countriesMap.put("nl", 2L);
        assertEquals(countriesMap, CountriesDetails.mostCommonOfficialLanguages(countries));
       
    }
    
    
}
