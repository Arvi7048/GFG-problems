//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);

            // Ensure input is read correctly
            inputLine = br.readLine().trim().split(" ");
            if (inputLine == null || inputLine.length == 0) {
                System.out.println("Invalid input");
                continue;
            }

            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().getMinDiff(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int getMinDiff(int[] arr, int k) {
        // code here
         int n = arr.length;
        if (n == 1) {
            return 0; // If there's only one tower, no difference
        }

        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Initial maximum difference between the tallest and shortest
        int answer = arr[n - 1] - arr[0];

        // Step 3: Initialize the smallest and largest values
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;

        // Step 4: Iterate through the array and calculate potential minimum differences
        for (int i = 0; i < n - 1; i++) {
            int minHeight = Math.min(smallest, arr[i + 1] - k);
            int maxHeight = Math.max(largest, arr[i] + k);
            if (minHeight < 0) continue; // Ignore negative heights
            answer = Math.min(answer, maxHeight - minHeight);
        }

        return answer;
    }
}
