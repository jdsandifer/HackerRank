class DataStructures {

// Write checkBST() to return true if the binary tree starting with root is
// a binary search tree: left node < this node < right node && no duplicates

// Directions / code info:
/* Hidden stub code will pass a root argument to the function below.
   Complete the function to solve the challenge. Hint: you may want 
   to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

    boolean checkBST(Node root) {
        // create a list
        LinkedList<Integer> dataInOrder = new LinkedList<Integer>();
    
        // recursively add to the list in order - left side, current, right side
        recursiveListAdd(root, dataInOrder);
       
        // run through list and confirm increasing order
        return confirmListIncreases(dataInOrder);
    }

    void recursiveListAdd(Node thisNode, LinkedList<Integer> dataInOrder) {
        if (thisNode.left != null) {
            recursiveListAdd(thisNode.left, dataInOrder);
        }
        dataInOrder.addLast(thisNode.data);
        if (thisNode.right != null) {
            recursiveListAdd(thisNode.right, dataInOrder);
        }
    }

    boolean confirmListIncreases(LinkedList<Integer> dataList) {
        ListIterator<Integer> iterator = dataList.listIterator(0);
        int currentValue = iterator.next();
        int nextValue;
        
        while (iterator.hasNext()) {
            nextValue = iterator.next();
            
            // Ensure current value is less than the next
            if (currentValue >= nextValue) {
                return false;
            }
            
            currentValue = nextValue;
        }
        
        return true;
    }

}