package collections;

import java.util.Comparator;

public class Person implements Comparator<Person> {

    private int frequency;

    private String name;

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(int frequency, String name) {
        this.frequency = frequency;
        this.name = name;
    }

    public Person(){

    }


    @Override // Not mandatory
    public int compare(Person p1, Person p2) {

        // ABC
        // DEF

        // ABC. comparesTo DEF < 0
        // DEF. comparesTo ABC > 0


        if (p1.frequency == p2.frequency) {
            return p1.name.compareTo(p2.name);
        }

        return p2.frequency - p1.frequency;

    }

    @Override
    public String toString() {
        return "Person{" +
                "frequency=" + frequency +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * Primitive data type : int, float, double, boolean, long
     * Derived data type : infinite
     * @param args
     */

    public static void main(String[] args) {
        // Hashcode is unique identifier for a memory address
        Person person = new Person(2, "ABC");
        System.out.println(person);

        float x = 5.0f;
        Float y = 5.0f;
        System.out.println(x + " " + y); // toString if they are non primitive , otherwise primitive's value

        int p = 5;
        int q = 5;

        String s = "str";

        String t = "str";

        // int, float, double, boolean, long
    }
}
