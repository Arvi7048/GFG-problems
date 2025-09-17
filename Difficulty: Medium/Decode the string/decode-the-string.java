import java.util.*;

class Solution {
    static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0'); // handle multi-digit numbers
            } else if (c == '[') {
                countStack.push(k);
                stringStack.push(curr);
                k = 0;
                curr = new StringBuilder();
            } else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decoded.append(curr);
                }
                curr = decoded;
            } else {
                curr.append(c);
            }
        }

        return curr.toString();
    }
}
