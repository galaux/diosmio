Needs a tomcat with JMX enabled
ie:
    export CATALINA_OPTS="-Dcom.sun.management.jmxremote.port=8090 \
                          -Dcom.sun.management.jmxremote.authenticate=false \
                          -Dcom.sun.management.jmxremote.ssl=false"

Needs a context-param in web.xml such as:
        <context-param>
            <param-name>diosmio-conf-file</param-name>
            <param-value>file:/mnt/data/misc/diosmio/diosmio.conf</param-value>
            <description>DiosMio configuration file</description>
        </context-param>

