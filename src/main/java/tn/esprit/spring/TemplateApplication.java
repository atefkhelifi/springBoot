package tn.esprit.spring;

import java.util.EnumSet;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import tn.esprit.spring.config.LoginFilter;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
public class TemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TemplateApplication.class, args);
	}

	
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		return new ServletRegistrationBean(servlet, "*.xhtml");
	}

	@Bean
	public FilterRegistrationBean rewriteFilter() {
		FilterRegistrationBean rwFilter = new FilterRegistrationBean(new RewriteFilter());
		rwFilter.setDispatcherTypes(
				EnumSet.of(DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR));
		rwFilter.addUrlPatterns("/*");
		return rwFilter;
	}
	/*@Bean
	public FilterRegistrationBean loginFilter() {
	FilterRegistrationBean registration = new FilterRegistrationBean();
	registration.setFilter( new LoginFilter());
	registration.addUrlPatterns("/xhtml/reclamation.xhtml");
	return registration;
	}*/
	/*@Bean
	public FilterRegistrationBean loginFilter() {
	FilterRegistrationBean registration= new FilterRegistrationBean();
	registration.setFilter(new LoginFilter());
	registration.addUrlPatterns("/xhtml/reclamation.xhtml","/xhtml/amine.xhtml");
	return registration;
	}*/
}
