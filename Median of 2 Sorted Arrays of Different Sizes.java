//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Driver {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = sc.nextInt();

            int m = sc.nextInt();
            int[] b = new int[m];
            for (int i = 0; i < m; i++)
                b[i] = sc.nextInt();

            double res = new GFG().medianOfArrays(n, m, a, b);

            if (res == (int) res)
                System.out.println((int) res);
            else
                System.out.println(res);
        }

    }
}
// } Driver Code Ends

// User function Template for Java

class GFG {
    static double medianOfArrays(int n, int m, int a[], int b[]) {
        // Ensure that the first array is always smaller or equal in size
        if (n > m) {
            return medianOfArrays(m, n, b, a);
        }

        int low = 0;
        int high = n;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (n + m + 1) / 2 - partitionX;

            // If partitionX is 0, it means nothing is there on the left side. Use
            // Integer.MIN_VALUE for maxLeftX
            // If partitionX is equal to n, it means nothing is there on the right side. Use
            // Integer.MAX_VALUE for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : a[partitionX - 1];
            int minRightX = (partitionX == n) ? Integer.MAX_VALUE : a[partitionX];

            // If partitionY is 0, it means nothing is there on the left side. Use
            // Integer.MIN_VALUE for maxLeftY
            // If partitionY is equal to m, it means nothing is there on the right side. Use
            // Integer.MAX_VALUE for minRightY
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY - 1];
            int minRightY = (partitionY == m) ? Integer.MAX_VALUE : b[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // We have found the correct partition
                // If the total number of elements is odd, the median is the maximum element on
                // the left side
                // If the total number of elements is even, the median is the average of the
                // maximum element on the left side and the minimum element on the right side
                if ((n + m) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                // We are too far on the right side for partitionX, go left
                high = partitionX - 1;
            } else {
                // We are too far on the left side for partitionX, go right
                low = partitionX + 1;
            }
        }

        // If we reach here, it means the arrays are not sorted or contain invalid
        // inputs
        throw new IllegalArgumentException("Invalid input arrays");
    }

    public static void main(String[] args) {
        int[] array1 = { 1, 5, 9 };
        int[] array2 = { 2, 3, 6, 7 };

        int m = array1.length;
        int n = array2.length;

        double median = medianOfArrays(m, n, array1, array2);
        System.out.println("Median: " + median);
    }
}
