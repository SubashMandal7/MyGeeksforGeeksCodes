class Solution {
    public int peakElement(int[] arr, int n) {
        int left = 0;
        int right = n - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // Check if mid is a peak element
            if (arr[mid] > arr[mid + 1])
                right = mid; // Move towards the left half
            else
                left = mid + 1; // Move towards the right half
        }

        // At the end of the loop, left will be pointing to a peak element
        return left;
    }
}
