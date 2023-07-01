class Solution {

    // Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        int maxSubarraySum = kadane(a, n);

        if (maxSubarraySum < 0) {
            return maxSubarraySum; // In case all elements are negative, return the maximum subarray sum.
        }

        int totalSum = 0;
        for (int num : a) {
            totalSum += num;
        }

        // Negate each element of the array.
        for (int i = 0; i < n; i++) {
            a[i] = -a[i];
        }

        int maxCircularSum = totalSum + kadane(a, n);

        return Math.max(maxSubarraySum, maxCircularSum);
    }

    // Function to find the maximum subarray sum using Kadane's algorithm.
    private static int kadane(int a[], int n) {
        int maxSoFar = a[0];
        int maxEndingHere = a[0];

        for (int i = 1; i < n; i++) {
            maxEndingHere = Math.max(a[i], maxEndingHere + a[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
