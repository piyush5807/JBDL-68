package CoreJava;

public class Main {

    /**
     * If no parameterized constructor is defined for a class, compiler will create a default constructor in the bytecode
     * @param args
     */

    String num;

     private Integer age;

     public void setNum(String s){

         this.num = s;
     }

    public void setAge(Integer age){

         if(age < 0){
             return;
         }

        this.age = age;
    }

    // constructor overloading
//    Main(int num){
//        this.num = String.valueOf(num);
//    }

    // 1. Either we forgot to define the default constructor

    public static void main(String[] args) {
        float a = 9.0f;

        System.out.println("Hello world!");
        Main obj = new Main();
        System.out.println(obj.num);

        String b = obj.num;
    }
}

// JDK - Java development Kit
//     - converts the high level code into a bytecode
// JRE - Java runtime environment
//     - bytecode is run inside the virtual machine with the help of JRE