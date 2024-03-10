public interface TestInterface {

    /**
     * In interfaces, all the methods are by public whereas in any class, if no access modifier is given they are having default scope
     * @param a
     * @param b
     */

//    default void add(int a, int b);  // type of interface function

    default void random(int a, int b){ // Java 8 onwards, when we cover Lambdas

    }
}
