// Solving for minimum rolls to complete the Chutes and Ladders game.
// This problem is from HackerRank.com, uses a 10x10 board, and refers
// to the game using its original name of Snakes and Ladders.

// I started solving this problem through whiteboarding and am just
// recording my work so far. After I transfer it to HackeRank and test
// it, I'll post the working version here.

import java.lang.Math;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // Input reading code to come
        
        System.out.println(recursiveMinimumRolls(5, new HashMap(), new HashMap(), 1, new HashSet());
    }
    
    public static int recursiveMinimumRolls(
            int size, 
            Map<Integer, Integer> chutes, 
            Map<Integer, Integer> ladders, 
            int currentSpace, 
            Set<Integer> spacesVisited) {
        Set spacesVisitedNow = new HashSet(spacesVisited.toList());
        spacesVisitedNow.put(space);
        if (space == size * size)
            return 0;
        else if (chutes.containsKey(space) && !spacesVisited.contains(chutes.get(space))
            return recursiveMinimumRolls(size, chutes, ladders, chutes.get(space), spacesVisitedNow);
        else if (chutes.containsKey(space) && spacesVisited.contains(chutes.get(space))
            return Integer.MAX;
        else {
            int minRolls = Integer.MAX;
            int currentRolls = Integer.MAX;
            if (ladders.containsKey(space))
                minRolls = recursiveMinimumRolls(size, chutes, ladders, ladders.get(space), spacesVisitedNow);
            int possibleRolls = Math.min(6, (size * size) - space);
            for (int i = 1; i <= possibleRolls; i++) {
                currentRolls = 1 + recursiveMinimumRoll(size, chutes, ladders, space + i, spacesVisitedNow);
                minRolls = Math.min(minRolls, currentRolls);
            }
            return minRolls;
        }
    }
}
