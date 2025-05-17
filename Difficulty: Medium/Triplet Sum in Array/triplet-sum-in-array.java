//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim()); // Read number of test cases

        while (t-- > 0) {
            String line = read.readLine().trim(); // Read the array input
            String[] numsStr = line.split(" ");   // Split the input string by spaces
            int[] nums =
                new int[numsStr.length]; // Convert string array to integer array
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            int target = Integer.parseInt(read.readLine().trim()); // Read target sum

            Solution ob = new Solution();
            boolean ans =
                ob.hasTripletSum(nums, target); // Call the function and store result
            System.out.println(ans ? "true" : "false"); // Output the result
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Should return true if there is a triplet with sum equal
    // to x in arr[], otherwise false
    public static boolean hasTripletSum(int arr[], int t) {
        int n = arr.length;
        Arrays.sort(arr);
        //List<List<Integer>> ans = new ArrayList<>();

    for(int i =0; i<n-2; i++){
    if(i>0 && arr[i] == arr[i-1]) continue; 
    int j = i+1 ,  k= n-1;
        while(j<k){
    int sum = arr[i]+arr[j]+arr[k];
    if(sum<t){
        j++;
    }
    else if(sum>t){
        k--;
    }else{
       // ans.add(Arrays.asList(arr[i],arr[j], arr[k]));
       return true;
      

      
        }
    }

   }
   return false;

        
    }
}
