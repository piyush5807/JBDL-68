package functionalInterface;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        FuncInterface funcInterface = new FuncInterface() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };

        // input
        // return type
        // actual logic

        // Lambda expression
        FuncInterface obj = (a, b) -> {
            return a + b;
        };

        System.out.println(obj.add(5, 4));


        Predicate<String> predicate = (t) -> {
            System.out.println("Inside predicate function");
            return t.length() > 0;
        };

        System.out.println(predicate.test("delhi"));
        System.out.println(predicate.test(""));

        Predicate<Integer> predicate2 = (t) -> t % 2 == 0; // single line lambda

        Predicate<Integer> p2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        };

        System.out.println(predicate2.test(13));
        System.out.println(predicate2.test(4));


        // ***********************************************************************


        int a = 10;
        String b = String.valueOf(10);

        Function<Integer, String> o = (num) -> {
            String s = String.valueOf(num);
            return s;
        };

        System.out.println(o.apply(20));

        Consumer<String> consumer = s -> System.out.println(s.toUpperCase());

//        Consumer<Integer> consumer1 = (number) -> System.out.println(number);
//        consumer1.accept(10);


        consumer.accept("Mumbai");

        // There are two ways to create a thread, one is by creating an object of thread class and another one is creating an anonymous inner class of runnable interface
        Runnable r = () -> System.out.println(new Random().nextInt());

        r.run();
        r.run();
        r.run();


        /**
         * There are two ways to implement an interface
         * 1. Explicitly define a class and override / implement all the abstract functions
         * 2. Define an anonymous inner class while creating the object for the interface
         *    Lambdas are just another way to write step 2 given that your interface has only 1 abstract method
         */

    }
}
