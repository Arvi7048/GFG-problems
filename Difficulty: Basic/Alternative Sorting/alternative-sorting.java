//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            ArrayList<Integer> array1 = new ArrayList<Integer>();
            String line = read.readLine();
            String[] tokens = line.split(" ");
            for (String token : tokens) {
                array1.add(Integer.parseInt(token));
            }
            ArrayList<Integer> v = new ArrayList<Integer>();
            int[] arr = new int[array1.size()];
            int idx = 0;
            for (int i : array1) arr[idx++] = i;

            v = new Solution().alternateSort(arr);

            for (int i = 0; i < v.size(); i++) System.out.print(v.get(i) + " ");

            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static ArrayList<Integer> alternateSort(int[] arr) {

        // Your code goes here
         Arrays.sort(arr);
        
        // Step 2: Create a result list
        ArrayList<Integer> result = new ArrayList<>();
        
        // Step 3: Use two pointers, one starting at the beginning and the other at the end
        int left = 0, right = arr.length - 1;
        
        // Step 4: Alternate between the largest and smallest elements
        while (left <= right) {
            if (left == right) {
                result.add(arr[left]); // Add the middle element if left equals right
            } else {
                result.add(arr[right]); // Add the largest element
                result.add(arr[left]);  // Add the smallest element
            }
            left++;
            right--;
        }
        
        return result;
    }
}
