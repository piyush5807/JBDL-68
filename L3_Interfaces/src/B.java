public class B extends A{

    int count;

//    B(){
//        super();
//    }

//    B(int a){
//      super(a);
//    }

    // super()

    public static void test(){
        System.out.println("Inside test of Class B");

//        System.out.println(count);
    }

    public void test2(){
        this.count ++;
        System.out.println("count = " + this.count);
    }

    public static void main(String[] args) {

        /**
         *          c1
         *    S1 -      c1
         *    S2 -      c1
         *    S3 -      c1
         *
         *    s1 - 10
         *    s2 - 20
         *    s3 - 30
         *
         *    C1 what's your age ?
         *    C1 what's your class name ?
         *
         *    S1 what's your age
         *    S1 what's your class name
         */

        B b = new B();

        b.test();
        B.test();

//        B.test2(); This is not possible

        B b2 = new B();

        b.test2();
        b2.test2();

        /**
         * Whenever you create an object of a child, an object of parent also will be created by the JVM
         *
         */
    }
}
