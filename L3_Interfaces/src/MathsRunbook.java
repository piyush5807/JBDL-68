public interface MathsRunbook {

    default int multiply(int a, int b){
        return a * b - 1;
    }

    int divide(int a, int b);
}
