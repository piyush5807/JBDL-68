import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorialUsingMT extends Thread{

    private BigInteger result;
    private int number;

    FactorialUsingMT(int number){
        this.number = number;
        this.result = BigInteger.ONE;
    }

    @Override
    public void run() {

//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        for(int i = 2; i <= number; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

//        System.out.println("for number = " + number + ", result = " + result);
        System.out.println("Inside run: for number : " + this.number + ", thread = " + currentThread());

//        System.out.println("inside run: for number = " + number + ", result = " + result);
    }

    /**
     * 1. correctness -
     * 2. optimization -
     * 3. code quality and refactoring, structuring of code
     */

    public static void main(String[] args) throws InterruptedException {

        List<Integer> numbers = Arrays.asList(10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 70000);
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        long startTime = System.currentTimeMillis();

        List<FactorialUsingMT> threads = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++){
            FactorialUsingMT thread = new FactorialUsingMT(numbers.get(i));
            threads.add(thread);
            thread.start();
        }

//        for(int i = 0; i < numbers.size(); i++){
////            threads.get(i).join(); // blocking call, code will not move ahead until thread has completely executed
//            System.out.println("for number = " + numbers.get(i) + ", result = " + threads.get(i).result);
//        }

        long endTime = System.currentTimeMillis();

        System.out.println("Time taken by the program : " + (endTime - startTime));

        // doing some other computation here independent of factorials
    }


    /**
     * T1  -  5
     * T2 - 4
     * T3 - 8
     * T4 - 3
     *
     * t1 + t2 + t3 + t4 ==> sequential code
     * max(t1, t2, t3, t4) ==> parallel code (Given that all of them gets the chance to run from the beginning)
     *
     *
     */


    /**
     * Thread pool - 25 threads {30 cores}
     * factorial - List (1000)
     * Create a task accordingly for every element and submit to thread pool executor
     * thread pool executor --> either create a new thread or reuse the existing thread - 25
     */

}
