import java.util.HashSet;

public class LinkedListCycle {

    public static boolean isCycle(ListNode node) {
        if (node == null || node.next == null) {
            return false;
        }

        ListNode current = node;
        HashSet<ListNode> seen = new HashSet<>();

        while (current != null) {
            if (seen.contains(current)) {
                return true;
            }
            seen.add(current);
            current = current.next;
        }

        return false;
    }

    public static void main(String[] args) {
        // Cycle exists (3 -> 2 -> 0 -> -4 -> back to 2)
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        System.out.println(isCycle(n1)); // should be true
    }
}
