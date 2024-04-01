package com.example.demospringboot;

public class Test {

    /**
     * Zomato / Swiggy
     * Staging/Development, Pre-prod/UAT, Production
     * 10GB storage for DB,        10TB storage for DB
     *
     * JBDL-68 - {master branch , staging branch} cherry-pick / extract your changes from a lower environment branch and merge those in production env branch
     *           {db: abc.com:3306/test  , db: xyz.com:3306/test}
     */

    /**
     * Spring doesn't have any support for auto configuration whereas in spring boot, auto-configuration is added in spring boot starter dependency that allows us to define several spring boot related properties in a much simpler manner
     */

    /**
     * Logging levels
     * zomato:
     * Profile:
     *      Production:
     *              Users: 10M
     *              Logs: X
     *              Function: Serving the customer's request
     *              Expectation: Those logs which have caused some error
     *      Staging:
     *              Users: 5K
     *              Logs: Y
     *              Function: Testing the new features or bug fixes
     *              Expectation: More and more logs
     *  Scale: X >> Y
     *
     *
     *  ERROR : Most severe ones and should be printed only when there's an error in the application
     *  WARN: Severe ones that a developer should be concerned about but not resulting an error
     *  INFO: A normal severity logs that relays some important information
     *  DEBUG: A log that gives more information to the developer about the things are happening.
     *  TRACE: A log that is giving even the minutest of the details about anything and everything
     *
     *  Logging level - INFO } INFO, WARN, ERROR
     *                - DEBUG } DEBUG, INFO , WARN, ERROR
     */
}
