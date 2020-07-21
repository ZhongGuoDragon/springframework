package com.tom.spitter.config;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.*;
import javax.servlet.Registration.Dynamic;


public class MyServletInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("myServlet", com.tom.spitter.web.myServlet.class);
        dynamic.addMapping("/test");
    }
}
