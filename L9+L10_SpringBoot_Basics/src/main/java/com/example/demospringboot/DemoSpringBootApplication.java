package com.example.demospringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringBootApplication implements CommandLineRunner {

	private static Logger logger = LoggerFactory.getLogger(DemoSpringBootApplication.class);

	@Value("${library.books.number-of-days}") // dependency injection is done here
	private int days;  // days = 15

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootApplication.class, args);

		// IOC & DI

		logger.error("Inside thread - {}", Thread.currentThread());

//		System.out.println((2 + 5 == 10) + " inside thread" + Thread.currentThread());

		/** Advantages of logging over system.out
		 * 1. More information in logging like what's the class name in which the logs are printed
		 * 2. We can different levels of logging which directly impacts our adaptibility in terms of what all logs we want to suppress wrt a given profile
		 * 3. Logging can help us achieve auto rotation of log files
		 * 4. We can save on cost by reducing the number of logs for higher environment like production
		 * 5. Set up incident management for more severed logs: {victorops, nagios, pagerduty, opsgenie etc.} Prometheus / ELK / Datastore
		 */


		/**
		 * Tomcat > Jetty > undertow (Java 8)
		 * In java 17 / 3.x spring boot versions, if tomcat is not added, then only of the other web servers should be added either jetty or undertow
		 */


		/**
		 * Application
		 * Presentation
		 * Session
		 * Transport : {port}
		 * Network : {ip}
		 * Data link
		 * Physical
		 */

		/**
		 * Different types of embedded serves
		 * Autoconfiguration
		 * Diff b/w spring and spring boot
		 * Spring profiling and logging
		 * Some sample APIs
		 */

		/**
		 * Next week
		 * Dependency injection
		 * Inversion of control
		 */



	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("number of days from config = " + days);
		logger.warn("Inside run function, number of days from config - {}", days);
//
//		ServerProperties properties = new ServerProperties();
//		properties.setPort(9000);

	}

	/**
	 * /Users/piyush/Library/Java/JavaVirtualMachines/corretto-17.0.10/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=64459:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/piyush/Downloads/demo-spring-boot/target/classes:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.2.4/spring-boot-starter-web-3.2.4.jar:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot-starter/3.2.4/spring-boot-starter-3.2.4.jar:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot/3.2.4/spring-boot-3.2.4.jar:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.2.4/spring-boot-autoconfigure-3.2.4.jar:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.2.4/spring-boot-starter-logging-3.2.4.jar:/Users/piyush/.m2/repository/ch/qos/logback/logback-classic/1.4.14/logback-classic-1.4.14.jar:/Users/piyush/.m2/repository/ch/qos/logback/logback-core/1.4.14/logback-core-1.4.14.jar:/Users/piyush/.m2/repository/org/slf4j/slf4j-api/2.0.12/slf4j-api-2.0.12.jar:/Users/piyush/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.21.1/log4j-to-slf4j-2.21.1.jar:/Users/piyush/.m2/repository/org/apache/logging/log4j/log4j-api/2.21.1/log4j-api-2.21.1.jar:/Users/piyush/.m2/repository/org/slf4j/jul-to-slf4j/2.0.12/jul-to-slf4j-2.0.12.jar:/Users/piyush/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/Users/piyush/.m2/repository/org/springframework/spring-core/6.1.5/spring-core-6.1.5.jar:/Users/piyush/.m2/repository/org/springframework/spring-jcl/6.1.5/spring-jcl-6.1.5.jar:/Users/piyush/.m2/repository/org/yaml/snakeyaml/2.2/snakeyaml-2.2.jar:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.2.4/spring-boot-starter-json-3.2.4.jar:/Users/piyush/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.15.4/jackson-databind-2.15.4.jar:/Users/piyush/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.15.4/jackson-annotations-2.15.4.jar:/Users/piyush/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.15.4/jackson-core-2.15.4.jar:/Users/piyush/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.15.4/jackson-datatype-jdk8-2.15.4.jar:/Users/piyush/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.15.4/jackson-datatype-jsr310-2.15.4.jar:/Users/piyush/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.15.4/jackson-module-parameter-names-2.15.4.jar:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot-starter-tomcat/3.2.4/spring-boot-starter-tomcat-3.2.4.jar:/Users/piyush/.m2/repository/org/apache/tomcat/embed/tomcat-embed-core/10.1.19/tomcat-embed-core-10.1.19.jar:/Users/piyush/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.19/tomcat-embed-el-10.1.19.jar:/Users/piyush/.m2/repository/org/apache/tomcat/embed/tomcat-embed-websocket/10.1.19/tomcat-embed-websocket-10.1.19.jar:/Users/piyush/.m2/repository/org/springframework/spring-web/6.1.5/spring-web-6.1.5.jar:/Users/piyush/.m2/repository/org/springframework/spring-beans/6.1.5/spring-beans-6.1.5.jar:/Users/piyush/.m2/repository/io/micrometer/micrometer-observation/1.12.4/micrometer-observation-1.12.4.jar:/Users/piyush/.m2/repository/io/micrometer/micrometer-commons/1.12.4/micrometer-commons-1.12.4.jar:/Users/piyush/.m2/repository/org/springframework/spring-webmvc/6.1.5/spring-webmvc-6.1.5.jar:/Users/piyush/.m2/repository/org/springframework/spring-aop/6.1.5/spring-aop-6.1.5.jar:/Users/piyush/.m2/repository/org/springframework/spring-context/6.1.5/spring-context-6.1.5.jar:/Users/piyush/.m2/repository/org/springframework/spring-expression/6.1.5/spring-expression-6.1.5.jar com.example.demospringboot.DemoSpringBootApplication
	 *
	 *   .   ____          _            __ _ _
	 *  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
	 * ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
	 *  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
	 *   '  |____| .__|_| |_|_| |_\__, | / / / /
	 *  =========|_|==============|___/=/_/_/_/
	 *  :: Spring Boot ::                (v3.2.4)
	 *
	 * 2024-03-30T21:56:40.035+05:30  INFO 66520 --- [demo-spring-boot] [           main] c.e.d.DemoSpringBootApplication          : Starting DemoSpringBootApplication using Java 17.0.10 with PID 66520 (/Users/piyush/Downloads/demo-spring-boot/target/classes started by piyush in /Users/piyush/Downloads/demo-spring-boot)
	 * 2024-03-30T21:56:40.036+05:30  INFO 66520 --- [demo-spring-boot] [           main] c.e.d.DemoSpringBootApplication          : No active profile set, falling back to 1 default profile: "default"
	 * 2024-03-30T21:56:40.613+05:30  INFO 66520 --- [demo-spring-boot] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port 8080 (http)
	 * 2024-03-30T21:56:40.624+05:30  INFO 66520 --- [demo-spring-boot] [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
	 * 2024-03-30T21:56:40.624+05:30  INFO 66520 --- [demo-spring-boot] [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.19]
	 * 2024-03-30T21:56:40.660+05:30  INFO 66520 --- [demo-spring-boot] [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
	 * 2024-03-30T21:56:40.662+05:30  INFO 66520 --- [demo-spring-boot] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 593 ms
	 * 2024-03-30T21:56:40.867+05:30  INFO 66520 --- [demo-spring-boot] [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port 8080 (http) with context path ''
	 * 2024-03-30T21:56:40.873+05:30  INFO 66520 --- [demo-spring-boot] [           main] c.e.d.DemoSpringBootApplication          : Started DemoSpringBootApplication in 1.063 seconds (process running for 1.268)
	 */

	/**
	 * /Users/piyush/Library/Java/JavaVirtualMachines/corretto-17.0.10/Contents/Home/bin/java -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=61835:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Users/piyush/Downloads/demo-spring-boot/target/classes:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot-starter-web/3.2.4/spring-boot-starter-web-3.2.4.jar:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot-starter/3.2.4/spring-boot-starter-3.2.4.jar:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot/3.2.4/spring-boot-3.2.4.jar:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot-autoconfigure/3.2.4/spring-boot-autoconfigure-3.2.4.jar:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot-starter-logging/3.2.4/spring-boot-starter-logging-3.2.4.jar:/Users/piyush/.m2/repository/ch/qos/logback/logback-classic/1.4.14/logback-classic-1.4.14.jar:/Users/piyush/.m2/repository/ch/qos/logback/logback-core/1.4.14/logback-core-1.4.14.jar:/Users/piyush/.m2/repository/org/apache/logging/log4j/log4j-to-slf4j/2.21.1/log4j-to-slf4j-2.21.1.jar:/Users/piyush/.m2/repository/org/apache/logging/log4j/log4j-api/2.21.1/log4j-api-2.21.1.jar:/Users/piyush/.m2/repository/org/slf4j/jul-to-slf4j/2.0.12/jul-to-slf4j-2.0.12.jar:/Users/piyush/.m2/repository/jakarta/annotation/jakarta.annotation-api/2.1.1/jakarta.annotation-api-2.1.1.jar:/Users/piyush/.m2/repository/org/yaml/snakeyaml/2.2/snakeyaml-2.2.jar:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot-starter-json/3.2.4/spring-boot-starter-json-3.2.4.jar:/Users/piyush/.m2/repository/com/fasterxml/jackson/core/jackson-databind/2.15.4/jackson-databind-2.15.4.jar:/Users/piyush/.m2/repository/com/fasterxml/jackson/core/jackson-annotations/2.15.4/jackson-annotations-2.15.4.jar:/Users/piyush/.m2/repository/com/fasterxml/jackson/core/jackson-core/2.15.4/jackson-core-2.15.4.jar:/Users/piyush/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jdk8/2.15.4/jackson-datatype-jdk8-2.15.4.jar:/Users/piyush/.m2/repository/com/fasterxml/jackson/datatype/jackson-datatype-jsr310/2.15.4/jackson-datatype-jsr310-2.15.4.jar:/Users/piyush/.m2/repository/com/fasterxml/jackson/module/jackson-module-parameter-names/2.15.4/jackson-module-parameter-names-2.15.4.jar:/Users/piyush/.m2/repository/org/springframework/spring-web/6.1.5/spring-web-6.1.5.jar:/Users/piyush/.m2/repository/org/springframework/spring-beans/6.1.5/spring-beans-6.1.5.jar:/Users/piyush/.m2/repository/io/micrometer/micrometer-observation/1.12.4/micrometer-observation-1.12.4.jar:/Users/piyush/.m2/repository/io/micrometer/micrometer-commons/1.12.4/micrometer-commons-1.12.4.jar:/Users/piyush/.m2/repository/org/springframework/spring-webmvc/6.1.5/spring-webmvc-6.1.5.jar:/Users/piyush/.m2/repository/org/springframework/spring-aop/6.1.5/spring-aop-6.1.5.jar:/Users/piyush/.m2/repository/org/springframework/spring-context/6.1.5/spring-context-6.1.5.jar:/Users/piyush/.m2/repository/org/springframework/spring-expression/6.1.5/spring-expression-6.1.5.jar:/Users/piyush/.m2/repository/org/springframework/boot/spring-boot-starter-jetty/3.2.4/spring-boot-starter-jetty-3.2.4.jar:/Users/piyush/.m2/repository/jakarta/servlet/jakarta.servlet-api/6.0.0/jakarta.servlet-api-6.0.0.jar:/Users/piyush/.m2/repository/jakarta/websocket/jakarta.websocket-api/2.1.1/jakarta.websocket-api-2.1.1.jar:/Users/piyush/.m2/repository/jakarta/websocket/jakarta.websocket-client-api/2.1.1/jakarta.websocket-client-api-2.1.1.jar:/Users/piyush/.m2/repository/org/apache/tomcat/embed/tomcat-embed-el/10.1.19/tomcat-embed-el-10.1.19.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/ee10/jetty-ee10-servlets/12.0.7/jetty-ee10-servlets-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/jetty-http/12.0.7/jetty-http-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/jetty-io/12.0.7/jetty-io-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/jetty-util/12.0.7/jetty-util-12.0.7.jar:/Users/piyush/.m2/repository/org/slf4j/slf4j-api/2.0.12/slf4j-api-2.0.12.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/ee10/jetty-ee10-webapp/12.0.7/jetty-ee10-webapp-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/jetty-session/12.0.7/jetty-session-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/jetty-server/12.0.7/jetty-server-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/jetty-xml/12.0.7/jetty-xml-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/ee10/jetty-ee10-servlet/12.0.7/jetty-ee10-servlet-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/jetty-security/12.0.7/jetty-security-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/ee10/websocket/jetty-ee10-websocket-jakarta-server/12.0.7/jetty-ee10-websocket-jakarta-server-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/ee10/jetty-ee10-annotations/12.0.7/jetty-ee10-annotations-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/ee10/jetty-ee10-plus/12.0.7/jetty-ee10-plus-12.0.7.jar:/Users/piyush/.m2/repository/jakarta/transaction/jakarta.transaction-api/2.0.1/jakarta.transaction-api-2.0.1.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/jetty-jndi/12.0.7/jetty-jndi-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/jetty-plus/12.0.7/jetty-plus-12.0.7.jar:/Users/piyush/.m2/repository/org/ow2/asm/asm/9.6/asm-9.6.jar:/Users/piyush/.m2/repository/org/ow2/asm/asm-commons/9.6/asm-commons-9.6.jar:/Users/piyush/.m2/repository/org/ow2/asm/asm-tree/9.6/asm-tree-9.6.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/ee10/websocket/jetty-ee10-websocket-jakarta-client/12.0.7/jetty-ee10-websocket-jakarta-client-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/jetty-client/12.0.7/jetty-client-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/jetty-alpn-client/12.0.7/jetty-alpn-client-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/ee10/websocket/jetty-ee10-websocket-jakarta-common/12.0.7/jetty-ee10-websocket-jakarta-common-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/websocket/jetty-websocket-core-client/12.0.7/jetty-websocket-core-client-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/ee10/websocket/jetty-ee10-websocket-servlet/12.0.7/jetty-ee10-websocket-servlet-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/websocket/jetty-websocket-core-server/12.0.7/jetty-websocket-core-server-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/ee10/websocket/jetty-ee10-websocket-jetty-server/12.0.7/jetty-ee10-websocket-jetty-server-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/websocket/jetty-websocket-jetty-api/12.0.7/jetty-websocket-jetty-api-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/websocket/jetty-websocket-jetty-common/12.0.7/jetty-websocket-jetty-common-12.0.7.jar:/Users/piyush/.m2/repository/org/eclipse/jetty/websocket/jetty-websocket-core-common/12.0.7/jetty-websocket-core-common-12.0.7.jar:/Users/piyush/.m2/repository/org/springframework/spring-core/6.1.5/spring-core-6.1.5.jar:/Users/piyush/.m2/repository/org/springframework/spring-jcl/6.1.5/spring-jcl-6.1.5.jar com.example.demospringboot.DemoSpringBootApplication
	 *
	 *   .   ____          _            __ _ _
	 *  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
	 * ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
	 *  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
	 *   '  |____| .__|_| |_|_| |_\__, | / / / /
	 *  =========|_|==============|___/=/_/_/_/
	 *  :: Spring Boot ::                (v3.2.4)
	 *
	 * 2024-03-31T13:11:59.389+05:30  INFO 68004 --- [demo-spring-boot] [           main] c.e.d.DemoSpringBootApplication          : Starting DemoSpringBootApplication using Java 17.0.10 with PID 68004 (/Users/piyush/Downloads/demo-spring-boot/target/classes started by piyush in /Users/piyush/Downloads/demo-spring-boot)
	 * 2024-03-31T13:11:59.392+05:30  INFO 68004 --- [demo-spring-boot] [           main] c.e.d.DemoSpringBootApplication          : No active profile set, falling back to 1 default profile: "default"
	 * 2024-03-31T13:11:59.897+05:30  INFO 68004 --- [demo-spring-boot] [           main] o.s.b.w.e.j.JettyServletWebServerFactory : Server initialized with port: 8080
	 * 2024-03-31T13:11:59.899+05:30  INFO 68004 --- [demo-spring-boot] [           main] org.eclipse.jetty.server.Server          : jetty-12.0.7; built: 2024-02-29T21:19:41.771Z; git: c89aca8fd34083befd79f328a3b8b6ffff04347e; jvm 17.0.10+7-LTS
	 * 2024-03-31T13:11:59.914+05:30  INFO 68004 --- [demo-spring-boot] [           main] o.e.j.s.h.ContextHandler.application     : Initializing Spring embedded WebApplicationContext
	 * 2024-03-31T13:11:59.914+05:30  INFO 68004 --- [demo-spring-boot] [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 491 ms
	 * 2024-03-31T13:11:59.941+05:30  INFO 68004 --- [demo-spring-boot] [           main] o.e.j.session.DefaultSessionIdManager    : Session workerName=node0
	 * 2024-03-31T13:11:59.944+05:30  INFO 68004 --- [demo-spring-boot] [           main] o.e.jetty.server.handler.ContextHandler  : Started osbwej.JettyEmbeddedWebAppContext@7c1e32c9{application,/,b=file:/private/var/folders/4r/tw483f3n28v6r729wkzb_nx00000gn/T/jetty-docbase.8080.15092043881876695943/,a=AVAILABLE,h=oeje10s.SessionHandler@383864d5{STARTED}}
	 * 2024-03-31T13:11:59.944+05:30  INFO 68004 --- [demo-spring-boot] [           main] o.e.j.e.servlet.ServletContextHandler    : Started osbwej.JettyEmbeddedWebAppContext@7c1e32c9{application,/,b=file:/private/var/folders/4r/tw483f3n28v6r729wkzb_nx00000gn/T/jetty-docbase.8080.15092043881876695943/,a=AVAILABLE,h=oeje10s.SessionHandler@383864d5{STARTED}}
	 * 2024-03-31T13:11:59.946+05:30  INFO 68004 --- [demo-spring-boot] [           main] org.eclipse.jetty.server.Server          : Started oejs.Server@71f96dfb{STARTING}[12.0.7,sto=0] @1011ms
	 * 2024-03-31T13:12:00.089+05:30  INFO 68004 --- [demo-spring-boot] [           main] o.e.j.s.h.ContextHandler.application     : Initializing Spring DispatcherServlet 'dispatcherServlet'
	 * 2024-03-31T13:12:00.089+05:30  INFO 68004 --- [demo-spring-boot] [           main] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
	 * 2024-03-31T13:12:00.090+05:30  INFO 68004 --- [demo-spring-boot] [           main] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
	 * 2024-03-31T13:12:00.100+05:30  INFO 68004 --- [demo-spring-boot] [           main] o.e.jetty.server.AbstractConnector       : Started ServerConnector@58927778{HTTP/1.1, (http/1.1)}{0.0.0.0:8080}
	 * 2024-03-31T13:12:00.101+05:30  INFO 68004 --- [demo-spring-boot] [           main] o.s.b.web.embedded.jetty.JettyWebServer  : Jetty started on port 8080 (http/1.1) with context path '/'
	 * 2024-03-31T13:12:00.107+05:30  INFO 68004 --- [demo-spring-boot] [           main] c.e.d.DemoSpringBootApplication          : Started DemoSpringBootApplication in 0.963 seconds (process running for 1.173)
	 */

}
