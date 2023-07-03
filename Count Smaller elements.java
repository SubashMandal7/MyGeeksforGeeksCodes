class Solution {
    private static class Pair {
        int value, index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] constructLowerArray(int[] arr, int n) {
        int[] count = new int[n];
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i);
        }

        mergeSort(pairs, count, 0, n - 1);

        return count;
    }

    private void mergeSort(Pair[] pairs, int[] count, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(pairs, count, left, mid);
        mergeSort(pairs, count, mid + 1, right);
        merge(pairs, count, left, mid, right);
    }

    private void merge(Pair[] pairs, int[] count, int left, int mid, int right) {
        Pair[] temp = new Pair[right - left + 1];
        int i = left, j = mid + 1, k = 0, smallerCount = 0;

        while (i <= mid && j <= right) {
            if (pairs[i].value <= pairs[j].value) {
                count[pairs[i].index] += smallerCount;
                temp[k++] = pairs[i++];
            } else {
                smallerCount++;
                temp[k++] = pairs[j++];
            }
        }

        while (i <= mid) {
            count[pairs[i].index] += smallerCount;
            temp[k++] = pairs[i++];
        }

        while (j <= right) {
            temp[k++] = pairs[j++];
        }

        System.arraycopy(temp, 0, pairs, left, temp.length);
    }
}