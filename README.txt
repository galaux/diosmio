What is DiosMio
General technical overview
    Split into the following projects:
        diosmio-services-interface
            Owns the Java interfaces of the services provided by DiosMio (JAR)
        diosmio-services
            Owns the implementations of the services provided by DiosMio (JAR)
            Needs a Properties to be injected by Spring
        diosmio
            The webapp that instanciates and runs the services (WAR)
            Should later host a GUI
        diosmio-cli
            A CLI to invoke the services run by the diosmio webapp

INSTALL
Needs a tomcat with JMX enabled
ie:
    export CATALINA_OPTS="-Dcom.sun.management.jmxremote.port=8091 \
                          -Dcom.sun.management.jmxremote.authenticate=false \
                          -Dcom.sun.management.jmxremote.ssl=false \
                          -Djava.rmi.server.hostname=<YOUR_SERVER_IP>"

Needs a context-param in web.xml such as:
        <context-param>
            <param-name>diosmio-conf-file</param-name>
            <param-value>/mnt/data/misc/diosmio/diosmio.conf</param-value>
            <description>DiosMio configuration file</description>
        </context-param>

1st time run: need to get the WAR to create the DB schema
    server.persistence.hibernate.hbm2ddl.auto = create


Needs the H2 jar in the tomcat lib dir


TODO
    - We directly use Hibernate. Use JPa abstraction on top of Hibernate as explained here
        http://blog.springsource.org/2012/04/06/migrating-to-spring-3-1-and-hibernate-4-1/

To regenerate the ANTLR classes:
    java -cp /home/miguel/.m2/repository/org/antlr/antlr/3.4/antlr-3.4.jar:/home/miguel/.m2/repository/org/antlr/antlr-runtime/3.4/antlr-runtime-3.4.jar:/home/miguel/.m2/repository/org/antlr/ST4/4.0.4/ST4-4.0.4.jar org.antlr.Tool src/main/java/net/alaux/diosmio/ui/cli/antlr/DiosMioCli.g

Jars needed to generate Antlr Parser and Compiler
    export ANTLR_JARS=/home/miguel/.m2/repository/org/antlr/antlr/3.4/antlr-3.4.jar:/home/miguel/.m2/repository/org/antlr/antlr-runtime/3.4/antlr-runtime-3.4.jar:/home/miguel/.m2/repository/org/antlr/ST4/4.0.4/ST4-4.0.4.jar
