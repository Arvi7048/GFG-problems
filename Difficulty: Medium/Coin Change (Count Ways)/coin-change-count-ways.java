class Solution {
    public int count(int coins[], int sum) {
        int n = coins.length;
        int[] dp = new int[sum + 1];

        dp[0] = 1; // There is 1 way to make sum 0 (use no coins)

        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[sum];
    }
}
