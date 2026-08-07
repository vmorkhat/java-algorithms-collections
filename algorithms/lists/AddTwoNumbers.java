public class AddTwoNumbers {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0); // result node
            ListNode tail = head; // pointer keeping track of the last node in the result list
            int carry = 0; // store overflow value in case the sum is bigger than 9, i.e. carry = 15 / 10 = 1

            while (l1 != null || l2 != null) {
                // grab current digit from l1 and l2
                // use 0 if the list is exhausted
                int digit1 = (l1 != null) ? l1.val : 0;
                int digit2 = (l2 != null) ? l2.val : 0;

                int sum = digit1 + digit2 + carry;
                carry = sum / 10;
                int lastDigit = sum % 10; // the digit to store
                ListNode node = new ListNode(lastDigit);
                tail.next = node;
                tail = tail.next; // move the tail to the last node

                // Move l1 and l2 pointers if not null
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

            if (carry > 0) {
                ListNode node = new ListNode(carry);
                tail.next = node;
                tail = tail.next;
            }

            return head.next;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.println(result.val); // must be 7 0 8
            result = result.next;
        }
    }
}