import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 8 core CPU => At a time, I can only run 8 threads parallely
        /**
         *
         * Futures / CompletableFuture - Asynchronous programming
         * Ta1 (T1) --> Ta2 (T2) = incorrect response if they both execute parallely instead of T1 waiting for the response of T2
         * 1 --> T1 (3s)  // within milliseconds
         * 2 --> T2 (3s)
         * 3 --> T3 (3s)
         * 4 --> T4 (3s)
         * 5 --> T5 (3s)
         * 6 --> T6 (3s)
         * 7 --> T7 (3s)
         * 8 --> T8 (3s)
         * 9 --> T9 (3s)
         * 10 --> T10 (1s)
         *
         * Sequential streams  - 10s
         * Parallel streams - 1s (T1 ... T8) + 1s (t9.. t10) = 2s
         *
         * Situation: I have only 1 core available
         *            Algorithm used : Round robin with 1 sec as the duration that the thread will stay in the processor
         * Total time = 30 + 30*(context switching) (in microseconds)
         *
         */



        /**
         *         Process                          Thread
         *
         */


        /**
         * Concurrent - Multiple threads/processes running in a such that the end user gets an intuition that they are running
         *              parallely but actually they are not because they are being context switch due to limitation of the hardware
         *
         * Parallel - Multiple threads/processes run parallely on separate cores/processors and there is no context switching
         *       Ex: Teacher asking all the students in a classroom to write in their notebooks
         *
         *  Not parallel : Ex: Teacher asking all the students in the classroom to write their names on the blackboard
         */

        /**
         * Scenario 1
         * Ex: 8 cores in the processor
         * Foreground threads: main , t1
         * Background threads / Daemon threads : Signal dispatcher, reference handler, finalizer
         * JVM will run only till the time any of the foregrounds threads are alive
         * or in words we can say that the JVM will stop all the background threads as soon as all the foreground threads are completely executed / stopped
         *
         *
         * Scenario 2
         * Ex: 8 cores in the processor
         * Foreground threads: main , t1, t2, t3, t5  , t6
         * Background threads / Daemon threads : Signal dispatcher, reference handler, finalizer
         *
         */

    }
}