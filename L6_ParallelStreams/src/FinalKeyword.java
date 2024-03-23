public class FinalKeyword {

    /**
     * variables - constant whose value cannot be changed
     *          final instance variable : values can be assigned only during declaration or inside the constructor
     *          final static variable : values can be assigned only during declaration or inside a static block
     *          use cases: when you want to define something that should not be changed thruout the course of your application
     * functions - functions that cannot be overridden in the subclasses
     *            use cases: while creating libraries or code bases for saas (b2b) based companies
     * classes - classes which cannot be inherited, can we say that all the functions are by default final ?
     */

    /**
     * Inheritance means passing on the functionality to a child:
     *  static functions cannot comprise any functionality wrt an entity / object
     *  They contain code for class as a whole
     */

    final static int a;

    static int b;

    int c;

    static {
        a = 20;
        b = 30;
    }

    static void test(){
        b = 40;
//        a = 10; // Not possible
//        c = 20;

    }

    FinalKeyword(){
        System.out.println("Inside finalize: creating ...." + this);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Inside finalize, waiting for deletion.... " + this);
    }

    public Integer add(int a, int b){
//        return this.a + this.b;
        return a + b;
    }

    public final Integer subtract(int a, int b){
        return a - b;
    }

//    public Integer subtract(int a, int b){
//        return 0 - a;
//    }

    public static void main(String[] args) {
        FinalKeyword o = new FinalKeyword();
        o.b = 20;
        FinalKeyword.b = 30;

        o = null;
        System.gc();

        /**
         * 1. o will be deleted / garbage collected
         * 2. o will not be deleted / garbage collected
         */

    }
}
