class Solution {
    public boolean stringStack(String pat, String tar) {
        int i = pat.length() - 1;
        int j = tar.length() - 1;

        while (i >= 0 && j >= 0) {
            if (pat.charAt(i) != tar.charAt(j)) {
                i -= 2;      // mismatch -> skip current pat char + one more (simulate delete)
            } else {
                i--;
                j--;
            }
        }

        return j < 0; // if we've matched all of tar
    }
}
