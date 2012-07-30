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


TODO
    - We directly use Hibernate. Use JPa abstraction on top of Hibernate as explained here
        http://blog.springsource.org/2012/04/06/migrating-to-spring-3-1-and-hibernate-4-1/

    - Create BusinessExceptions and use then across all the application instead of raw Exception