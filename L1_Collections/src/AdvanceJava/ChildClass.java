package AdvanceJava;

import CoreJava.Main;

public class ChildClass extends Main {

    // polymorphism or function overloading

    public static void main(String[] args) {

//        System.out.println("length of args = " + args.length);
//        for(String arg: args){
//            System.out.println("arg = " + arg) ;
//        }
        ChildClass obj = new ChildClass();
        obj.setNum("def");

        obj.setAge(-99);
    }

    public static void main(){

    }

}
