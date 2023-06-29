class Solution {
    // Function to check if the linked list has a loop.
    public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast pointers meet, there is a loop.
            if (slow == fast)
                return true;
        }

        // If the loop is not found, return false.
        return false;
    }
}
