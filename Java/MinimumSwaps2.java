public class MinimumSwaps2 {

    // Given an array of unique whole numbers 1...n where n is the length of the array,
    // find the minimum number of swaps needed to place the numbers in ascending order.
    //
    // For this problem I chose not to mutate the array although doing so could have
    // reduced space complexity from O(k) additional space to O(1). (Where k is the 
    // number of swaps needed. 0 <= k < n as max swaps needed is one less than n.)
    //
    // Time complexity is O(n) as the maximum iterations for the inner loop is n - 1 but
    // that length guarantees every other iteration of the outer loop causes the inner loop
    // to be skipped. In short, the average length of the inner loop is constant 
    // with respect to n.
    //
    static int minimumSwaps(int[] arr) {
        int swapsNeeded = 0;
        Set<Integer> swappedIndeces = new HashSet<>(); // will hold 1-based indeces
        
        // Go through the array one item at a time
        for (int index = 1; index <= arr.length; index++) {
        
            // For each, is it in the right place OR
            // do we already know it needs to be swapped?
            boolean inSpot = arr[index - 1] == index;
            boolean swappedAlready = swappedIndeces.contains(index);
            
            if (inSpot || swappedAlready) {
                // If so, do nothing - continue going through the array
                continue;
            }
            
            int swapIndex = index;
            inSpot = arr[swapIndex - 1] == swapIndex;
            swappedAlready = swappedIndeces.contains(swapIndex);

            // If not, follow the "path" of swapping indeces until
            // we complete a series of swaps.
            while (!inSpot && !swappedAlready) {
                // Count each swap needed,
                swapsNeeded += 1;
                // and add the index to the swap set.
                swappedIndeces.add(swapIndex);

                // Then use the value here as an index to find where we should swap.
                // Keep going until we hit a value that leads to an index 
                // we've already considered.
                swapIndex = arr[swapIndex - 1];
                inSpot = arr[swapIndex - 1] == swapIndex;
                swappedAlready = swappedIndeces.contains(swapIndex);
            }

            // Subtract one for the last swap - a mutual swap 
            // which is counted twice in this algorithm.
            swapsNeeded -= 1;
        }
        
        return swapsNeeded;
    }
    
}
