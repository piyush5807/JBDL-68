public class USCalculator implements Calculator, MathsRunbook {

    @Override
    public int add(int a, int b) {
        return a + b + 1;
    }

    @Override
    public int subtract(int a, int b) {
        return Math.abs(a - b);
    }

    @Override
    public int divide(int a, int b) {
        return b / a;
    }

    @Override
    public int multiply(int a, int b) {
        return Calculator.super.multiply(a, b);
//        System.out.println("Inside multiply of USCalculator...");
//        return a * b + 10;
    }
}
