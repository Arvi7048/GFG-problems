//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int d = Integer.parseInt(read.readLine().trim());

            Solution ob = new Solution();
            ArrayList<Integer> result = ob.subarraySum(nums, d);
            // Print all elements in the result list
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println(); // Print a new line after the result
        }
    }
}

// } Driver Code Ends



class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
           int start = 0;
        int currentSum = 0;
        
        for (int end = 0; end < arr.length; end++) {
            // Add the current element to the running sum
            currentSum += arr[end];
            
            // While the current sum exceeds the target, shrink the window from the left
            while (currentSum > target && start <= end) {
                currentSum -= arr[start];
                start++;
            }
            
            // Check if the current sum matches the target
            if (currentSum == target) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(start + 1); // 1-based index for the start
                result.add(end + 1);   // 1-based index for the end
                return result;
            }
        }
        
        // No subarray found
        ArrayList<Integer> noResult = new ArrayList<>();
        noResult.add(-1);
        return noResult;
    }
}
