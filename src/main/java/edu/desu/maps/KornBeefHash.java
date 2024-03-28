package edu.desu.maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

public class KornBeefHash {

    /*
    1. Create a Key/Value Data Structure (ArrayList) that holds 17 values (0 - 16)
        Key needs to be an ArrayList
        Value needs to be an ArrayList
    2. Add insert(key, value), update(key, value), delete(key), get(key), & print() methods to this Data Store
    3. Add createHashCodeKey method using Cyclic-shift code from Zybooks for the Hash code Key
    4. Add createHashTableIndex method using the MAD method for Hash Function in Zybooks
    5. Add fixCollisions method using Separate chaining whenever index values collide
    6. Add a printIndex method that given any index Key it will print out the values
    7. Add a main method that reads in the words.txt file, removes non-alphanumeric characters
        and adds each word to data structure split between 17 slots
        separate words by spaces
    8. In the main method print the key with the most values in the form of key: value1 --> value2 --?
     */

    private final ArrayList<String> [] bucketsArray;
    private final int bucket, randomIntA, randomIntB;


    /*
        create a HashMap with capacity equal to bucket
        constructor to initialize HashMap of size = bucket
     */
    public KornBeefHash(int maxArraySize) {
        // TODO: YOUR CODE GOES HERE
        Random rand = new Random();
        this.bucket = maxArraySize;
        this.randomIntA = rand.nextInt(0, (bucket-1));
        this.randomIntB = rand.nextInt(0, (bucket-1));
        this.bucketsArray = new ArrayList[bucket];

        for(int i = 0; i < bucket; i++){
           bucketsArray[i] = new ArrayList<>();
        }
    }

    /*
      Hashcode Method copied directly from the book "Cyclic-shift hash codes"
     */
    static int createHashCodeKey(String s) {
        // TODO: YOUR CODE GOES HERE
        int h=0;
        for (int i=0; i<s.length(); i++) {
            h = (h << 5) | (h >>> 27);                    // 5-bit cyclic shift of the running sum
            h += (int) s.charAt(i);                       // add in next character
        }
        return h;
    }


    /*
      Hash function to map values to key
      Accept the key created by the hashCode
      use the Multiply-Add-and-Divide (or "MAD") method to disperse key across the map
      in the formula a, b are random integer from 0 to bucket - 1 (use rand.nextInt(0, bucket -1)
      P is a prime number large than bucket value
      N is the bucket size
     */
    public int createHashTableIndex(int key) {
        // create instance of Random class
        int prime = bucket + 1;
        while(!isPrime(prime)){
            prime += 1;
        }

        // TODO: YOUR CODE GOES HERE
        return Math.abs(((randomIntA * key + randomIntB) % prime) % bucket);
    }

    public boolean isPrime(int number){
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /*
      To insert a String value into the HashMap
      1. convert the string to a int hashcode using the hashCode(String value) method
      2. create the array index by passing the new hashcode value into the hashFunction
      3. use this index value to add the String to the arrayOfBuckets at that index
     */
    public void insertItem(String item) {

        // get the hash index of key
        // insert key into hash table at that index
        // TODO: YOUR CODE GOES HERE
        int hashcode = createHashCodeKey(item);
        int arrIndex = createHashTableIndex(hashcode);
        // this already handles collisions, it will append strings with the same index to the array at that index
        bucketsArray[arrIndex].add(item);
    }
    public void insertAllItems(ArrayList<String> listOfString){

        //for each item in the String Array, insert it into the HashMap
        // TODO: YOUR CODE GOES HERE
        for(String item: listOfString){
            insertItem(item);
        }
    }


    public int getIndex(String item) {
        // get the hash index of key
        // Check if key is in hash Map\=-p09
        // return the index or -1 if not present
        // TODO: YOUR CODE GOES HERE
        int index = createHashTableIndex(createHashCodeKey(item));

        if (bucketsArray[index].contains(item)){
            return index;
        }
        else {
            return -1;
        }
    }



    public void deleteItem(String item) {

        // get the hash index of key
        // Check if key is in hash Map
        // delete the key from hash table
        // TODO: YOUR CODE GOES HERE
        int index = getIndex(item);
        if(index != -1){
            bucketsArray[index].remove(item);
        }
    }

    // function to display Hash Map
    public void printIndex() {

        // TODO: YOUR CODE GOES HERE
        for (int i = 0; i < bucket; i++) {
            System.out.print(i);
            for (String value : bucketsArray[i]) {
                System.out.print("--> "+value);
            }
            System.out.println();
        }
    }

    public static String removeNonAlphanumeric(String str)
    {
        // replace any non alpha-numeric character with empty string
        // TODO: YOUR CODE GOES HERE
        return str.replaceAll("[^a-zA-Z0-9]", "");
    }

    // Drive Program
    public static void main(String[] args) throws FileNotFoundException {

        /*
         read in the words from the file and store them in an array
         iterate through the array and add each item to the KornBeefHash Map
         call printIndex() to print out the values
         */

        KornBeefHash kornbeef = new KornBeefHash(17);

        try (Scanner s = new Scanner(new FileReader("./src/main/resources/words.txt"))) {
            while (s.hasNext()) {
                final String nextWordWithoutSpecialCharacters = removeNonAlphanumeric(s.next());
                // TODO: YOUR CODE GOES HERE
                kornbeef.insertItem(nextWordWithoutSpecialCharacters);
            }
        }

        // TODO: MORE OF YOUR CODE GOES HERE
        kornbeef.printIndex();

        int maximum_index = 0;
        int maximum = 0;

        for(int i = 0; i < kornbeef.bucket; i++){
            if(kornbeef.bucketsArray[i].size() > maximum){
                maximum_index = i;
                maximum = kornbeef.bucketsArray[i].size();
            }
        }

        System.out.println();
        System.out.println("The key with the most value is: ");
        System.out.println(maximum_index + "--> " + kornbeef.bucketsArray[maximum_index]);

        System.out.println("the word 'extracted' is at index: "+kornbeef.getIndex("extracted"));
    }
}