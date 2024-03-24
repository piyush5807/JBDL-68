public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");

        BankAccount obj = new BankAccount(1, "Test@IDFC", 1000);
        BankAccount obj2 = new BankAccount(2, "Test@ICICI", 1000);



        MyThread t1 = new MyThread(true, 500, obj);
        Thread thread = new Thread(t1);
        thread.start(); // MyThread

        MyThread t2 = new MyThread(false, 700, obj);
        Thread thread2 = new Thread(t2);
        thread2.start();

        MyThread t3 = new MyThread(true, 400, obj);
        Thread thread3 = new Thread(t3);
        thread3.start();

        MyThread t4 = new MyThread(true, 400, obj2);
        Thread thread4 = new Thread(t4);
        thread4.start();

        thread.join();
        thread2.join();
        thread3.join();
//        MyThread2 t2 = new MyThread2();
//        t2.start(); // target - MyThread2

        /**
         * 800
         * 1500
         * 300
         * Can be either 800 or 300 or 1500
         */

        System.out.println("bank account = " + obj);

    }

    private static class MyThread implements Runnable {

        private boolean isDeposit;
        private int amount;

        private BankAccount bankAccount;

        public MyThread(boolean isDeposit, int amount, BankAccount bankAccount) {
            this.isDeposit = isDeposit;
            this.amount = amount;
            this.bankAccount = bankAccount;
        }

        @Override
        public void run() {
//            System.out.println("Inside run function... thread = " + Thread.currentThread());

            if(isDeposit){
                this.bankAccount.deposit(this.amount);
            }else{
                this.bankAccount.withdraw(this.amount);
            }
        }
    }

//    private static class MyThread2 extends Thread {
//
//        @Override
//        public void run() {
//
//        }
//    }

}