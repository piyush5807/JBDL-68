public class A implements TestInterface{

    /**
     * Encapsulation -- attributes + functions (behaviour)
     * Data hiding -- hiding attributes and exposing behaviour / functionalities to the outside
     * Polymorphism -- There are multiple ways to implement same feature
     *       Compile time polymorphism -
     *             exhibited by overloading of functions or constructors
     *             Same function name with different number of type of arguments, return type of all the overloaded functions should be same
     *       Run time polymorphism
     *             exhibited by function overriding
     *             same function (name + signature) in both the child and the parent class
     * Inheritance --
     */

    // +  (5 + 3 == 8)
    // + ("abc" + "def" == "abcdef")


    A(){

    }

    A(int a){

    }

    A(int a, int b){

    }

    void func(){
        System.out.println("Inside function func of class A");
    }

    void print(){

    }

    public void add(int a, int b){
        System.out.println(a + b);
    }

    private int add(String a, String b){
        System.out.println(a + b);
        return 0;
    }

    public void add(String a){
        System.out.println(a + a);
    }

    public void add(String a, Integer b){
        System.out.println(a + b);
    }

    public static void main(String[] args) {
        A a = new A();
        a.add(10, 20);
        a.add("abc", "def");

    }

    public void random(int a, int b){

    }
}
