//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
          // Initialize a map to store frequency of prefixXOR values
        HashMap<Integer, Integer> prefixXORFreq = new HashMap<>();
        
        long count = 0; // To store the result
        int prefixXOR = 0; // Initialize prefixXOR
        
        for (int num : arr) {
            // Update prefixXOR
            prefixXOR ^= num;
            
            // If prefixXOR itself is equal to k, increment count
            if (prefixXOR == k) {
                count++;
            }
            
            // Check if prefixXOR ^ k exists in the map
            int requiredXOR = prefixXOR ^ k;
            if (prefixXORFreq.containsKey(requiredXOR)) {
                count += prefixXORFreq.get(requiredXOR);
            }
            
            // Update the frequency of the current prefixXOR
            prefixXORFreq.put(prefixXOR, prefixXORFreq.getOrDefault(prefixXOR, 0) + 1);
        }
        
        return count;
    }
}