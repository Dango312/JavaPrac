package prac27;

public class Hashtab<K,V> {
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_LENGTH = 16;
    private final int arrayLength;
    private int size;
    private Node<K, V>[] tables;
    public Hashtab() {
        this(DEFAULT_LENGTH, DEFAULT_LOAD_FACTOR);
    }
    public Hashtab(int length) {
        this(length, DEFAULT_LOAD_FACTOR);
    }
    public Hashtab(int length, float loadFactor) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length is lower than 0");
        }
        if (loadFactor <= 0) {
            throw new IllegalArgumentException("Load factor is lower than 0");
        }
        this.arrayLength = length;
        tables = new Node[length];
    }
    public void hashtabAdd(K key, V value) {
        Node<K, V> node = new Node<>(key, value);
        int pos = key.hashCode() & (tables.length-1);
        if (tables[pos] == null) {
            tables[pos] = node;
        } else {
            Node<K, V> node1 = tables[pos];
            while (node1 != null) {
                if (node1.getKey().equals(key)) {
                    node1.setValue(value);
                    return;
                }
                node1 = node1.getNext();
            }
        }
    }
    public Node hashtabDelete(K key) {
        Node<K, V> node = get_element(key);
        Node<K, V> prev = node.getPrev();
        Node<K, V> next = node.getNext();
        if (next != null) {
            next.setPrev(prev);
        }
        if (prev != null) {
            prev.setNext(next);
        } else {
            int pos = key.hashCode() & (tables.length-1);
            tables[pos] = next;
        }
        return null;
    }

    public Node get_element(K key) {
        int pos = key.hashCode() & (tables.length-1);
        Node<K, V> node = tables[pos];
        while (node != null) {
            if (node.getKey().equals(key)) {
                return node;
            } else {
                node = node.getNext();
            }
        }
        return null;
    }
    public void print() {
        for (int i = 0; i < tables.length; i++) {
            if (tables[i] != null) {
                System.out.println(i + " " + tables[i]);
            }
        }
        System.out.println("\n");
    }
    public void clear() {
        tables = new Node[arrayLength];
        size = 0;
    }
    public int size() {
        return size;
    }
}

class Node<K,V>{
    private K key;
    private V value;
    private Node<K, V> next;
    private Node<K, V> prev;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        next = null;
        prev = null;
    }
    public K getKey() {
        return key;
    }
    public void setKey(K key) {
        this.key = key;
    }
    public V getValue() {
        return value;
    }
    public V setValue(V value) {
        this.value = value;
        return value;
    }

    public Node<K, V> getPrev() {
        return prev;
    }

    public void setPrev(Node<K, V> prev) {
        this.prev = prev;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }
    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
