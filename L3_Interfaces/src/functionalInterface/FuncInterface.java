package functionalInterface;

@FunctionalInterface
public interface FuncInterface {

    int add(int a, int b);

//    Integer multiply(int a, int b);

    boolean equals(Object a);

    String toString();

    default int subtract(int a, int b){
        return Math.abs(a - b);
    }


}
