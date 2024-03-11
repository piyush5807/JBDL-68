package functionalInterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Person {

    private int id;
    private String name;
    private int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {

        Person p1 = new Person(1, "Rohit", 10);
        Person p2 = new Person(2, "Vinu", 10);
        Person p3 = new Person(3, "Shobana", 30);
        Person p4 = new Person(4, "Anurag", 40);
        Person p5 = new Person(5, "Abhinav", 20);
        Person p6 = new Person(6, "Radhika", 20);

        List<Person> people = Arrays.asList(p1, p2, p3, p4, p5, p6);

//        Comparator<Person> comparator = new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                if(o1.age != o2.age){
//                    return  o1.age - o2.age;
//                }
//
//                return o1.name.compareTo(o2.name);
//            }
//        };
//
        Comparator<Person> comparator = (o1, o2) -> {
            if(o1.age != o2.age){
                return o1.age - o2.age;
            }

            return o1.name.compareTo(o2.name);
        };

        System.out.println(people);

        Collections.sort(people, comparator);

        System.out.println(people);


    }
}
