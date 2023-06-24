package com.rays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rays.common.FrontCtl;



/**
 * @author SONALI AVANTIKA YADAV
 *
 */
@SpringBootApplication
public class ProjectOrsApplication extends SpringBootServletInitializer{

	@Autowired
	private Environment env; 
 
	@Autowired 
	FrontCtl frontCtl;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectOrsApplication.class, args);
	}
	/**
	 * Enables CORS to all urls
	 * 
	 * @return
	 */
	@Bean
	public WebMvcConfigurer corsConfigurer() {

		//WebMvcConfigurer interface is a part of Spring MVC Framework in java.
		//used to configuring various aspects of the spring MVC web app,such as-
		//adding custom interceptors,resource handlers, message converters, view resolvers etc.
		WebMvcConfigurer w = new WebMvcConfigurer() {

			/**
			 * addCorsMappings() allows to define CORS configuration
			 * Add CORS(cross Origin Resource Sharing) to configure the cors behavior
			 * for your app's RESTfulAPIs(or to specify allowed origin,methods,header etc)
			 *
			 * CorsRegistry is a class of Spring Framework that allows to configure CORS
			 * setting for your web app
			 */
			public void addCorsMappings(CorsRegistry registry) {
				CorsRegistration cors = registry.addMapping("/**");//allow CORS for all endpoints
				cors.allowedOrigins("http://localhost:4200");
				cors.allowedHeaders("*");
				cors.allowCredentials(true);
			}
			/**
			 * Add Interceptors
			 */
			
			/*
			 * @Override public void addInterceptors(InterceptorRegistry registry) {
			 * registry.addInterceptor(frontCtl).addPathPatterns("/**").excludePathPatterns(
			 * "/Auth/**"); }
			 */
			  
			/*
			 * @Override public void addResourceHandlers(ResourceHandlerRegistry registry) {
			 * registry.addResourceHandler("/**").addResourceLocations("classpath:/public/")
			 * ; }
			 * 
			 */
		};

		return w;
	}

}
	