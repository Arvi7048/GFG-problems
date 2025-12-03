import java.util.*;

class Solution {

    private int n;
    private int[][] cost;
    private int[][] dp;
    private int VISITED_ALL;

    private int solve(int mask, int pos) {
        // If all cities have been visited, return cost to go back to city 0
        if (mask == VISITED_ALL) {
            return cost[pos][0];
        }

        if (dp[mask][pos] != -1) return dp[mask][pos];

        int ans = Integer.MAX_VALUE;

        // Try going to any unvisited city
        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) { // city not visited
                int newMask = mask | (1 << city);
                int nextCost = solve(newMask, city);
                if (nextCost != Integer.MAX_VALUE) {
                    ans = Math.min(ans, cost[pos][city] + nextCost);
                }
            }
        }

        return dp[mask][pos] = ans;
    }

    // Main function to be called
    public int tsp(int[][] cost) {
        this.n = cost.length;
        this.cost = cost;

        VISITED_ALL = (1 << n) - 1;
        dp = new int[1 << n][n];

        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start at city 0, having visited only city 0
        int startMask = 1;  // (1 << 0)
        return solve(startMask, 0);
    }
}
