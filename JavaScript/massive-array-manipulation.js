/* This problem seemed to be a simple array manipulation
   problem which I approached in an object-oriented fashion.
   However, the time constraints made this solution timeout
   due to an O(m*k) time complexity where k is the average
   number of array elements to change for each of the m
   operations. The size of the array (n) only enters the 
   equation for memory complexity and initialization time.
   k is a fraction of n so the time complexity could be 
   simplified to O(m*n).
   
   This solution creates an array of instructions for 
   creating the final array to avoid the actual array 
   manipulation. This results in a O(m+n) time complexity 
   where m is the number of operations and n is the size
   of the array - one pass through each.
 */

function arrayManipulation(n, queries) {
    // manipulations is an array of amounts to add
    // or subtract one by one to generate the final
    // value at each index; e.g. to get the value
    // at index 3, add the values at indeces 1, 2, & 3.
    // It's oversized so we can skip 0 for a 1-based-index.
    let manipulations = new Array(n+1)
    manipulations.fill(0)
    queries.forEach(query => {
        const [start, end, amount] = query
        manipulations[start] += amount
        if (end + 1 < manipulations.length) {
            manipulations[end + 1] -= amount
        }
    })
    let max = 0
    let amountAtIndex = 0
    for (let i = 1; i < manipulations.length; i++) {
        amountAtIndex += manipulations[i]
        max = Math.max(amountAtIndex, max)
    }
    
    return max
}
