import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    // dummy sentinel nodes
    // head <-> [MRU ... LRU] <-> tail
    final Node head = new Node();
    final Node tail = new Node();

    Map<Integer, Node> nodeMap;
    int capacity;

    private class Node {
        int value;
        int key;
        Node prev;
        Node next;
    }

    public LRUCache(int capacity) {
        nodeMap = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        head.prev = head;
    }

    public int get(int key) {
        int result = -1;

        Node node = nodeMap.get(key);
        if (node != null) {
            result = node.value;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = nodeMap.get(key);
        if (node != null) {
            node.value = value;
            remove(node);
            add(node);
        } else {
            if (nodeMap.size() == capacity) {
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            nodeMap.put(key, newNode);
            add(newNode);
        }
    }

    private void remove(Node node) {
        Node nextNode = node.next;
        Node prevNode = node.prev;

        nextNode.prev = prevNode;
        prevNode.next = nextNode;
    }

    private void add(Node node) {
        Node headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }
}
