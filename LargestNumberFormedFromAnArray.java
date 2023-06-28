
class Solution {
    String printLargest(String[] arr) {
        // Sort the array using a custom comparator
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                // Compare the concatenated forms in descending order
                return order2.compareTo(order1);
            }
        });

        // Handle the case where the input array contains all zeros
        if (arr[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted numbers to form the largest number
        StringBuilder largestNumber = new StringBuilder();
        for (String num : arr) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }
}