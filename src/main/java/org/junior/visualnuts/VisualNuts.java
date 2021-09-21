package org.junior.visualnuts;

import java.util.stream.IntStream;

public class VisualNuts {

    public static void main(String[] args) 
    {
        printVisualNuts(100);
    }
    
    private static void printVisualNuts(int num) {
        IntStream.rangeClosed(1, 100)
                .mapToObj(i -> i % 3 == 0 ? (i % 5 == 0 ? "Visual Nuts" : "Visual") : (i % 5 == 0 ? "Nuts" : i))
                .forEach(System.out::println);
    }
    
}
