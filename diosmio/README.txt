Needs a tomcat with JMX enabled
ie:
    export CATALINA_OPTS="-Dcom.sun.management.jmxremote.port=8090 \
                          -Dcom.sun.management.jmxremote.authenticate=false \
                          -Dcom.sun.management.jmxremote.ssl=false"
