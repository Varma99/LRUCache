package collections_framework.lru_from_scratch;

public class TestLRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.openApp("WhatsApp");
        cache.openApp("Instagram");
        cache.openApp("Facebook");
        cache.viewItemsInCache(); // Facebook -> Instagram -> WhatsApp

        System.out.println("Accessing WhatsApp again...");
        cache.openApp("WhatsApp");
        cache.viewItemsInCache(); // WhatsApp -> Facebook -> Instagram

        System.out.println("Opening Gmail...");
        cache.openApp("Gmail"); // Should evict Instagram
        cache.viewItemsInCache(); // Gmail -> WhatsApp -> Facebook

        System.out.println("Closing Facebook...");
        cache.closeApp("Facebook");
        cache.viewItemsInCache(); // Gmail -> WhatsApp

    }
}
