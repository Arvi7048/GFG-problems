import java.util.*;

class Solution {
    
    public static long maxScore(String s, char[][] jumps) {
        int n = s.length();
        final int A = 26;
        final long NEG_INF = Long.MIN_VALUE / 4;  // safe -infinity

        // Map jumps: allowed[c1][c2] = true if we can jump from char c1 to c2
        boolean[][] allowed = new boolean[A][A];

        for (int i = 0; i < jumps.length; i++) {
            char from = jumps[i][0];
            char to   = jumps[i][1];
            int a = from - 'a';
            int b = to   - 'a';
            if (a >= 0 && a < A && b >= 0 && b < A) {
                allowed[a][b] = true;
            }
        }

        // same-character jumps always allowed
        for (int c = 0; c < A; c++) {
            allowed[c][c] = true;
        }

        // prefix sums
        long[] prefAll = new long[n + 1];     // sum of ASCII codes
        int[][] prefCnt = new int[n + 1][A];  // count of each char

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            prefAll[i + 1] = prefAll[i] + (int) ch;

            // copy previous counts
            for (int c = 0; c < A; c++) {
                prefCnt[i + 1][c] = prefCnt[i][c];
            }
            if (idx >= 0 && idx < A) {
                prefCnt[i + 1][idx]++;
            }
        }

        long[] dp = new long[n];
        Arrays.fill(dp, NEG_INF);
        dp[0] = 0;  // start at index 0 with score 0

        long[] bestForDest = new long[A];
        Arrays.fill(bestForDest, NEG_INF);

        // Use index 0 as source to initialize bestForDest
        int src0 = s.charAt(0) - 'a';
        if (src0 >= 0 && src0 < A) {
            for (int d = 0; d < A; d++) {
                if (allowed[src0][d]) {
                    long val = dp[0] - prefAll[0]
                             + (long) ('a' + d) * prefCnt[0][d];
                    if (val > bestForDest[d]) {
                        bestForDest[d] = val;
                    }
                }
            }
        }

        long ans = 0;  // if no jump possible, answer is 0

        // Process positions 1..n-1 as possible destinations
        for (int j = 1; j < n; j++) {
            char ch = s.charAt(j);
            int dest = ch - 'a';
            long asciiDest = (long) ch;

            if (dest >= 0 && dest < A && bestForDest[dest] > NEG_INF / 2) {
                // dp[j] = bestForDest[dest] + (prefAll[j] - asciiDest * cnt(dest in [0..j-1]))
                dp[j] = bestForDest[dest]
                        + (prefAll[j]
                        - asciiDest * (long) prefCnt[j][dest]);

                if (dp[j] > ans) {
                    ans = dp[j];
                }
            }

            // If j is reachable, use it as a new source
            if (dest >= 0 && dest < A && dp[j] > NEG_INF / 2) {
                int src = dest;
                for (int d = 0; d < A; d++) {
                    if (allowed[src][d]) {
                        long val = dp[j] - prefAll[j]
                                 + (long) ('a' + d) * prefCnt[j][d];
                        if (val > bestForDest[d]) {
                            bestForDest[d] = val;
                        }
                    }
                }
            }
        }

        return ans;
    }
}
