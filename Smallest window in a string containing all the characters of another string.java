class Solution {
    public static String smallestWindow(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        
        // Base case: if length of string s is smaller than length of string p.
        if (lenS < lenP) {
            return "-1";
        }
        
        // Frequency maps to keep track of characters in string p.
        HashMap<Character, Integer> freqP = new HashMap<>();
        for (char c : p.toCharArray()) {
            freqP.put(c, freqP.getOrDefault(c, 0) + 1);
        }
        
        // Variables to track the window.
        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int count = 0;  // Count of characters in string p found in string s.
        int minStart = 0;  // Starting index of the smallest window.
        
        // Traverse through string s.
        for (int end = 0; end < lenS; end++) {
            char curr = s.charAt(end);
            
            // Decrease the frequency of the character found in string s.
            if (freqP.containsKey(curr)) {
                freqP.put(curr, freqP.get(curr) - 1);
                
                // If the frequency becomes zero, it means a character of string p is found in string s.
                if (freqP.get(curr) >= 0) {
                    count++;
                }
            }
            
            // When all characters of string p are found in string s.
            if (count == lenP) {
                // Try to minimize the window size by moving the start pointer.
                while (!freqP.containsKey(s.charAt(start)) || freqP.get(s.charAt(start)) < 0) {
                    // Ignore characters that are not present in string p or have extra occurrences.
                    if (freqP.containsKey(s.charAt(start))) {
                        freqP.put(s.charAt(start), freqP.get(s.charAt(start)) + 1);
                    }
                    start++;
                }
                
                // Update the minimum window size and starting index.
                int windowLength = end - start + 1;
                if (windowLength < minLength) {
                    minLength = windowLength;
                    minStart = start;
                }
            }
        }
        
        // If no window found, return "-1".
        if (minLength == Integer.MAX_VALUE) {
            return "-1";
        }
        
        // Return the smallest window substring.
        return s.substring(minStart, minStart + minLength);
    }
}