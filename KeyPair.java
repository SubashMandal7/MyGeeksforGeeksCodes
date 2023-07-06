class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            int complement = x - arr[i];
            if (set.contains(complement)) {
                return true;
            }
            set.add(arr[i]);
        }
        
        return false;
    }
}
