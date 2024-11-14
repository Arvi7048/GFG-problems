//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // testcases
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {

            // size of array
            int N = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[N];
            String inputLine[] = br.readLine().trim().split(" ");

            // adding elements to the array
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            int P = Integer.parseInt(br.readLine().trim());
            // calling frequncycount() function
            Solution ob = new Solution();
            ob.frequencyCount(arr, N, P);

            // printing array elements
            for (int i = 0; i < N; i++) System.out.print(arr[i] + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int n, int p) {
        // do modify in the given array
        // Step 1: Create a frequency array to store counts of numbers from 1 to n
        // We only need to count numbers from 1 to n, so we initialize the frequency array to 0
        int[] frequency = new int[n];

        // Step 2: Traverse the given array and count the occurrences of numbers in range [1, n]
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= n) {
                frequency[arr[i] - 1]++; // Increment count for the number `arr[i]`
            }
        }

        // Step 3: Modify the original array to hold the frequency of each number
        for (int i = 0; i < n; i++) {
            arr[i] = frequency[i]; // Set the frequency of number i+1 in the array
        }
    }
}
