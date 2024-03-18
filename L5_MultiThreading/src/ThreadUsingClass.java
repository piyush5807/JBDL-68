import java.util.concurrent.ThreadPoolExecutor;

public class ThreadUsingClass {

//    @Override
//    public void run() {
//        for(int i = 0; i < 100; i++){
//            System.out.println(i*i + " - in thread " + Thread.currentThread());
//        }
//    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("start of main function - in " + Thread.currentThread());

        System.out.println("cores  = " + Runtime.getRuntime().availableProcessors());

        Thread t1 = new Thread();
        t1.start();

        MyThread t2  = new MyThread();
        t2.start(); // factorial


        MyThread t3 = new MyThread();
        t3.start(); // power

//        ThreadUsingClass t3 = new ThreadUsingClass();
//        t3.start();

        Thread.sleep(2);
//        int cores = Runtime.getRuntime().availableProcessors();
//        System.out.println("cores = " + cores);

        for(int i = 0; i < 10000; i++){
            long ans = i*i + 10;
        }


//        t2.join();     // blocking call, our code inside main thread will not move ahead until t2 completely executes

        System.out.println("end of main function - in " + Thread.currentThread());
    }

    /**
     * main () --> t1.start() --> t1.start0() --> t1.run()
     * main() --> t2.start() --> t2.start0() --> t2.run()
     */

    /**
     * main thread -- already running, created by jvm
     *             -- spawned a new thread - T2
     *
     */

    private static class MyThread extends Thread{

        @Override
        public void run() {
            for(int i = 0; i < 100; i++){
                System.out.println(i*i + " - in thread " + Thread.currentThread());
            }
        }
    }


}
