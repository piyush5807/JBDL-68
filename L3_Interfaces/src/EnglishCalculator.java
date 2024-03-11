public class EnglishCalculator implements Calculator{

    /**
     * A class implementing an interface must override all the abstract functions in that interface
     * Abstract functions - functions that don't have a body / definition
     */

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public int divide(int a, int b) {
        return a / b;
    }
}
