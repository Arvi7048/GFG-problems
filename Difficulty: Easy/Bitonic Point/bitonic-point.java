// User function Template for Java

class Solution {
    public int findMaximum(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Handle boundary elements safely
            if ((mid == 0 || arr[mid - 1] < arr[mid]) &&
                (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return arr[mid];
            }

            // Move right if the next element is greater (increasing part)
            if (mid < arr.length - 1 && arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else { // Move left otherwise
                right = mid - 1;
            }
        }

        return -1; // Should not happen for a valid bitonic array
    }
}
