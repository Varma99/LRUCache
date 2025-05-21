package collections_framework.lru_from_scratch;

public class Node {
    private String appName;
    public Node prev;
    public Node next;

    public Node(String appName) {
        this.appName = appName;
        prev = null;
        next = null;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
