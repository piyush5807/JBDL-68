package functionalInterface;

public class Impl implements FuncInterface{
    @Override
    public int add(int a, int b) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println(obj);
        return true;
    }

    public static void main(String[] args) {
        Impl impl = new Impl();
        impl.equals(impl);
    }
}
