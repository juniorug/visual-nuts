package org.junior.visualnuts;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CountriesDetails {

    public static void main(String[] args) {

        try {
            /* Initializes the application by reading the json file */
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = VisualNuts.class.getClassLoader().getResourceAsStream("countries.json");
            Country[] countries = mapper.readValue(inputStream, Country[].class);

            /* Q1 */
            System.out.println("Q1: Number of countries in the world: ");
            System.out.println(getNumberOfCountries(countries));
            System.out.println("");

            /* Q2 */
            System.out
                    .println("Q2: Country with the most official languages, where they officially speak German (de): ");
            Country countryWithTheMostOfficialLanguage = getCountryWithTheMostOfficialLanguage(countries);
            System.out.println(countryWithTheMostOfficialLanguage);
            System.out.println("");
            
            /* Q3 */
            System.out.println("Q3: Counts all the official languages spoken in the listed countries: ");
            countsAllOfficialLanguages(countries)
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(System.out::println);
            System.out.println("");

            /* Q4 */
            System.out.println("Q4: Country with the highest number of official languages: ");
            Country countryWithHighestNumberOfLanguages = getCountryWithTheMostOfficialLanguage(countries);
            System.out.println("Number of languages: " + countryWithHighestNumberOfLanguages.getLanguages().size());
            System.out.println(countryWithHighestNumberOfLanguages);
            System.out.println("");

            /* Q5 */
            System.out.println("Q5: Most common official language(s), of all countries: ");
            mostCommonOfficialLanguages(countries).entrySet().forEach(System.out::println);

           
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Returns the number of countries in the world.
     * 
     * @param countries
     *            an array of countries
     * @return the number of countries in the given array
     */
    protected static int getNumberOfCountries(Country[] countries) {
        return countries.length;
    }

    /**
     * Finds the country with the most official languages, by a given country
     * abbreviation.
     * 
     * @param countries
     *            an array of countries
     * @return the country with the most official languages
     */
    protected static Country getCountryWithTheMostOfficialLanguage(Country[] countries, String abbreviation) {
        return Arrays.stream(countries)
                .filter(l -> l.getLanguages().contains(abbreviation.toLowerCase()))
                .max(Comparator.comparingInt(Country::getLanguagesSize))
                .orElseThrow(NoSuchElementException::new);
    }

    /**
     * Finds the country with the most official languages, where they officially
     * speak German (de).
     * 
     * @param countries
     *            an array of countries
     * @return the country with the most official languages
     */
    protected static Country getCountryWithTheMostOfficialLanguage(Country[] countries) {
        return getCountryWithTheMostOfficialLanguage(countries, "DE");
    }

    /**
     * Counts all the official languages spoken in the listed countries.
     * 
     * @param countries
     *            an array of countries
     * @return a map with the country and a count of all the official languages
     *         spoken
     */
    protected static Map<String, Integer> countsAllOfficialLanguages(Country[] countries) {
        return Arrays.stream(countries)
                .collect(Collectors.toMap(Country::getCountry, Country::getLanguagesSize));
    }

    /**
     * Find the country with the highest number of official languages.
     * 
     * @param countries
     *            an array of countries
     * @return the country with the highest number of official languages
     */
    protected static Country getCountryWithHighestNumberOfLanguages(Country[] countries) {
        return Arrays.stream(countries)
                .max(Comparator.comparingInt(Country::getLanguagesSize))
                .orElseThrow(NoSuchElementException::new);
    }

    /**
     * Find the most common official language(s), of all countries.
     * 
     * @param countries
     *            an array of countries
     * @return a map with the most common official language(s), of all countries.
     */
    protected static Map<String, Long> mostCommonOfficialLanguages(Country[] countries) {
        Map<String, Long> counted = Arrays.stream(countries)
                .map(c -> c.getLanguages())
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return counted.entrySet().stream()
                .filter(map -> map.getValue() == Collections.max(counted.values()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}
