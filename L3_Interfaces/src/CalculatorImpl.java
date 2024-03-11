public class CalculatorImpl implements Calculator {

    public int add(int a, int b){
        return a + b;
    }

    @Override
    public int subtract(int a, int b) {
        return 0;
    }

    @Override
    public int divide(int a, int b) {
        return 0;
    }

    CalculatorImpl(){
        Calculator.super.init();
        System.out.println("Inside CalculatorImpl constructor...");
    }

    public static void main(String[] args) {
        CalculatorImpl obj = new CalculatorImpl();
    }
}
