public class Solution {
    public int minCost(int[][] costs) {
        if (costs == null) return 0;
        int n = costs.length;
        if (n == 0) return 0;
        int k = costs[0].length;
        if (k == 0) return -1;           // no colors but walls exist
        if (k == 1 && n > 1) return -1;  // impossible to avoid same adjacent color

        // Initialize first row: find min and second min
        int prevMin1 = Integer.MAX_VALUE, prevMin2 = Integer.MAX_VALUE;
        int prevMinColor = -1;

        for (int c = 0; c < k; c++) {
            int cost = costs[0][c];
            if (cost < prevMin1) {
                prevMin2 = prevMin1;
                prevMin1 = cost;
                prevMinColor = c;
            } else if (cost < prevMin2) {
                prevMin2 = cost;
            }
        }

        // Process subsequent rows
        for (int i = 1; i < n; i++) {
            int curMin1 = Integer.MAX_VALUE, curMin2 = Integer.MAX_VALUE;
            int curMinColor = -1;

            for (int c = 0; c < k; c++) {
                int bestPrev = (c == prevMinColor) ? prevMin2 : prevMin1;
                // If bestPrev is still MAX_VALUE, it means impossible path, skip will produce overflow, handle safely:
                if (bestPrev == Integer.MAX_VALUE) {
                    continue;
                }
                int currCost = bestPrev + costs[i][c];

                if (currCost < curMin1) {
                    curMin2 = curMin1;
                    curMin1 = currCost;
                    curMinColor = c;
                } else if (currCost < curMin2) {
                    curMin2 = currCost;
                }
            }

            // If no valid color was found for this row, impossible
            if (curMin1 == Integer.MAX_VALUE) return -1;

            prevMin1 = curMin1;
            prevMin2 = curMin2;
            prevMinColor = curMinColor;
        }

        return prevMin1;
    }

}
