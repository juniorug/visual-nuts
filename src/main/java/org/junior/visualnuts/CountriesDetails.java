package org.junior.visualnuts;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CountriesDetails {

    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = VisualNuts.class.getClassLoader().getResourceAsStream("countries.json");
            Country[] countries = mapper.readValue(inputStream, Country[].class);
            // Arrays.stream(countries).forEach(x -> System.out.println(x.getLanguages()));
            System.out.println("Number of Countries: " + getNumberOfCountries(countries));

            Country countryWithTheMostOfficialLanguage = getCountryWithTheMostOfficialLanguage(countries);
            System.out.println(countryWithTheMostOfficialLanguage);

            System.out.println("countsAllOfficialLanguages: ");
            countsAllOfficialLanguages(countries).entrySet().forEach(System.out::println);
            
            Country countryWithHighestNumberOfLanguages = getCountryWithTheMostOfficialLanguage(countries);
            System.out.println(countryWithHighestNumberOfLanguages);
            
            System.out.println("mostCommonOfficialLanguages: ");
            mostCommonOfficialLanguages(countries);
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected static int getNumberOfCountries(Country[] countries) {
        return countries.length;
    }

    protected static Country getCountryWithTheMostOfficialLanguage(Country[] countries, String abbreviation) {
        return Arrays.stream(countries).filter(l -> l.getLanguages().contains(abbreviation.toLowerCase()))
                .max(Comparator.comparingInt(Country::getLanguagesSize)).orElseThrow(NoSuchElementException::new);
    }

    protected static Country getCountryWithTheMostOfficialLanguage(Country[] countries) {
        return getCountryWithTheMostOfficialLanguage(countries, "DE");
    }

    protected static Map<String, Integer> countsAllOfficialLanguages(Country[] countries) {
        return Arrays.stream(countries).collect(Collectors.toMap(Country::getCountry, Country::getLanguagesSize));
    }

    protected static Country getCountryWithHighestNumberOfLanguages(Country[] countries) {
        return Arrays.stream(countries)
                .max(Comparator.comparingInt(Country::getLanguagesSize)).orElseThrow(NoSuchElementException::new);
    }
    
    protected static List<String> mostCommonOfficialLanguages(Country[] countries) {
        Map<String, Long> counted = Arrays.stream(countries)
        .map(c -> c.getLanguages())
        .flatMap(List::stream)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        counted.entrySet().forEach(System.out::println);
        
        Long maxValueInMap=(Collections.max(counted.values()));  // This will return max value in the HashMap
        for (Entry<String, Long> entry : counted.entrySet()) {  // Iterate through HashMap
            if (entry.getValue()==maxValueInMap) {
                System.out.println(entry.getKey());     // Print the key with max value
            }
        };
        
        
        Map<String, Long> commons = counted.entrySet()
        .stream()
        .filter(map -> map.getValue()==maxValueInMap)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        
        System.out.println("result:");
        commons.entrySet().forEach(System.out::println);
        //.forEach( map -> System.out.println( "Após Java 8 : " + map.getKey() ) );
        
        
        Entry<String, Long> maxEntry = Collections.max(counted.entrySet(), (Entry<String, Long> e1, Entry<String, Long> e2) -> e1.getValue()
                .compareTo(e2.getValue()));
        
        System.out.println("maxEntry: " + maxEntry);
//        maxEntry..forEach(System.out::println);
        //.forEach(System.out::println);
        
        //.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        
        /*.map(l -> Arrays.asList(e.get("Role"), e.get("Name")))
        .collect(Collectors.groupingBy(e -> e.get(0),
                 Collectors.mapping(e -> e.get(1), Collectors.toList())));*/
        return null;
    }
}
