import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Ques: Given a list of integers, you have to find the first even number whose square is > 50




        // 4 + 16 + 36 + 64 + 100
        List<Integer> numbers = Arrays.asList(1, 3, 7, 12, 5, 19, 17, 11, 8, 4);
        Set<Integer> numberSet = new HashSet<>();
        numberSet.add(1);
        numberSet.add(3);
        numberSet.add(7);
        numberSet.add(12);
        numberSet.add(5);
        numberSet.add(19);
        numberSet.add(17);
        numberSet.add(11);
        numberSet.add(8);
        numberSet.add(4);


//        System.out.println(findFirstEvenNumber(numbers, 50));
        System.out.println(findFirstEvenNumberUsingStreams(numbers, 50));
//        int result1 = sumOfSquaresOfEvenNumbers(numbers);
//        int result2 = sumOfSquaresOfEvenNumbersUsingStreams(numbers);
//        squaresOfEvenNumbersUsing(numbers);

//        List<String> cities = Arrays.asList("Delhi", "Mumbai", "Ahmedabad", "Hyderabad", "Aurangabad");
//        System.out.println(compute(cities));

//        System.out.println(result2);

    }

    public static Integer findFirstEvenNumber(List<Integer> numbers, int target){
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) % 2 == 1){
                continue;
            }
            if(numbers.get(i) * numbers.get(i) > target){
                return numbers.get(i); // or break, it's one and the same thing
            }
        }
        return -1;
    }

    public static Integer findFirstEvenNumberUsingStreams(List<Integer> numbers, int target){

        /**
         * terminal function
         * short-circuit terminal function
         */

        // Don't write this type of a code
//        boolean found = false;
//        Integer result = -1;
//        numbers.stream()
//                .filter(x -> x % 2 == 0 && x*x > target)
//                .forEach(x -> {// terminal function
//                    // ........................
//                    if(!found){
////                        result = x;
////                        found = true;
//                        System.out.println("Inside foreach: x = " + x);
//                        return;
//                    }
//                });

        Optional<Integer> result = numbers.parallelStream()
                .filter(x -> {
                    System.out.println("Inside filter: x = " + x);
                    return x % 2 == 0 && x*x > target;
                })
                .findFirst();         // short circuit terminal function
//
        return result.orElse(-1);

        /**
         * 1. 8
         * 2. 12
         * 3. Undeterministic
         * 4. None of the above
         */
    }



    public static List<String> compute(List<String> cities){

        List<String> result = new ArrayList<>();
        for(int i = 0; i < cities.size(); i++){
            if(cities.get(i).startsWith("a") || cities.get(i).startsWith("A")){
                result.add(cities.get(i).toUpperCase());
            }
        }
        return result;
    }

    // Declarative or functional programming
    public static List<String> computeUsingStreams(List<String> cities){

       return cities.stream()
               .filter(x -> x.startsWith("a") || x.startsWith("A"))
               .map(x -> x.toUpperCase())
               .collect(Collectors.toList());
    }

    public static Integer sumOfSquaresOfEvenNumbers(List<Integer> numbers){
        int sum = 0;
        for(int i = 0; i < numbers.size(); i++){
            int result = numbers.get(i) * numbers.get(i);
            if(result % 2 != 0){
                continue;
            }
            sum = sum + result;
        }
        return sum;
    }

    public static Integer sumOfSquaresOfEvenNumbersUsingStreamsModified(List<Integer> numbers){

        // 1 2 3
        Integer result  = numbers
                .stream()
                .filter(x -> x % 2 == 0)
                .map(y -> (int)Math.pow(y, 2))
                .reduce(0, (i, j) -> i + j);

        return result;
    }

    /**
     * Typical biscuit producing factory
     * removing all the dust particles from the raw material (flour, refined flour)
     * raw material --> dough
     * dough --> beautify that dough
     * machine which basically converts the dough into a biscuit
     */

    /**
     * ? super and ? extends in stream interface functions are just to handle the child and parent in case of generics
     * @param numbers
     */

    // filtering out all the odd numbers
    // mapping all the numbers to their squares
    // accumulating / summing all the mapped even numbers

    public static Integer sumOfSquaresOfEvenNumbersUsingStreams(List<Integer> numbers){

        Stream<Integer> numberStream = numbers.stream(); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

        Stream<Integer> filteredNumberStream = numberStream.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                System.out.println("Inside filter: number = " + integer);
                return integer % 2 == 0;
            }
        });


        Stream<Integer> squaredNumberStream = filteredNumberStream.map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                System.out.println("Inside map: number = " + integer);
                return (int) Math.pow(integer, 2);
            }
        });

        /**
         * identity function in maths -
         * operands  operator operand => result
         * 4        +     0     =   4
         * 5        -     0     =   5
         * 10       *     1     =   10
         *          /     1
         *          ^     1
         */

//        Integer result = 0;

        Integer result = squaredNumberStream.reduce(0, new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                System.out.println("Inside reduce: numbers = " + integer + ", " + integer2);
                return integer + integer2;
            }
        });

        return result;
    }



    /**
     * Two types of functions in the stream interface:
     *  1. Terminal function - those which do not return a stream of elements as the output
     *  2. Intermediate function - those which are return stream as an output
     *
     *  Streams will not even execute if there is no terminal function.
     *  Conclusion: There should be exactly one terminal operation in every stream
     * @param numbers
     */

    public static void squaresOfEvenNumbersUsing(List<Integer> numbers){

//        Stream<Integer> someStream = numbers
//                .stream()
//                .filter(new Predicate<Integer>() {
//                    @Override
//                    public boolean test(Integer integer) {
//                        System.out.println("Inside filter: number = " + integer);
//                        return integer % 2 == 0;
//                    }
//                })
//                .map(new Function<Integer, Integer>() {
//                    @Override
//                    public Integer apply(Integer integer) {
//                        int result = (int) Math.pow(integer, 2);
//                        System.out.println("Inside map: number = " + integer + ", result = " + result);
//                        return result;
//                    }
//                });
//
//        someStream.forEach(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) {
//                System.out.println(integer);
//            }
//        });
//
//        System.out.println("someStream = " + someStream);


//        numbers.stream()
//                .forEach(x -> {
//                    if(x % 2 == 0){
//                        System.out.println(x * x);
//                    }
//                });


//                .forEach(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) {
//                        System.out.println(integer);
//                    }
//                });

    }


    /** output that we get depends on various factors:
     * 1. type of data set from which streams are formed
     * 2. Type of function you are using --- will make sense later on (If I am calling findFirst and the dataset is ordered,
     *                           whether I'm using parallel stream or sequential stream, my output will not change)
     * 3. type of the stream : sequential and parallel
     *      (
     *          Parallel streams operate on multiple threads,
     *          Sequential streams operate on a single thread
     *      )
     *
     *      F1, F2, F3   (Sequential stream work)
     *      T1 -- T2 => F1
     *      T2 -- T3 => F2
     *      T3 -- T4 => F3
     *
     *      T1 -- ?  => F1, F2, F3 (Parallel streams work)
     *
     *      Given a very big file that contains MBs of data:
     *      Q1: You have to find the first occurrence of the word "Hi"       -- findFirst()
     *      Q2: You have to find any occurrence of the word "Hi"             -- findAny()
     *
     *
     *      MCQ:
     *      1. Both Q1 and Q2 can be done using parallel stream optimally
     *      2. Both Q1 and Q2 can be done using sequential stream optimally
     *      3. Q1 --> Sequential , Q2 --> Parallel       -- correct
     *      4. Q1 --> Parallel, Q2 --> Sequential
     *
     */

    /**
     * numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     * Target = 50
     *
     */

}