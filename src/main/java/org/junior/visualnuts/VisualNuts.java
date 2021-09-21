package org.junior.visualnuts;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.stream.IntStream;

public class VisualNuts {

    public static void main(String[] args) {
        loopAndPrintVisualNuts(getNaxNumberProperty());
    }

    /**
     * Prints the whole integer numbers to the console, start
     * from the number 1, and print all numbers going up to the number received.. 
     *
     * @param  num  the maximum value in the range to be printed
     */
    public static void loopAndPrintVisualNuts(int num) {
        IntStream.rangeClosed(1, num)
            .mapToObj(VisualNuts::visualNuts)
            .forEach(System.out::println);
    }

    /**
    * Returns a string based on VisualNuts algorithm logic:
    * If the number is divisible by 3, returns word 'Visual'.
    * If the number is divisible by 5, returns word 'Nuts'.
    * If the number is divisible by 3 and 5, returns word 'Visual Nuts'.
    * If the number is not divisible by 3 or 5, returns the number itself.
    *  
    * @param  i  an integer to be evaluated for the algorithm
    * @return    the string based on the logic applied
    */
    protected static String visualNuts(int i) {
        return (i % 3 == 0 ? (i % 5 == 0 ? "Visual Nuts" : "Visual") : (i % 5 == 0 ? "Nuts" : String.valueOf(i)));
    }

    /**
    * Reads the config.properties file and returns the maxNumber value. 
    *
    * @return  the maxNumber value.
    */
    protected static int getNaxNumberProperty() {
        try {
            final Properties prop = new Properties();
            InputStream input = VisualNuts.class.getClassLoader().getResourceAsStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and return it out
            return Integer.parseInt(prop.getProperty("maxNumber"));
        } catch (IOException e) {
            System.out.println("Error loading config file");
            e.printStackTrace();
            return 0;
        } catch (NumberFormatException e) {
            System.out.println("Error converting value from config file");
            e.printStackTrace();
            return 0;
        }

    }

}
