class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S) {
        // Create a hashmap to store the frequency of each character.
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Traverse the string and count the frequency of each character.
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Traverse the string again and return the first character with frequency 1.
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (frequencyMap.get(ch) == 1) {
                return ch;
            }
        }

        // If there is no non-repeating character, return '$'.
        return '$';
    }

    // Test the code with example inputs
    public static void main(String[] args) {
        String S1 = "hello";
        System.out.println("First non-repeating character in \"" + S1 + "\": " + nonrepeatingCharacter(S1));

        String S2 = "zxvczbtxyzvy";
        System.out.println("First non-repeating character in \"" + S2 + "\": " + nonrepeatingCharacter(S2));
    }
}
