// Solution to the ransom note problem: Can the ransom note
// be made by cutting words from a magazine given the note 
// and the magazine text? (Yes or No)

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String[] magazine = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String[] ransom = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        
        Map<String, Integer> magWordCounts = new HashMap<>();
        for (int i = 0; i < magazine.length; i++)
            if (!magWordCounts.containsKey(magazine[i]))
                magWordCounts.put(magazine[i], 1);
            else
                magWordCounts.put(magazine[i], magWordCounts.get(magazine[i]) + 1);
        System.out.println(canMakeRansomNote(magWordCounts, ransom));
    }
    
    public static String canMakeRansomNote(Map<String, Integer> magWordCounts, String[] note) {
        for (int i = 0; i < note.length; i++) {
            if (!magWordCounts.containsKey(note[i]))
                return "No";
            else {
                int count = magWordCounts.get(note[i]);
                if (count <= 0)
                    return "No";
                else
                    magWordCounts.put(note[i], count - 1);
            }
        }
        return "Yes";
    }
}
