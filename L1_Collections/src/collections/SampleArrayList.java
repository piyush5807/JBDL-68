package collections;

import java.util.ArrayList;

public class SampleArrayList {

    public static void main(String[] args) {

//        ArrayList<String> cities = new ArrayList<>();
//
//        cities.add("Mumbai");
//        cities.add("Hyderabad");
//        cities.add("Chennai");
//        cities.add("Kolkata");
//        cities.add("Delhi");
//        cities.add("Delhi");
//
//        cities.add(2, "Guwahati");
//
//        System.out.println(cities);
//
//        cities.remove("Delhi"); // O(N)
//
//        cities.remove(2); // O(N)
//
//        System.out.println(cities);

        // ******************************************************

        // |   |    |    |     |
        // |   |   |   |   |

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(5);
        numbers.add(4);
        numbers.add(1);

        numbers.get(2);  // O(1)

        System.out.println(numbers);

        numbers.remove(new Integer(20)); // int and Integer

        System.out.println(numbers);

        /**
         * [1, 2, 3, 4, 5, 6]
         * ele(1) --> M1 (memory address)
         * ele(2) --> M1 + 4(BYTES)
         * ele(3) --> M1 + 4*2 ()
         * ele(4) --> M1 + 4*3 ()
         */

        int[]arr = new int[50]; // static allocation


        /**
         * [1, 2, 3, 4, 5, 6]
         * ele(1) --> M1 (memory address)
         * ele(2) --> M2
         * ele(3) --> M3
         * ele(4) --> M4
         */

        /**
         * Dynamic allocation
         * No contiguous memory required
         */

        /**
         * 1. error - 20th index not found
         * 2. no error, no removal because 20th index is not there
         * 3. remove the number 20
         */


    }
}
