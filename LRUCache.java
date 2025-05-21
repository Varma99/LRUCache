package collections_framework.lru_from_scratch;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity = 3;
    private Map<String, Node> hashMap;
    private DoublyLinkedList dll;

    public LRUCache() {
        hashMap = new HashMap<>();
        dll = new DoublyLinkedList();
    }

    public LRUCache(int capacity) {
        this();
        this.capacity = capacity;
    }

    public void viewItemsInCache() {
        dll.printItems();
    }

    public void openApp(String appName) {
        Node mru;
        if (hashMap.containsKey(appName)) {
            mru = hashMap.get(appName);
            dll.removeNode(mru);
        } else {
            mru = new Node(appName);
            hashMap.put(appName, mru);
        }
        if (dll.getSize() == capacity) {
            Node lru = dll.removeLRU();
            if (lru != null) {
                hashMap.remove(lru.getAppName());
            }
        }
        dll.insertMRU(mru);
    }

    public void closeApp(String appName) {
        if (!hashMap.containsKey(appName)) {
            System.out.println("App is already closed or not opened till now.");
        } else {
            Node node = hashMap.get(appName);
            dll.removeNode(node);
            hashMap.remove(appName);
        }
    }
}
