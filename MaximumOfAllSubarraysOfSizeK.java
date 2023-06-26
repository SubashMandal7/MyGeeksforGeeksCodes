class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        // Process the first k elements separately
        for (int i = 0; i < k; i++) {
            // Remove all elements smaller than the current element from the deque
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        // Process the remaining elements
        for (int i = k; i < n; i++) {
            // The front of the deque contains the maximum element of the previous subarray
            result.add(arr[deque.peekFirst()]);

            // Remove the elements outside the current window from the deque
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            // Remove all elements smaller than the current element from the deque
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }

            deque.addLast(i);
        }

        // Add the maximum element of the last subarray
        result.add(arr[deque.peekFirst()]);

        return result;
    }
}