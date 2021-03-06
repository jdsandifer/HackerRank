// Solving for minimum rolls to complete the Chutes and Ladders game.
// This problem is from HackerRank.com, uses a 10x10 board, and refers
// to the game using its original name of Snakes and Ladders.

// I started solving this problem through whiteboarding, then I tested
// the solution in the HackerRank app, and started tweaking it to make
// it work and solve all the test cases.

import java.lang.Math;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import java.util.Scanner;

public class Solution {
    public static int[] rollsCalculated = new int[101];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        err("test cases: " + testCases);
        for (int t = 1; t <= testCases; t++) {
            Arrays.fill(rollsCalculated, -1);
            int ladderCount = input.nextInt();
            err("ladder count: " + ladderCount);
            Map<Integer, Integer> ladders = new HashMap<>();
            for (int l = 1; l <= ladderCount; l++) {
                ladders.put(input.nextInt(), input.nextInt());
            }
            err("ladders: " + ladders);
            
            int chuteCount = input.nextInt();
            err("chute count: " + chuteCount);
            Map<Integer, Integer> chutes = new HashMap<>();
            for (int l = 1; l <= chuteCount; l++) {
                chutes.put(input.nextInt(), input.nextInt());
            }
            err("chutes: " + chutes);
            
            int answer = recursiveMinimumRolls(10, chutes, ladders, 1, new HashSet());
            answer = (answer == Integer.MAX_VALUE) ? -1 : answer;
            System.out.println(answer);
            for (int i = 1; i <= 10; i++) {
                System.err.print(((i-1)*10+1) + ": ");
                for (int j = 1; j <= 10; j++) {
                    System.err.print(rollsCalculated[i] + ", ");
                }
                System.err.println();
            }
        }
    }
    
    public static int recursiveMinimumRolls(
            int size, 
            Map<Integer, Integer> chutes, 
            Map<Integer, Integer> ladders, 
            int space, 
            Set<Integer> spacesVisited) {
        if (rollsCalculated[space] != -1) {
            return rollsCalculated[space];
        }
        final Set spacesVisitedNow = new HashSet(spacesVisited);
        spacesVisitedNow.add(space);
        if (space == size * size) {
            err("last space; path: " + spacesVisitedNow);
            return addToArray(0, space);
        }
        else if (chutes.containsKey(space) && !spacesVisited.contains(chutes.get(space))) {
            return addToArray(recursiveMinimumRolls(size, chutes, ladders, chutes.get(space), spacesVisitedNow), space);
        }
        else if (chutes.containsKey(space) && spacesVisited.contains(chutes.get(space))) {
            err("caught a chute loop");
            return addToArray(Integer.MAX_VALUE, space);
        }
        else if (ladders.containsKey(space) && !spacesVisited.contains(ladders.get(space))) {
            return addToArray(recursiveMinimumRolls(size, chutes, ladders, ladders.get(space), spacesVisitedNow), space);
        }
        else if (ladders.containsKey(space) && spacesVisited.contains(ladders.get(space))) {
            err("caught a ladder loop");
            return addToArray(Integer.MAX_VALUE, space);
        }
        else {
            int minRolls = Integer.MAX_VALUE;
            int currentRolls = Integer.MAX_VALUE;
            int possibleRolls = Math.min(6, (size * size) - space);
            for (int i = 1; i <= possibleRolls; i++) {
                int nextSpaceRolls = recursiveMinimumRolls(size, chutes, ladders, space + i, spacesVisitedNow);
                if (nextSpaceRolls == Integer.MAX_VALUE)
                    currentRolls = nextSpaceRolls;
                else
                    currentRolls = 1 + nextSpaceRolls;
                minRolls = Math.min(minRolls, currentRolls);
            }
            return addToArray(minRolls, space);
        }
    }
    
    public static int addToArray(int newValue, int index) {
        if (rollsCalculated[index] == -1) {
            rollsCalculated[index] = newValue;
        }
        else {
            rollsCalculated[index] = Math.min(newValue, rollsCalculated[index]);
        }
        return rollsCalculated[index];
    }
    
    public static void err(String message) {
        System.err.println(message);
    }
}
