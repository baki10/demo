package com.bakigoal.shop.web.config;


import com.bakigoal.shop.server.config.JpaConfig;
import com.bakigoal.shop.server.config.ServiceConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppInitializer implements WebApplicationInitializer {

  public void onStartup(ServletContext context) throws ServletException {
    // Create the 'root' Spring application context
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(ServiceConfig.class, JpaConfig.class, SecurityConfig.class);

    // Manage the lifecycle of the root application context
    context.addListener(new ContextLoaderListener(rootContext));

    // Create the dispatcher servlet's Spring application context
    AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
    dispatcherServlet.register(MvcConfig.class);

    // Register and map the dispatcher servlet
    ServletRegistration.Dynamic dispatcher = context.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
}
