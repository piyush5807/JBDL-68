import java.util.HashMap;
import java.util.Objects;

public class Person {

    private int id; //

    private String name;

    private int age; // null


    public Person(int id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // int - primitive - 0
    // Integer - derived data // wrapper classes - null

    // long
    // Long


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    public static void main(String[] args) {

        HashMap<String, Boolean> personMap = new HashMap<>();
//
//        /**
//         * k1 - v1
//         * k1  - v2
//         */
//
//        // Abhinav - X1    <-  s1
//        //           X1      <-  s2
//        // Amit   - X2
//
        String s1 = new String("Abhinav");
        String s2 = new String("Abhinav");
//
//
//
//        /**
//         *  Abhinav -- X1  <--- S1
//         *  Abhinav  --- X2  <--- S2
//         */
//
//        String s1 = "Abhinav";
//        String s2 = "Abhinav";
//
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));

        /**
         *  Abhinav  -  x1    <--- s1
         *                    <---- s2
         */

        personMap.put("Sonu", true);
        personMap.put(s1, true);
        personMap.put("Radhika", true);

        personMap.put(s2, false);

        System.out.println(personMap);

        // **************************************

        Person p1 = new Person(2, "Abhinav", 11);
        Person p2 = new Person(3, "Radhika", 12);
        Person p3 = new Person(2, "Abhinav", 11);

        HashMap<Person, Boolean> personBooleanHashMap = new HashMap<>();
        personBooleanHashMap.put(p1, true);
        personBooleanHashMap.put(p2, true);
        personBooleanHashMap.put(p3, false);


        System.out.println(p1.hashCode() + " " + p2.hashCode() +  " " + p3.hashCode());

        System.out.println(personBooleanHashMap);

        // Chair ~ Hashcode
        // Person ~ equals

        /**
         * check if hashcode is same or not
         * 	if hashcode == same
         * 		if .equals() address is same
         * 			update bucket
         * 		else
         * 	        COLLISION
         * 			create new node in the chain or do probing
         * 	else
         * 	    insert data on a bucket
         */



    }
}
















