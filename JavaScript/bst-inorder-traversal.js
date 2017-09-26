// Binary seach tree - in-order traversal
// return list of values in order  
function inOrderTraversal( tree ) {
  let currentNode = tree
  let stack = []
  let outputList = []

  // Loop through each tree node, depth first, left to right
  // while we are still looking at a real node or we have
  // more of them to look at
  while ( currentNode !== null || stack.length > 0 ) {
    // if we have a node, add it to the stack
    // and make the left child current, then continue
    if ( currentNode !== null ) {
      stack.push( currentNode )
      currentNode = currentNode.left
    }
    // otherwise, pop the stack, add it to the list
    // and make its right child current
    else if ( currentNode === null ) {
      let parent = stack.pop()
      outputList.push( parent.key )
      currentNode = parent.right
    }
  }
  
  return outputList
}


// Example tree with 2 at the root and the values 1, 2, 4, 5, 6
const exampleTree = {
  key: 2,
  left: {
    key: 1,
    left: null,
    right: null
  },
  right: {
    key: 5,
    left: {
      key: 4,
      left: null,
      right: null
    },
    right: {
      key: 6,
      left: null,
      right: null
    }
  }
}

console.log( inOrderTraversal( exampleTree ))
