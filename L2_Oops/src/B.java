import java.util.ArrayList;
import java.util.List;

public class B extends A{

    /**
     * In java : multiple inheritance in terms of classes is not possible
     * this keyword refers to the current class object
     * super keyword refers to the parent class object
     */

    public void func(){
        System.out.println("Inside function func of class B");
    }

    public void testSomething(){
        System.out.println("Inside function testSomething of class B");
    }

    public static void main(String[] args) {

        //  reference = instance

        /**
         * Reference is only for visibility of functions
         * Function that will be executed will be of the class whose instance is initialized
         */

        B obj = new B();
        obj.func();
        obj.testSomething();

        A obj2 = new A();
        obj2.func();

        // A - mysql
        // B - mysql modified

        // You can call all the inherited functions in the child class if you are using parent class reference
        A obj3 = new B();
        obj3.func();
        obj3.print();

//        obj3.testSomething();

        List<Integer> al = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();



//        Not possible
//        B obj4 = new A();
//        obj4.func();

    }

}
