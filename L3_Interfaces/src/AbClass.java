public abstract class AbClass{

    AbClass(){
        System.out.println("Inside AbClass constructor");
    }

    public abstract int add(int a, int b);

    public int subtract(int a, int b){
        return Math.abs(a - b);
    }

    public static void main(String[] args) {

    }
}
