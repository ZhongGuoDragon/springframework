package com.tom.spitter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.tom.spitter"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = {EnableWebMvc.class})})

public class RootConfig {
}
