package org.geeksforgeeks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int a = 10;

        Scanner scanner = new Scanner(System.in);
        String operation = scanner.next();

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();

        calculate(operation, num1, num2);

        /**
         * Group Id: Refers to an entity who has developed a particular project / jar
         * Artifact Id: Refers to a project / jar name which we are using
         * Version: Refers to the version of the project
         *
         * Archetype: Combination of groupId, artifact id and version is known as an archetype
         * Scope: Lifecycle when the dependency needs to be resolved i.e compile, provided, runtime, test, import etc.
         *
         * Java
         *  1. Maven : pom.xml : {dependencies}
         *  2. Gradle: build.gradle {dependencies}
         *
         * Python: requirements.txt {scikit, pandas, ...}  pip  install -r requirements.txt
         *
         * Node.js: package.json {}
         *
         * Ruby-on-rails : gemfile {collection of gems / libraries}
         *
         * Repositories in Maven:
         * 1. Local repository: A repository that is present in your local system. Accessible to the particular system and not available on cloud
         *
         * 2. Central repository: A repository that is present on cloud and is accessible to anyone and everyone. It mostly contains open source libraries
         *
         * 3. Remote repository: A repository that is present on cloud but accessible only to the authorised entities. Used for companies and organizations who codebase is not open source
         */

        /**
         * Lifecycle / Phase of maven
         * Note: All the lifecycles in maven are executed sequentially
         *
         * Clean --> Deletes the target folder
         * Validate --> validates whether pom.xml is there (temporary phase)
         * Compile --> Actually compiles the code and looks for any possible compilation error in main directory, builds target folder (i.e creates the bytecode)
         * Test --> This phase runs all the test cases / compiles all the test classes
         * Package --> This phase create a jar file and puts it in target folder
         *             1. Deployment on any server
         *             2. Used as a dependency in some other project or versioning
         * Verify --> Validates / verifies if target contains the jar file or not
         * Install --> Copies the jar and pom to local m2 repository so that it can be used in some other project locally
         * Site --> Looks for remote repository and tries to create connection with it
         * Deploy --> used for deploying / copying the artifacts (jar and pom) from local m2 to the remote repository
         */

    }

    public static int calculate(String operator, int num1, int num2){

        switch (operator){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
        }

        return 0;
    }
}