package com.tom.spitter.config;

import com.tom.spitter.web.myServlet;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.*;


public class MyServletInitializer implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("myServlet", myServlet.class);
        dynamic.addMapping("/test");
    }
}
