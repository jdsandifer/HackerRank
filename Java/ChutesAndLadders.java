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
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int ladderCount = input.nextInt();
            Map<Integer, Integer> ladders = new HashMap<>();
            for (int l = 1; l <= ladderCount; l++) {
                ladders.put(input.nextInt(), input.nextInt());
            }
            
            int chuteCount = input.nextInt();
            Map<Integer, Integer> chutes = new HashMap<>();
            for (int l = 1; l <= chuteCount; l++) {
                chutes.put(input.nextInt(), input.nextInt());
            }
            
            int answer = recursiveMinimumRolls(10, chutes, ladders, 1, new HashSet());
            answer = (answer == Integer.MAX_VALUE) ? -1 : answer;
            System.out.println(answer);
        }
    }
    
    public static int recursiveMinimumRolls(
            int size, 
            Map<Integer, Integer> chutes, 
            Map<Integer, Integer> ladders, 
            int space, 
            Set<Integer> spacesVisited) {
        Set spacesVisitedNow = new HashSet(spacesVisited);
        spacesVisitedNow.add(space);
        if (space == size * size)
            return 0;
        else if (chutes.containsKey(space) && !spacesVisited.contains(chutes.get(space)))
            return recursiveMinimumRolls(size, chutes, ladders, chutes.get(space), spacesVisitedNow);
        else if (chutes.containsKey(space) && spacesVisited.contains(chutes.get(space)))
            return Integer.MAX_VALUE;
        else if (ladders.containsKey(space) && !spacesVisited.contains(ladders.get(space)))
            return recursiveMinimumRolls(size, chutes, ladders, ladders.get(space), spacesVisitedNow);
        else if (ladders.containsKey(space) && spacesVisited.contains(ladders.get(space)))
            return Integer.MAX_VALUE;
        else {
            int minRolls = Integer.MAX_VALUE;
            int currentRolls = Integer.MAX_VALUE;
            int possibleRolls = Math.min(6, (size * size) - space);
            for (int i = 1; i <= possibleRolls; i++) {
                currentRolls = 1 + recursiveMinimumRolls(size, chutes, ladders, space + i, spacesVisitedNow);
                minRolls = Math.min(minRolls, currentRolls);
            }
            return minRolls;
        }
    }
}
