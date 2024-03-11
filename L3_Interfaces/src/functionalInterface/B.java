package functionalInterface;

@FunctionalInterface
public interface B extends A{

//    void a(); // not possible since a() in A interface doesn't have an implementation

    void b();
}
