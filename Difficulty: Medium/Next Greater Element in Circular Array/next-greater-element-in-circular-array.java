import java.util.*;

class Solution {
    public ArrayList<Integer> nextGreater(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1); // default -1 if no greater element exists

        Stack<Integer> stack = new Stack<>(); // stores indices

        // Traverse twice for circular array
        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;

            // Pop all elements smaller than arr[index]
            while (!stack.isEmpty() && arr[index] > arr[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = arr[index];
            }

            // Only push first pass indices
            if (i < n) {
                stack.push(index);
            }
        }

        // Convert array to ArrayList
        ArrayList<Integer> result = new ArrayList<>();
        for (int val : res) result.add(val);

        return result;
    }
}
