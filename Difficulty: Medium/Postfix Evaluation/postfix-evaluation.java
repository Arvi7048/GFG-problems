import java.util.*;

class Solution {
    public int evaluatePostfix(String[] arr) {
        Stack<Long> st = new Stack<>();

        for (String token : arr) {
            if (token.equals("+") || token.equals("-") || token.equals("*") 
                    || token.equals("/") || token.equals("^")) {
                long b = st.pop();
                long a = st.pop();
                long res = 0;

                switch (token) {
                    case "+": res = a + b; break;
                    case "-": res = a - b; break;
                    case "*": res = a * b; break;
                    case "/": res = Math.floorDiv(a, b); break; // ✅ floor division
                    case "^": res = powLL(a, b); break;
                }
                st.push(res);
            } else {
                st.push(Long.parseLong(token));
            }
        }

        return st.peek().intValue();  // ✅ unbox Long properly
    }

    // fast power function for integer exponent
    private long powLL(long base, long exp) {
        if (exp < 0) {
            return (long) Math.pow((double) base, (double) exp);
        }
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res *= base;
            base *= base;
            exp >>= 1;
        }
        return res;
    }
}
