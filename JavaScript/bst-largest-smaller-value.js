// Given a Binary Seach Tree of numbers
// with nodes that look like this:
function Node( key ) {
  this.key = key;
  this.parent = null;
  this.left = null;
  this.right = null;
}

// and a constructor that looks like this:
function BinarySearchTree() {
  this.root = null;
}

// Create a BST method to find the largest value
// in the tree that is less than a given value

// Asymptotic complexity:
// The BST provides for O( log n ) searches in 
// the average case and O( n ) in the worst case.
// This algorithm does one search so it has
// those runtimes. Memory usage is O( 1 ).

// Returns value if a value exists or -1 if not
BinarySearchTree.prototype.findLargestSmallerKey = function( num ) {
  let currentNode = this.root
  let bestValue = -1  // return value if no suitable value is found
  
  // do one search down the BST until we reach a leaf node
  while ( currentNode !== null ) {
    // because each new value we look at is guaranteed to be greater than the last one
    // there's no need to check whether it is or not, just that it's less than num
    let currentNodeIsNewBestValue = currentNode.key < num
    if ( currentNodeIsNewBestValue ) {
      bestValue = currentNode.key
    }
    
    // decide which branch to take next
    if ( currentNode.key < num) {
      // go right
      currentNode = currentNode.right
    } else if ( currentNode.key >= num) {
      // go left
      currentNode = currentNode.left
    }
  }
  
  // we reached a leaf - there are no better values 
  // in the BST than the last one we found
  return bestValue
}
