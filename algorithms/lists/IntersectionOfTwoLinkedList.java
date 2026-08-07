public class IntersectionOfTwoLinkedList {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode getIntersectionOfTwoLinkedLists(ListNode nodeA, ListNode nodeB) {
        if (nodeA == null || nodeB == null) {
            return null;
        }

        ListNode currentA = nodeA;
        ListNode currentB = nodeB;

        while (currentA != currentB) {
            currentA = (currentA == null) ? nodeB : currentA.next;
            currentB = (currentB == null) ? nodeA : currentB.next;
        }

        return currentA;
    }

    public static void main(String[] args) {
        ListNode common = new ListNode(8);
        common.next = new ListNode(4);

        ListNode a = new ListNode(4);
        a.next = new ListNode(1);
        a.next.next = common;

        ListNode b = new ListNode(5);
        b.next = new ListNode(6);
        b.next.next = common;

        System.out.println(getIntersectionOfTwoLinkedLists(a, b) == common); // true
        System.out.println(getIntersectionOfTwoLinkedLists(new ListNode(1), new ListNode(2))); // null
        System.out.println(getIntersectionOfTwoLinkedLists(null, null)); // null
    }
}
