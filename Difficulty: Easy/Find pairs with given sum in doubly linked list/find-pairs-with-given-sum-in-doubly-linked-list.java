/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;

    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
        public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head)  {
        // 1. Initialize the list to store the results.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // 2. Handle edge cases: if the list is empty or has only one node, no pairs can be formed.
        if (head == null || head.next == null) {
            return result;
        }

        // 3. Setup two pointers. 'left' starts at the head.
        Node left = head;
        // 'right' starts at the tail.
        Node right = head;
        while (right.next != null) {
            right = right.next;
        }

        // 4. Loop until the pointers meet or cross.
        while (left != right && left.prev != right) {
            int currentSum = left.data + right.data;

            if (currentSum == target) {
                // Found a pair!
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left.data);
                pair.add(right.data);
                result.add(pair);

                // Move both pointers inward to find the next potential unique pair.
                left = left.next;
                right = right.prev; // <<< LOGICAL FIX: move right pointer backward
                
            } else if (currentSum < target) {
                // Sum is too small, need a larger value. Move left pointer forward.
                left = left.next;
                
            } else { // currentSum > target
                // Sum is too large, need a smaller value. Move right pointer backward.
                right = right.prev;
            }
        }

        // 5. Return the list of found pairs.
        return result;
    }

        
    
}
