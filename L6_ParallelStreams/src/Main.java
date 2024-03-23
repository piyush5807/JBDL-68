import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SingletonClass obj1 = SingletonClass.getInstance();

//        SingletonClass.obj = null;


        SingletonClass obj2 = SingletonClass.getInstance();
//        SingletonClass obj3 = SingletonClass.getInstance();
//        SingletonClass obj4 = SingletonClass.getInstance();

//        System.out.println(obj1 + " " + obj2 + " " + obj3 + " " + obj4);


        /**
         * Ques: You are given a list of numbers, you have to find any even number
         *  arr = [1, 2, 3, 4, 5, 6, 7, 8]
         *  Ans = (2, 4, 6, 8)
         */

//        List<Integer> numbers = new ArrayList<>();
//        for(int i = 1; i <= 60000000; i++){
//            numbers.add(i);
//        }
//
////        System.out.println(findFirstEvenUsingSeq(numbers));
////        System.out.println(findFirstEvenUsingPar(numbers));
//
//        System.out.println(sumOfSquares(numbers));
    }

    public static Integer findAnyEvenUsingSeq(List<Integer> numbers){

        return numbers.stream()
                .filter(x -> {
                    System.out.println("Inside filter: num = " + x + ", thread = " + Thread.currentThread());
                    return x % 2 == 0;
                })
                .findAny().orElse(-1);
    }

    public static Integer findAnyEvenUsingPar(List<Integer> numbers){

        return numbers.parallelStream()
                .filter(x -> {
                    System.out.println("Inside filter: num = " + x + ", thread = " + Thread.currentThread());
                    return x % 2 == 0;
                })
                .findAny().orElse(-1);
    }

    public static Integer findFirstEvenUsingSeq(List<Integer> numbers){

        return numbers.stream()
                .filter(x -> {
                    System.out.println("Inside filter: num = " + x + ", thread = " + Thread.currentThread());
                    return x % 2 == 0;
                })
                .findFirst().orElse(-1);
    }

    public static Integer findFirstEvenUsingPar(List<Integer> numbers){

        return numbers.parallelStream()
                .filter(x -> {
                    System.out.println("Inside filter: num = " + x + ", thread = " + Thread.currentThread());
                    return x % 2 == 0;
                })
                .findFirst().orElse(-1);
    }




    /**
     * Creating threads manually one by one, but it's better to use thread pool executor service (for abstraction)
     * Input - {2, 1, 3, 5, 7, 9, 11, 13, 15, .....}
     * Time complexity - O(N) {parallel / sequential}
     * FindFirst : { Seq / Parallel }
     * findAny : Parallel {Resource intensive}
     *
     * Parallel streams:
     * FindFirst or FindAny - number of operations that are done are indeterministic, but the answer in case of findFirst will always be deterministic
     */


    /**
     * Ques: Given a list of integers, you have to compute the sum of squares of even numbers.
     * [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] = 220
     */


    public static Integer sumOfSquares(List<Integer> numbers){

        long start = System.currentTimeMillis();
        numbers.stream()
                .filter(x -> {
//                    System.out.println("Inside filter, num = " + x + ", thread = " + Thread.currentThread());
                    return x % 2 == 0;
                })
                .map(x -> {
//                    System.out.println("Inside map, num = " + x + ", thread = " + Thread.currentThread());
                    return x*x;
                })
                .forEach(x -> {
//                    System.out.println("Inside reduce: x, y = " + x + " " + y + ", thread = " + Thread.currentThread());
//                    int a = 1;
                });

        long end = System.currentTimeMillis();

        System.out.println("time taken by the program : " + (end - start));

        return 0;

        // Inside reduce: x, y = 0 16, thread = Thread[ForkJoinPool.commonPool-worker-8,5,main]
        // Inside reduce: x, y = 0 16, thread = Thread[ForkJoinPool.commonPool-worker-8,5,main]

        /**
         * Parallel streams or Seq streams: These lines will be sequential
         * Inside filter, num = 2, thread = Thread[main,5,main] -- #1
         * Inside map, num = 2, thread = Thread[main,5,main]  -- #2
         * Inside reduce: x, y = 0 4, thread = Thread[main,5,main]
         *
         *
         * Inside filter, num = 4, thread = Thread[main,5,main] -- #3
         * Inside map, num = 4, thread = Thread[main,5,main]
         * Inside reduce: x, y = 4 16, thread = Thread[main,5,main] --
         *
         *
         * Seq streams : 0 + (2^2) + (4^2) + (6^2) + (8^2) + (10^2)
         *
         * Parallel streams:  1 + (2^2) => 5
         *                    1 + (4^2) -> 17
         *                    1 + (6^2) => 37
         *                    1 + (8^2) -> 65
         *          *         1 + (10^2) => 101
         *                    1 + (5) => 6
         *                    4 + 16 => 20
         *                    36 + 64 => 100
         *                    100 + 100 => 200
         *                    200 + 20 => 220
         *
         *                    happy flow = 364 {1, ... 12}
         *                    +1 =
         */
    }

    /**
     * w1 --> filter(1)
     * w2 --> filter(2) --> map (2)
     * w3 --> filter(3)
     * ...
     */


}