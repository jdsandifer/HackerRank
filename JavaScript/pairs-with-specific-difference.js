// Problem (from Pramp.com):
// Find all pairs in an array of distinct integers
// such that their difference equals a specific 
// non-negative integer k


// Asymptotic complexity:
// - This solution uses a sort at the beginning which is most likely
//   implemented as a MergeSort or QuickSort depending on the environment
//   Runtime is average O( n log n ), potentially O( n ) best case 
//   and O( n^2 ) worst case 
//   Memory is up to O( n ), potentially O( log n )
// - Those limits dominate over the actual algorithm which
//   is only O( n ) runtime - only one trip through the array -
//   and O( 1 ) memory - excluding the output array.


// Assume k is an integer greater than or equal to 0
function findPairsWithGivenDifference( integers, k ) {
  // Array can have less than two values so deal with that first
  // Can't have a pair if there are less than two distinct values
  if ( integers.length < 2 ) {
    return []
  }
  
  // sort array ascending
  integers.sort( (a,b) => a - b )
  
  let firstIndex = 0
  let secondIndex = 1
  let pairs = []
  
  // move through the array until we go past the last value
  while ( secondIndex < integers.length ) {
    let difference = integers[ secondIndex ] - integers[ firstIndex ]
    
    // if the difference between the two values at our indexes is less than k OR 
    // the indexes are equal, increase the second index to increase the difference
    // have to check both as k could be 0
    if ( difference < k || firstIndex === secondIndex ) {
      secondIndex++
    }
    
    // if the difference is equal to k, add the pair to the pairs array 
    // and increment both indexes (neither can be in another pair)
    // because all integers are distinct
    else if ( difference === k ) {
      let firstValue = integers[ firstIndex ]
      let secondValue = integers[ secondIndex ]
      pairs.push( [ secondValue, firstValue ] )
      
      firstIndex++
      secondIndex++
    }
  
    // if the difference is more than k, 
    // increase the first index to decrease the difference
    else if ( difference > k ) {
      firstIndex++
    }  
  }
  
  return pairs
}
