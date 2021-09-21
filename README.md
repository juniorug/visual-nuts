# visual-nuts-exercises

### Exercise 1:

`VisualNuts` class is responsible for executing the algorithm that prints the whole integer numbers to the console. It starts from the number 1 and prints all numbers going up to the number configured in `config.properties` file. However, when the number is divisible by 3, do not print the number, but print the word 'Visual'. If the number is divisible by 5, do not print the number, but print 'Nuts'. And for all numbers divisible by both (e.g.: the number 15), the same, but print 'Visual Nuts'.

The method `getNaxNumberProperty` is responsible for reading the configuration file and managing all possible errors that could be:
* IOException: when the file does not exists, for example.
* NumberFormatException: When the value is not numeric or exceeds the Integer.MAX_VALUE value.

The `visualNuts` method receives an integer and returns the string based on the logic above.
The method `loopAndPrintVisualNuts` iterates from 1 through the value read from the configuration file, calls the `visualNuts` method for each item, and prints the result.

To guarantee that this code keeps working when developers start making small feature adjustments and keep the code safe from bugs, the class `VisualNutsTest` was written. It makes tests for the config file and also for methods for the `VisualNuts` class. 


### Exercise 2:

`CountriesDetails` class reads a set of data in JSON, describing official languages spoken by countries. The file is located under `src/main/resources` folder and prints information about the current questions:

* Q1: The number of countries in the world;
* Q2: The country with the most official languages, where they officially speak German (de);
* Q3: Counts all the official languages spoken in the listed countries;
* Q4: Find the country with the highest number of official languages;
* Q5: Find the most common official language(s), of all countries.

There's one method for each question above. Also, for question 2, there's one other method that can be used to get the country with the most official languages by providing as a parameter any other country abbreviation.

To guarantee that this code keeps working when developers start making small feature adjustments and keep the code safe from bugs, the class `CountriesDetailsTest` was written. It makes tests for the config file and also for methods for the `CountriesDetails` class. 