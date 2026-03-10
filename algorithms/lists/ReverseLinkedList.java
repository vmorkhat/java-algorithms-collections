
class Node {
    int val;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class ReverseLinkedList {

    public Node reverseList(Node head) {
        if (head == null) {
            return head;
        }

        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // save link to the next node
            current.next = prev; // reverse connetcion of the current line on the previous node

            prev = current; // move prev pointer on current node
            current = next; // move current pointer on next node
        }

        return prev; // return new head of the list
    }
}