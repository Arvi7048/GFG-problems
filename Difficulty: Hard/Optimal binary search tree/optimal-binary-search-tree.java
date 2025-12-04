class Solution {
    public int minCost(int keys[], int freq[]) {
        int n = keys.length;
        if (n == 0) return 0;
        // dp[i][j] = minimum cost for keys[i..j]
        int[][] dp = new int[n][n];

        // prefixFreq[k] = sum of freq[0..k-1]
        int[] prefixFreq = new int[n + 1];
        for (int i = 0; i < n; i++) prefixFreq[i + 1] = prefixFreq[i] + freq[i];

        // Helper: sum of freq[i..j] = prefixFreq[j+1] - prefixFreq[i]
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                int sumFreq = prefixFreq[j + 1] - prefixFreq[i];

                int best = Integer.MAX_VALUE;
                // try every key k in [i..j] as root
                for (int k = i; k <= j; k++) {
                    int leftCost = (k > i) ? dp[i][k - 1] : 0;
                    int rightCost = (k < j) ? dp[k + 1][j] : 0;
                    int total = leftCost + rightCost + sumFreq;
                    if (total < best) best = total;
                }

                dp[i][j] = best == Integer.MAX_VALUE ? 0 : best;
            }
        }
        return dp[0][n - 1];
    }
}
