class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        // code here
         int n = arr.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        Deque<Integer> dq = new ArrayDeque<>();
        long ans = Long.MIN_VALUE;

        for (int r = a; r <= n; r++) {
            // Add l = r - a into window
            int l = r - a;
            while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[l]) {
                dq.pollLast();
            }
            dq.addLast(l);

            // Remove indices out of window size b
            while (!dq.isEmpty() && dq.peekFirst() < r - b) {
                dq.pollFirst();
            }

            // Best subarray ending at r-1
            ans = Math.max(ans, prefix[r] - prefix[dq.peekFirst()]);
        }

        return (int) ans;
        
    }
}