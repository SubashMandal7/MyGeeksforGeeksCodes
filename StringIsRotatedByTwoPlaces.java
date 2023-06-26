public class Solution {
    public static boolean isRotated(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        // If lengths are not equal, strings cannot be rotated to form each other
        if (lenA != lenB)
            return false;

        // Handle case when length is less than 2
        if (lenA < 2)
            return a.equals(b);

        // Check if rotating clockwise by 2 places gives string b
        String clockRotated = a.substring(2) + a.substring(0, 2);
        if (clockRotated.equals(b))
            return true;

        // Check if rotating anti-clockwise by 2 places gives string b
        String antiClockRotated = a.substring(lenA - 2) + a.substring(0, lenA - 2);
        if (antiClockRotated.equals(b))
            return true;

        return false;
    }

    public static void main(String[] args) {
        String a = "amazon";
        String b = "azonam";
        System.out.println(isRotated(a, b)); // Output: true

        a = "geeksforgeeks";
        b = "geeksgeeksfor";
        System.out.println(isRotated(a, b)); // Output: false
    }
}