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
