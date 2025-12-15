package org.example;

class Entry<K,V> {
    K key;
    V value;
    Entry<K,V> next;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
public class HashMapImplementation<K,V> {
    private Entry<K,V>[] buckets;
    private static final int INITIAL_CAPACITY = 16;
    private int size = 0;

    public HashMapImplementation(){
        buckets = new Entry[INITIAL_CAPACITY];
    }

    private int getBucketIndex(K key){
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void put (K key, V value){

        int index = getBucketIndex(key);
        Entry <K,V> newEntry = new Entry<>(key, value);

        if (buckets[index] == null){
            buckets[index] = newEntry;
        }else {
             Entry<K,V> current = buckets[index];
             Entry<K,V> previous = null;
             while(current != null){
                 if(current.key.equals(newEntry.key)){
                     current.value = newEntry.value;
                     size++;
                        return;
                 }
                 previous = current;
                 current = current.next;
             }
             previous.next = newEntry;
             size++;
        }
    }

    public V get(K key){
        int index = getBucketIndex(key);
        Entry<K,V> current = buckets[index];
        while(current!=null){
            if(current.key.equals(key))
            {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public boolean remove (K key){
        int index = getBucketIndex(key);
        Entry<K,V> current = buckets[index];
        Entry<K,V> previous = null;
        while(current!=null){
            if(current.key.equals(key)){
                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public int size(){
        return size;
    }



    public static void main(String[] args) {
        HashMapImplementation<String, Integer> map = new HashMapImplementation<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put("One", 11); // Update value for key "One"

        System.out.println(map.remove("One")); // true
        System.out.println(map.remove("Four")); // false

        System.out.println(map.get("Two"));
        System.out.println(map.get("X"));

    }
}
