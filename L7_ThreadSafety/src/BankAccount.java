import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankAccount {

    private int id;
    private String name;

    private volatile int balance;

    public BankAccount(int id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void deposit(int amount){

        // entry section
        System.out.println("Inside deposit: amount = " + amount + ", thread = " + Thread.currentThread() + ", balance = " + this.balance);

        // critical section
        synchronized (this) { // t1 --> t3 --> t2 this ==> bank account obj
            System.out.println("Inside deposit synchronized... thread = " + Thread.currentThread() + ", obj = " + this);
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.balance += amount;
        }

        // Remainder section (t1, t2, t3)
        System.out.println("Returning from deposit: amount = " + amount + ", thread = " + Thread.currentThread() + ", balance = " + this.balance);
    }

    /**
     * Replace : geeks --> coders
     * Search : geeks - 10
     * @param amount
     */

    public void withdraw(int amount){
        synchronized (this) { // this ==> bank account obj
            System.out.println("Inside withdraw: amount = " + amount + ", thread = " + Thread.currentThread() + ", balance = " + this.balance);
            System.out.println("Inside withdraw synchronized... thread = " + Thread.currentThread() + ", obj = " + this);
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.balance -= amount;
            System.out.println("Returning from withdraw: amount = " + amount + ", thread = " + Thread.currentThread() + ", balance = " + this.balance);
        }
        // t1 --> remainder (t1 critical section result)

    }
    public synchronized void withdraw2(int amount){
        System.out.println("Inside withdraw: amount = " + amount + ", thread = " + Thread.currentThread() + ", balance = " + this.balance);
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.balance -= amount;
        System.out.println("Returning from withdraw: amount = " + amount + ", thread = " + Thread.currentThread() + ", balance = " + this.balance);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        for(int i = 0; i < numbers.size(); i++){
            if(numbers.get(i) == 2){
                numbers.remove(i);
            }
        }

        System.out.println(numbers);


    }

    // I want to prepare for java developer interview, can you ask a mix of theoretical and practical questions that can test my knowledge ?

    // deadlock:
    // t1 --> R1(o) & R2(w)
    // t2 --> R2(O) & R3 (w)
    // t3 --> R3(o) & R1 (w)

    // Inside deposit: amount = 500, thread = Thread[Thread-0,5,main], balance = 1000
    //Inside deposit synchronized... thread = Thread[Thread-0,5,main]
    //Inside withdraw: amount = 700, thread = Thread[Thread-1,5,main], balance = 1000
    //Inside deposit: amount = 400, thread = Thread[Thread-2,5,main], balance = 1000
    //Inside deposit synchronized... thread = Thread[Thread-2,5,main]
    //Returning from deposit: amount = 500, thread = Thread[Thread-0,5,main], balance = 1500
    //Returning from deposit: amount = 400, thread = Thread[Thread-2,5,main], balance = 1900
    //Inside withdraw synchronized... thread = Thread[Thread-1,5,main]
    //Returning from withdraw: amount = 700, thread = Thread[Thread-1,5,main], balance = 1200
}
