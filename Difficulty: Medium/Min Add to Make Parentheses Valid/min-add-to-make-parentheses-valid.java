class Solution {
    public int minParentheses(String s) {
        int balance = 0;     // unmatched "("
        int insertions = 0;  // needed "(" for unmatched ")"
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else { // ch == ')'
                if (balance > 0) {
                    balance--; // match with previous "("
                } else {
                    insertions++; // need an extra "("
                }
            }
        }
        
        return insertions + balance;
    }
}
