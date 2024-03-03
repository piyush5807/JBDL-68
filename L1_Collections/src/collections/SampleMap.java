package collections;

import java.util.HashMap;

public class SampleMap {

    public static void main(String[] args) {
        // Map - Key value store
        // Set - Key store

        HashMap<Integer, Boolean> hashMap = new HashMap();
        hashMap.put(10, true); // O(1)
        hashMap.put(15, true); // O(1)
        hashMap.put(1, true); // O(1)
        hashMap.put(3, true); // O(1)
        hashMap.put(40, true); // O(1)

        System.out.println(hashMap);

        // Addition - O(1)
        // Removal - O(1)
        // Retrieval - O(1)
    }
}
