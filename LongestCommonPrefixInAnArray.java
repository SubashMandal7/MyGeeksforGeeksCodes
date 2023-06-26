public class Solution {
    public static String longestCommonPrefix(String[] arr, int n) {
        if (n == 0) {
            return "-1";
        }

        String prefix = arr[0];
        for (int i = 1; i < n; i++) {
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "-1";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        int n = 4;
        String[] arr = { "geeksforgeeks", "geeks", "geek", "geezer" };

        String result = longestCommonPrefix(arr, n);
        System.out.println("Longest common prefix: " + result);
    }
}
