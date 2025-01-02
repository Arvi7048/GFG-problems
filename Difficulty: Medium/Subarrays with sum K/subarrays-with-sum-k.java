//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
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
            int res = new Solution().countSubarrays(arr, k);

            System.out.print(res);
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public int countSubarrays(int arr[], int k) {
        // code here
         HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int currentSum = 0; // Current prefix sum
        int count = 0; // Count of subarrays with sum equal to k
        
        // Initialize the map with a default prefix sum of 0 (for cases where subarray starts from index 0)
        prefixSumMap.put(0, 1);
        
        // Iterate through the array
        for (int num : arr) {
            currentSum += num; // Update the prefix sum
            
            // Check if (currentSum - k) exists in the map
            if (prefixSumMap.containsKey(currentSum - k)) {
                count += prefixSumMap.get(currentSum - k); // Increment count by the frequency of (currentSum - k)
            }
            
            // Update the map with the current prefix sum
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}