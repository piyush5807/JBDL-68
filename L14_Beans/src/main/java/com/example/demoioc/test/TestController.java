package com.example.demoioc.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    @Autowired
    private TestConfiguration testConfiguration;  // t1 => getOM => (it will create an object since the getOM function has a singleton scope and a bean already exists)

//    @Autowired // does not work on static fields
    private static TestService testService;

    // dependency injection => objects not on classes

    private static int num = 10;

    // t1, t2, t3 ... tn => testService

    /***
     * testController - o1
     * testService - o2
     *
     * inject o2 in o1
     *
     * o2 is not associated to o's (i.e o1) but it is associated with the class TestController
     */

    @Autowired
    private TestRepository testRepository;

    @Value("${test_property_int}")
    static int testInt;

    /**
     * 1. This property might be required in multiple classes, you will be creating multiple variables in different classes and assigning
     * 2. It's easily configurable
     * 3. You can manage different profiles for different env
     */

    @Value("${test_property_str}")
    String testStr;

    @Value("${test_property_float}")
    Float testFloat;



    /**
     * integer, double, boolean, float, long => string
     *
     * HashMap<String, Object>
     */

//    TestController(){
//        System.out.println("Inside default testController");
//    }

//    @Autowired
//    TestController(TestService t,
//                   @Value("${test_property_int}") int testInt,
//                   @Value("${test_property_float}") float testFloat,
//                   @Value("${test_property_str}") String testStr){
//        System.out.println("Inside testController: testService = " + testService);
//        testService = t;
//        this.testService.doSomething();
//        this.testFloat = testFloat;
//        this.testInt = testInt;
//        this.testStr = testStr;
//
//        // I am not able to do anything on testRepository
//
////        this.testProp = 10;
//    }

//    @Autowired
//    TestController(TestRepository testRepository){
//        System.out.println("Inside testController: testRepository = " + testRepository);
//        this.testRepository = testRepository;
////        this.testProp = 10;
//    }
//    TestController(TestService testService, int testProp){
//        System.out.println("Inside testController: testService = " + testService);
//        this.testService = testService;
//        this.testService.doSomething();
//        this.testProp = testProp;
//    }

//    TestController(TestRepository testRepository){
//        System.out.println("Inside testController: testRepository = " + testRepository);
//        this.testRepository = testRepository;
////    }

    /**
     * Field dependency injection:
     *    1. Happens once the constructor is executed i.e inside the constructor, the value of injected dependency is null
     *    2. Con: Cannot define final
     * Constructor dependency injection:
     *
     *
     *    2. Autowired on top of constructor is only mandatory when you have multiple parameterized constructor.
     *       This is done to resolve spring's dilemma of choosing one constructor over the others
     *    3. Whenever there is only 1 parameterized constructor, you can omit the @Autowired annotation
     */

    /**
     * 1. Application will because dependency injection fails
     * 2. The application will not fail but the variable holds the
     *    value as null and can give NPE whenever it is used
     */
    @GetMapping("/test")
    public HashMap<String, Object> getProperties(){

        System.out.println("inside getProps: testService = " + testService);

        HashMap<String, Object> result = new HashMap<>();
        result.put("int", testInt);
        result.put("float", testFloat);
        result.put("str", testStr);

        return result;
    }

    /**
     * Autowiring / DI : to inject a dependency (bean) of some other class into the current class object
     * TestController t => TestService s
     */
}
