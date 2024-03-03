package collections;

import java.util.Arrays;
import java.util.Comparator;

public class SampleArray {


    // Arrays & Arraylist
    // Sets | HashSet
    // Map | HashMap

    public static void main(String[] args) {

//        Integer[]arr = {1, 5, 2, 4, 31, 61, 6};
//
//        Arrays.sort(arr, new Comparator<Integer>(){
//
//            @Override
//            public int compare(Integer o1, Integer o2){
//                return o2 - o1;
//            }
//        });
//
//        for(int i = 0 ; i < arr.length; i++){
//            System.out.println(arr[i]);
//        }

        // Jar - Java archive | exactly similar to a uncompressed zip file

        /** Ques: You are given the data of students and their attendance, you have to sort the data in such a way
        that the first student in the result set should be the one which has maximum attendance i.e he/she has attended most of the classes
        If there are more than 1 student who have attended same number of classes, then return geographically smaller one first

         Ansh - 5
         Gaurav - 4
         Mathew - 4
         Shobana - 3
         Anurag = 3

         [Ansh, Gaurav, Mathew, Anurag, Shobana]
         **/

        Person[] people = {
                new Person(5, "Ansh"),
                new Person(3, "Shobana"),
                new Person(4, "Mathew"),
                new Person(3, "Anurag"),
                new Person(4, "Gaurav"),

        };

        sort2(people);
        print(people);

    }

    public static void print(Person[] people){
        for(Person person: people){
            System.out.println(person.getName());
        }
    }

    public static void sort(Person[] people){
        Arrays.sort(people, new Person());
    }

    // e1  e2

    public static void sort2(Person[] people){
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if (p1.getFrequency() == p2.getFrequency()) {
                    return p1.getName().compareTo(p2.getName());
                }

                return p2.getFrequency() - p1.getFrequency();
            }
        });
    }
}
