import java.util.Arrays;

class Solution {
    // Function to check whether two strings are anagram of each other
    public static boolean areAnagrams(String s1, String s2) {
        // If lengths are different, they can't be anagrams
        if (s1.length() != s2.length()) return false;

        int[] count = new int[26]; // Assuming lowercase letters a-z

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}
