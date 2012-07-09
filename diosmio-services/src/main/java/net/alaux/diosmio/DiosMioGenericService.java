package net.alaux.diosmio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: miguel
 * Date: 7/8/12
 * Time: 2:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class DiosMioGenericService {

    // Injected in diosmio applicationContext.xml
    // AUtowired based on the name
//    @Autowired
    public Properties serviceProperties;

    // Constructor parameter is injected in applicationContext.xml
    public DiosMioGenericService(Properties serviceProperties) {
        this.serviceProperties = serviceProperties;
    }
}
