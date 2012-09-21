package net.alaux.diosmio.gwt.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.springframework.web.context.support.WebApplicationContextUtils;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/*
 * Thanks MaxMatveev
 * http://blog.maxmatveev.com/2011/02/simple-spring-bean-autowiring-in-gwt.html
 */
public class SpringGwtServlet extends RemoteServiceServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
	super.init(config);
	WebApplicationContextUtils
		.getRequiredWebApplicationContext(getServletContext())
		.getAutowireCapableBeanFactory().autowireBean(this);
    }
}