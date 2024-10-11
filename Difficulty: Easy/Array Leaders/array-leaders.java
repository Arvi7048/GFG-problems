//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Array {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

        while (t-- > 0) {

            // input size of array
            int n = Integer.parseInt(br.readLine().trim());
            int arr[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");

            // inserting elements in the array
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            Solution obj = new Solution();

            StringBuffer str = new StringBuffer();
            ArrayList<Integer> res = new ArrayList<Integer>();

            // calling leaders() function
            res = obj.leaders(n, arr);

            for (int i = 0; i < res.size(); i++) {
                ot.print(res.get(i) + " ");
            }

            ot.println();
        }
        ot.close();
    }
}

// } Driver Code Ends


class Solution {
    // Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int n, int arr[]) {
       ArrayList<Integer> result = new ArrayList<>();
        int j = n - 1;
        
        // Traverse from the end of the array
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                result.add(arr[i]);
                continue;
            }
            if (arr[i] >= arr[j]) {
                result.add(arr[i]);
                j = i;
            }
        }

        // Reverse the result to maintain the correct order
        ArrayList<Integer> finalResult = new ArrayList<>();
        for (int i = result.size() - 1; i >= 0; i--) {
            finalResult.add(result.get(i));
        }

        return finalResult;
    }
    
}
