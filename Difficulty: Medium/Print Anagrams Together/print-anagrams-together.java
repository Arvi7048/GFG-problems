//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
      // Map to group anagrams using their sorted form as the key
        Map<String, ArrayList<String>> anagramsMap = new LinkedHashMap<>();

        // Iterate over each string in the array
        for (String word : arr) {
            // Sort the characters of the word to create a key
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            // Add the word to the corresponding group
            anagramsMap.putIfAbsent(sortedWord, new ArrayList<>());
            anagramsMap.get(sortedWord).add(word);
        }

        // Prepare the result as an ArrayList of ArrayLists
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for (ArrayList<String> group : anagramsMap.values()) {
            // Add the group without altering the order of elements within the group
            result.add(group);
        }

        return result;
        // code here
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends