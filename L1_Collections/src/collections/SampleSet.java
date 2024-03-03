package collections;

import java.util.HashSet;

public class SampleSet {

    public static void main(String[] args) {

        // List is an ordered data structure whereas set and map are unordered
        HashSet<Integer> set = new HashSet<>();
        set.add(5); // O(1)
        set.add(15);
        set.add(3);
        set.add(20);
        set.add(20);
        set.add(null);

        System.out.println(set);

        boolean result = set.remove(15); // O(1)
        System.out.println("Result of removal = " + result);

        System.out.println(set);



        // Ques: Target sum
        // Given an array of integers and a target, you have to tell if there exists a pair whose sum leads to the target
        // [1, 2, 3, 4, 5, 6, 7, 8]
        // target = 13

    }
}
