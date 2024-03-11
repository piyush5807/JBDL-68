public class Main extends USCalculator {
    public static void main(String[] args) {

        Calculator calculator = new USCalculator();
        Calculator calculator2 = new EnglishCalculator();

        /**
         * Either create an object of a class implementing the interface
         * Create an anonymous inner class that defines all the abstract functions
         */

        Calculator calculator3 = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a + b + 2;
            }

            @Override
            public int subtract(int a, int b) {
                return Math.abs(a - b) + 1;
            }

            @Override
            public int divide(int a, int b) {
                return a / b + 1;
            }
        };



        System.out.println(calculator.subtract(3, 5));
        System.out.println(calculator2.subtract(3, 5));
        System.out.println(calculator3.subtract(3, 5));

        System.out.println(calculator.multiply(3, 5));
        System.out.println(calculator2.multiply(3, 5));
        System.out.println(calculator3.multiply(3, 5));

        System.out.println(calculator.divide(31, 5));
        System.out.println(calculator2.divide(31, 5));
        System.out.println(calculator3.divide(31, 5));

        /**
         * Java 1
         * Java didn't have multiple inheritance for classes but it was for interfaces
         *
         * Java 8
         * When default functions came into picture, this diamond ambiguity problem also arised if a class implements from 2 different interfaces which have same default function
         */

//        Calculator.power(10, 2);

        Calculator obj = new USCalculator(); //
        obj.multiply(3, 4);

        MathsRunbook obj2 = new USCalculator();
        obj2.multiply(3, 4);

        USCalculator obj3 = new USCalculator();
        obj3.multiply(3, 4);

        // Functional interface : default functions are used inside this
//
//        MathsRunbook obj2 = new USCalculator();
//        obj2.multiply(3, 4);
    }
}