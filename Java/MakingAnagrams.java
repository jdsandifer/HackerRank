// Problem from HackerRank:

// Alice is taking a cryptography class and finding anagrams to be very useful. 
// We consider two strings to be anagrams of each other if the first string's 
// letters can be rearranged to form the second string. In other words, both strings 
// must contain the same exact letters in the same exact frequency For example, 
// bacdc and dcbac are anagrams, but bacdc and dcbad are not.

// Alice decides on an encryption scheme involving two large strings where encryption 
// is dependent on the minimum number of character deletions required to make 
// the two strings anagrams. Can you help her find this number?

// Given two strings, a and b, that may or may not be of the same length, 
// determine the minimum number of character deletions required to make a and 
// b anagrams. Any characters can be deleted from either of the strings.


import java.util.HashSet;
import java.util.HashMap;
import java.lang.Math;
import java.util.Set;
import java.util.Iterator;
import java.util.Scanner;

public class Solution {
    public static int numberNeeded(String first, String second) {
      int deletionsNeeded = 0;
        
      // Setup data about strings
      Set<Character> firstUniques = new HashSet<>();
      Set<Character> secondUniques = new HashSet<>();
        
      HashMap<Character, Integer> firstQuantities = new HashMap<>();
      HashMap<Character, Integer> secondQuantities = new HashMap<>();
        
      for (char letter : first.toCharArray()) {
          firstUniques.add(letter);
          if (firstQuantities.containsKey(letter)) {
              int newQuantity = firstQuantities.get(letter) + 1;
              firstQuantities.put(letter, newQuantity);
          }
          else {
              firstQuantities.put(letter, 1);
          }
      }
        
      for (char letter : second.toCharArray()) {
          secondUniques.add(letter);
          if (secondQuantities.containsKey(letter)) {
              int newQuantity = secondQuantities.get(letter) + 1;
              secondQuantities.put(letter, newQuantity);
          }
          else {
              secondQuantities.put(letter, 1);
          }
      }
        
      // Compare strings for differences
      Iterator<Character> firstIterator = firstUniques.iterator();
       
      while (firstIterator.hasNext()) {
          char letter = firstIterator.next();
          
          if (secondUniques.contains(letter)) {
              deletionsNeeded += Math.abs(firstQuantities.get(letter) - secondQuantities.get(letter));
              secondUniques.remove(letter);
          }
          else {
              deletionsNeeded += firstQuantities.get(letter);
          }
      }  
        
      for (char letter : secondUniques) {
          deletionsNeeded += secondQuantities.get(letter);
      }  
        
      return deletionsNeeded;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
