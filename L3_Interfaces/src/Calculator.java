public interface Calculator {

    int var = 10;

    default void init(){
        System.out.println("....");
    }

     int add(int a, int b);

    int subtract(int a, int b);

    /**
     * Default functions are non abstract functions i.e they have a body / definition
     */

    default int multiply(int a, int b){
        return a * b;
    }

//    static int power(int a, int b){
//        return (int)Math.pow(a, b);
//    }

    int divide(int a, int b);

}
