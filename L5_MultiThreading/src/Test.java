import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {

        /**
         * When you launch (run inside JVM) a java applicable, a new thread is created by JVM and the entire program
         * runs inside that thread (i.e on a core)
         *
         * Debugging:
         * Frames - Function call stack
         * Threads -
         *
         *
         * Java application:
         * Standalone application: These type of applications will start, execute the tasks and then they will stop
         * Server: Continously running program (which listens to user's request and do some action)
         */

        System.out.println("Hello");
        Thread.currentThread().setPriority(10);
        System.out.println(Thread.currentThread());
        try {
            A();
        }catch (IOException e){
//            e.printStackTrace();
        }

        // T1 : To insert some data in the db {this is the backbone of your app}
        // T2 : To write the data in a backup file {disaster management : failover}
    }

    public static void A() throws IOException {
        System.out.println("Inside A");
        B();

    }

    public static void B() throws IOException {
        System.out.println("Inside B");
        C();
    }

    public static void C() throws IOException {
        System.out.println("Inside C");

        try {
            int a = 1 / 0;
        }catch (ArithmeticException a){
            a.printStackTrace();
        }
//        try {
//            FileInputStream inputStream = new FileInputStream("");
//            inputStream.read();
//        }catch (IOException e){
////            e.printStackTrace();
//            throw e;
//        }
    }

























}
