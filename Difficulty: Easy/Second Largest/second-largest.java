//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        // Iterate through the array to find the largest and second largest elements
        for (int num : arr) {
            if (num > firstLargest) {
                // Update secondLargest before updating firstLargest
                secondLargest = firstLargest;
                firstLargest = num;
            } else if (num > secondLargest && num != firstLargest) {
                // Update secondLargest only if it's different from firstLargest
                secondLargest = num;
            }
        }
        
        // If secondLargest is still Integer.MIN_VALUE, return -1 (no valid second largest element)
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }
}