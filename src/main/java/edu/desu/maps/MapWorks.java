package edu.desu.maps;

import net.datafaker.providers.entertainment.EntertainmentFaker;

import java.util.*;

public class MapWorks {

    /* (1)
     Using put() and putAll() methods, create a method that does the following:
     1. creates a Map called "months" which represents the months of the year
     2. creates a second empty Map
     3. uses putAll() to copy the values of the "months" Map into the empty Map
     4. Prints out the key --> values of all the entries of both Maps
     */
    public void creatMapUsingPut() {


        //Creating HashMap with default initial capacity and load factor

        HashMap<String, Integer> months = new HashMap<String, Integer>(12);

        //Inserting key-value pairs to map using put() method
        // TODO: A) YOUR CODE GOES HERE
        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);


        //Printing key-value pairs of the Map using the entrySet
        // TODO: B) YOUR CODE GOES HERE
        for (Map.Entry<String, Integer> entry : months.entrySet()) {
            System.out.println(entry.getKey() + "--> " + entry.getValue());
        }

        //Creating another HashMap
        // TODO: C) YOUR CODE GOES HERE

        HashMap<String, Integer> myEmptyHashMap = new HashMap<>();

        //Inserting key-value pairs of map to anotherMap using putAll() method
        // TODO: E) YOUR CODE GOES HERE

        myEmptyHashMap.putAll(months);

        //Printing key-value pairs of anotherMap
        // TODO: F) YOUR CODE GOES HERE

        for (Map.Entry<String, Integer> entry : myEmptyHashMap.entrySet()) {
            System.out.println(entry.getKey() + "--> " + entry.getValue());
        }

    }


    /* (2)
     Review the methods of HashMap and add a given key-value pair to HashMap if and only if it is not present in the HashMap
     1. create a Map called "seasons" add 3 seasons
     2. add the 4th season only if it is not present
     3. try to add it again;
     4. print out the key --> value of all the entries
     */
    public void addIfNotPresent() {
        // TODO: YOUR CODE GOES HERE
        HashMap<String, Integer> seasons = new HashMap<>();

        seasons.put("Spring", 1);
        seasons.put("Summer", 2);
        seasons.put("Autumn", 3);

        seasons.putIfAbsent("Winter", 4);
        seasons.putIfAbsent("Winter", 4);

        for (Map.Entry<String, Integer> entry : seasons.entrySet()) {
            System.out.println(entry.getKey() + "-->" + entry.getValue());
        }

    }

    /* (3)
     How do you retrieve a value associated with a given key from the HashMap?
     1. create a Map representing colors of the rainbow
     2. write code to print out the key --> value representing YELLOW
     */
    public void printYellow() {
        // TODO: YOUR CODE GOES HERE
        HashMap<Integer, String> rainbowColors = new HashMap<Integer, String>();
        rainbowColors.put(1, "Red");
        rainbowColors.put(2, "Orange");
        rainbowColors.put(3, "Yellow");
        rainbowColors.put(4, "Green");
        rainbowColors.put(5, "Blue");
        rainbowColors.put(6, "Indigo");
        rainbowColors.put(7, "Violet");

        for(Map.Entry<Integer, String> entry: rainbowColors.entrySet()){
            if(entry.getValue().equals("Yellow")){
                System.out.println("the key "+entry.getKey()+" has the value "+entry.getValue());
            }

        }

    }


    /* (4)
      How do you check whether a particular key/value exist in a HashMap?
      1. create a Map representing colors of the rainbow
      2. write code to print out if the value representing INDIGO exists (True or False)
      3. write code to print out if the value representing BLACK exists( True or False)
     */
    public void doesItExits() {
        // TODO: YOUR CODE GOES HERE
        HashMap<String, String> rainbowColors = new HashMap<String, String>();
        rainbowColors.put("Red", "First Color");
        rainbowColors.put("Orange", "Second Color");
        rainbowColors.put("Yellow", "Third Color");
        rainbowColors.put("Green", "Fourth Color");
        rainbowColors.put("Blue", "Fifth Color");
        rainbowColors.put("Indigo", "Sixth Color");
        rainbowColors.put("Violet", "Seventh Color");

        if(rainbowColors.containsKey("Indigo")){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
        if(rainbowColors.containsKey("Black")){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }

    }

    /* (5)
     1. create a map of the Months of the year
     2. print out the number of key-value mappings present in a HashMap
     3. empty out all data in the HashMap
     4. Print out the value of the Hashmap after emptying it out
     */
    public void printDataAndClear() {
        // TODO: YOUR CODE GOES HERE
        HashMap<String, Integer> months = new HashMap<String, Integer>();

        months.put("January", 1);
        months.put("February", 2);
        months.put("March", 3);
        months.put("April", 4);
        months.put("May", 5);
        months.put("June", 6);
        months.put("July", 7);
        months.put("August", 8);
        months.put("September", 9);
        months.put("October", 10);
        months.put("November", 11);
        months.put("December", 12);

        System.out.println("Number of elements in HashMap: " + months.size());

        months.clear();

        System.out.println("Value of HashMap after emptying: " + months);
    }

    /* (6)
      1. create a map of the States in the US
      2. print out all keys in the map
      3. print out all values in the map
      4. print out the Key --> values in the map
     */
    public void printUSStates() {
        // TODO: YOUR CODE GOES HERE
        HashMap<String, String> states = new HashMap<String, String>();
        states.put("Alabama", "AL");
        states.put("Alaska", "AK");
        states.put("Arizona", "AZ");
        states.put("Arkansas", "AR");
        states.put("California", "CA");
        states.put("Colorado", "CO");
        states.put("Connecticut", "CT");
        states.put("Delaware", "DE");
        states.put("Florida", "FL");
        states.put("Georgia", "GA");
        states.put("Hawaii", "HI");
        states.put("Idaho", "ID");
        states.put("Illinois", "IL");
        states.put("Indiana", "IN");
        states.put("Iowa", "IA");
        states.put("Kansas", "KS");
        states.put("Kentucky", "KY");
        states.put("Louisiana", "LA");
        states.put("Maine", "ME");
        states.put("Maryland", "MD");
        states.put("Massachusetts", "MA");
        states.put("Michigan", "MI");
        states.put("Minnesota", "MN");
        states.put("Mississippi", "MS");
        states.put("Missouri", "MO");
        states.put("Montana", "MT");
        states.put("Nebraska", "NE");
        states.put("Nevada", "NV");
        states.put("New Hampshire", "NH");
        states.put("New Jersey", "NJ");
        states.put("New Mexico", "NM");
        states.put("New York", "NY");
        states.put("North Carolina", "NC");
        states.put("North Dakota", "ND");
        states.put("Ohio", "OH");
        states.put("Oklahoma", "OK");
        states.put("Oregon", "OR");
        states.put("Pennsylvania", "PA");
        states.put("Rhode Island", "RI");
        states.put("South Carolina", "SC");
        states.put("South Dakota", "SD");
        states.put("Tennessee", "TN");
        states.put("Texas", "TX");
        states.put("Utah", "UT");
        states.put("Vermont", "VT");
        states.put("Virginia", "VA");
        states.put("Washington", "WA");
        states.put("West Virginia", "WV");
        states.put("Wisconsin", "WI");
        states.put("Wyoming", "WY");


        System.out.println("All the keys on the map");
        for(String state: states.keySet()){
            System.out.println(state);
        }

        System.out.println();

        System.out.println("All the values on the map");
        for(String stateAbbreviation: states.values()){
            System.out.println(stateAbbreviation);
        }
        System.out.println();

        System.out.println("All the keys and values on the map");
        for(Map.Entry<String, String> entry: states.entrySet()){
            System.out.println(entry.getKey() + "--> " + entry.getValue());
        }
    }


    /* (7)
     Java has the Collection interface
     using one of the HashMap method to return a collection representing the Map values ONLY
     1. create a map of the days of the week
     2. create a collection from the map values
     3. print out the collection of values
     */
    public void printDaysOfWeek() {
        // TODO: YOUR CODE GOES HERE
        HashMap<Integer, String> week = new HashMap<>();
        week.put(1, "Sunday");
        week.put(2, "Monday");
        week.put(3, "Tuesday");
        week.put(4, "Wednesday");
        week.put(5, "Thursday");
        week.put(6, "Friday");
        week.put(7, "Saturday");

        Collection<String> dayNames = week.values();
        System.out.println("Collection values");
        for(String day: dayNames){
            System.out.println(day);
        }
    }

    /* (8)
    Using the Days of the week Map, remove the weekend elements from the map
    1. create a Days of the week map
    2. remove the weekend days
    3. print the key --> values of the Map
     */
    public void shortenedWeek() {
        // TODO: YOUR CODE GOES HERE
        HashMap<Integer, String> week = new HashMap<>();
        week.put(1, "Sunday");
        week.put(2, "Monday");
        week.put(3, "Tuesday");
        week.put(4, "Wednesday");
        week.put(5, "Thursday");
        week.put(6, "Friday");
        week.put(7, "Saturday");

        week.remove(1);
        week.remove(7);

        for(Map.Entry<Integer, String> entry: week.entrySet()){
            System.out.println(entry.getKey() + "--> "+entry.getValue());
        }
    }

    /* (9)
     Spanish Map
     1. create a Days of the week Map in English
     2. print the key --> values of the map
     3. without creating a new Map, replace the values with their spanish version
     4. print the key --> values of the map
     */
    public void spanishWeek() {
        // TODO: YOUR CODE GOES HERE
        HashMap<Integer, String> week = new HashMap<>();
        week.put(1, "Sunday");
        week.put(2, "Monday");
        week.put(3, "Tuesday");
        week.put(4, "Wednesday");
        week.put(5, "Thursday");
        week.put(6, "Friday");
        week.put(7, "Saturday");

        System.out.println("English version");

        for(Map.Entry<Integer, String> entry: week.entrySet()){
            System.out.println(entry.getKey() + "--> "+entry.getValue());
        }

        week.replace(1, "domingo");
        week.replace(2, "lunes");
        week.replace(3, "martes");
        week.replace(4, "miércoles");
        week.replace(5, "jueves");
        week.replace(6, "viernes");
        week.replace(7, "sábado");

        System.out.println("Spanish version");

        for(Map.Entry<Integer, String> entry: week.entrySet()){
            System.out.println(entry.getKey() + "--> "+entry.getValue());
        }
    }

    public static void main(String [] args){
        MapWorks map  = new MapWorks();
        System.out.println("Test cases");
        map.creatMapUsingPut();
        System.out.println();
        map.addIfNotPresent();
        System.out.println();
        map.printYellow();
        System.out.println();
        map.doesItExits();
        System.out.println();
        map.printDataAndClear();
        System.out.println();
        map.printUSStates();
        System.out.println();
        map.printDaysOfWeek();
        System.out.println();
        map.shortenedWeek();
        System.out.println();
        map.spanishWeek();
        System.out.println("End of test cases");
    }
}
