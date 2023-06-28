class Solution {
    int findKRotation(int arr[], int n) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            // If the array is already sorted, return 0
            if (arr[low] <= arr[high]) {
                return low;
            }

            int mid = low + (high - low) / 2;
            int next = (mid + 1) % n; // Get the next element

            // Check if mid+1 element is the minimum element
            if (arr[mid] <= arr[next] && arr[mid] <= arr[(mid - 1 + n) % n]) {
                return mid;
            }

            // If the left half is sorted, the pivot is in the right half
            if (arr[low] <= arr[mid]) {
                low = mid + 1;
            }
            // If the right half is sorted, the pivot is in the left half
            else if (arr[mid] <= arr[high]) {
                high = mid - 1;
            }
        }

        // No rotation found
        return 0;
    }
}