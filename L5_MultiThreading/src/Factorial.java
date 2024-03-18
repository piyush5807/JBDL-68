import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Factorial {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 70000);

        long startTime = System.currentTimeMillis(); // time in epoch (milliseconds that are passed so far from 1st Jan 1970)

        numbers.stream()
                .map(x -> compute(x))
                .forEach(x -> System.out.println(x));

        long endTime = System.currentTimeMillis();

        System.out.println("Time taken by the program = " + (endTime - startTime));

    }

    public static BigInteger compute(int number){
        BigInteger result  = BigInteger.ONE;

        for(int i = 2; i <= number; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }

        return result;
    }
}
