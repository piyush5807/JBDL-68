public class SingletonClass {

    private static SingletonClass obj = null;

    private static final SingletonClass object = new SingletonClass();

    /**
     * Singleton class - A class that allows only one object to be created from outside the class
     *
     * Use cases: When you are allocating resources: initializing a cache or creating a database connection
     *
     * OrderRepository.java --> DB product -> table order
     * PayoutRepository.java --> DB product -> table payout
     *
     * Connection - DB level (not at the table level)
     *
     * t1 -->
     * t2 -->
     */

    private SingletonClass(){
        System.out.println("Inside SingletonClass: ref = " + this);
    }

    public static SingletonClass getInstance(){
        if(obj == null){
            obj = new SingletonClass();
        }

        return obj;
    }

    public static SingletonClass getInstance2(){
        return object;
    }

    public static void main(String[] args) {
        SingletonClass obj1 = new SingletonClass();
        SingletonClass obj2 = new SingletonClass();
        SingletonClass obj3 = new SingletonClass();
        SingletonClass obj4 = new SingletonClass();

        SingletonClass obj5 = SingletonClass.getInstance();
        SingletonClass obj6 = SingletonClass.getInstance();
        SingletonClass obj7 = SingletonClass.getInstance();
        SingletonClass obj8 = SingletonClass.getInstance();
        SingletonClass obj9 = SingletonClass.getInstance();


        System.out.println(obj1 + " " + obj2 + " " + obj3 + " " + obj4 + " " + obj5 + " " + obj6 + " " + obj7);
    }

    // Thread safety: Synchronization / critical section
}
