//{ Driver Code Starts
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());

        while (t-- > 0) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String token : tokens) {
                nums.add(Integer.parseInt(token));
            }

            Solution solution = new Solution();
            System.out.println(solution.pairWithMaxSum(nums));
        }

        scanner.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find pair with maximum sum
    public int pairWithMaxSum(List<Integer> arr) {
        int n = arr.size();
        if (n < 2) {
            // If the array has fewer than 2 elements, there's no pair, return Integer.MIN_VALUE or handle accordingly
            return Integer.MIN_VALUE;
        }

        int maxi = Integer.MIN_VALUE;
        
        // Loop through the array to find the sum of adjacent pairs
        for (int i = 0; i < n - 1; i++) {
            int sum = arr.get(i) + arr.get(i + 1); // sum of adjacent elements
            if (sum > maxi) {
                maxi = sum;
            }
        }

        return maxi;
        
    }
}