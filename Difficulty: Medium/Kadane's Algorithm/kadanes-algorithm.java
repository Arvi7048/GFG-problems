//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.maxSubarraySum(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {

    // arr: input array
    // Function to find the sum of contiguous subarray with maximum sum.
    int maxSubarraySum(int[] arr) {

        // Your code here
          // Initialize maxSum and currentSum to the first element of the array
        int maxSum = arr[0];
        int currentSum = arr[0];
        
        // Start iterating from the second element
        for (int i = 1; i < arr.length; i++) {
            // Update currentSum: either extend the existing subarray or start a new subarray
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            
            // Update maxSum if currentSum is greater than maxSum
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
