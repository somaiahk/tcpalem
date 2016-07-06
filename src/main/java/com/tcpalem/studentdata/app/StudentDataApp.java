package com.tcpalem.studentdata.app;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jetty.setup.ServletEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import realdoc.rest.versions.VersionsBundle;

import com.github.nhuray.dropwizard.spring.SpringBundle;
import com.sun.jersey.api.core.ResourceConfig;
import com.tcpalem.studentdata.config.StudentDataConfig;

/**
 * @since 17/06/2016
 * @author somaiah
 *
 */
public class StudentDataApp extends Application<StudentDataConfig> {

	public static void main(final String[] args) throws Exception {
		new StudentDataApp().run(args);
	}

	@Override
	public void initialize(Bootstrap<StudentDataConfig> bootstrap) {
		bootstrap.addBundle(new SpringBundle<>(applicationContext(), true, true, true));
		bootstrap.addBundle(new VersionsBundle(this));
		/*bootstrap.addBundle(new SwaggerBundle("2.0"));
        bootstrap.addBundle(new CorsBundle());*/
        bootstrap.addBundle(new AssetsBundle("/swagger/", "/swaggerui/"));
		
	}

	public ConfigurableApplicationContext applicationContext() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com/tcpalem/studentdata","com/tcpalem/studentdata");
		return context;
	}

	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void run(StudentDataConfig configuration, Environment environment) throws Exception {
		
		ServletEnvironment servletEnv = environment.servlets();
		
		//Remove dropwizard default exception mappers and register EDM custom exception mapper.
		ResourceConfig drConfig = environment.jersey().getResourceConfig();
		List singletonsToRemove = new ArrayList();
		
		/*for (Object singleton : drConfig.getSingletons()) {
			
	        if (singleton instanceof ExceptionMapper
	                && singleton.getClass().getName().startsWith("io.dropwizard.jersey")) {
	            singletonsToRemove.add(singleton);
	        }
	    }

	    for (Object s : singletonsToRemove)
	    	drConfig.getSingletons().remove(s);	    */
	    
	    // Register the custom ExceptionMapper(s)
	    //environment.jersey().register(new AppExceptionMapper());
	    
	 // Register the ProxyContainerRequestFilter.
        //environment.jersey().getResourceConfig().getContainerRequestFilters().add(new ProxyContainerRequestFilter());

		
	}
	
	
}
