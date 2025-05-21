package collections_framework.lru_from_scratch;

public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int size;
    
    public DoublyLinkedList() {
        head = new Node("head");
        tail = new Node("tail");
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void insertMRU(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public Node removeLRU() {
        if (head.next == tail) {
            return null;
        }
        Node lru = tail.prev;
        tail.prev = lru.prev;
        lru.prev.next = tail;
        size--;
        // Optionally clear lru pointers.
        lru.next = null;
        lru.prev = null;
        return lru;
    }

    public void removeNode(Node node) {
        // remove node from it's position
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        size--;
    }

    public void printItems() {
        Node curr = head.next;
        System.out.println("Cache [MRU -> LRU]:");
        while (curr != tail) {
            System.out.print(curr.getAppName());
            curr = curr.next;
            if (curr != tail) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }
}
