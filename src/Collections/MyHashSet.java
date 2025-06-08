package Collections;

public class MyHashSet{
    private final int SIZE = 16;

    private Node[] buckets;
    private int current;

    public MyHashSet() {
        buckets = new Node[SIZE];
        current = 0;
    }
    private static class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    public void add(Object value){
        if (contains(value)) {
            return;
        }
        int index = getHashCode(value);
        Node newNode = new Node(value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        current += 1;
        if (current > buckets.length) {
            rehash();
        }
    }

    public void remove(Object value) throws Exception {
        int index = getHashCode(value);

        Node head = buckets[index];
        Node prev = null;

        while (head != null) {
            if (head.value == value) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                current -= 1;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public boolean contains(Object value) {
        int index = getHashCode(value);
        Node head = buckets[index];
        while (head != null) {
            if (head.value == value) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    private void rehash() {
        Node[] temp = buckets;
        buckets = new Node[2 * temp.length];
        current = 0;

        for (Node head : temp) {
            while (head != null) {
                add(head.value);
                head = head.next;
            }
        }
    }


    public int getHashCode(Object value){
        int hash = value.hashCode();
        return (hash%buckets.length);
    }
    public int size()
    {
        return current;
    }

}
