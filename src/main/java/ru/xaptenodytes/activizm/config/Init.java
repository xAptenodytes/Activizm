package ru.xaptenodytes.activizm.config;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Init  extends AbstractAnnotationConfigDispatcherServletInitializer{
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
        // Setting container parameters
		servletContext.setInitParameter("defaultHtmlEscape", "true");

        // Register character encoding filter
        FilterRegistration charEncodingFilterReg = servletContext.addFilter("CharacterEncodingFilter", CharacterEncodingFilter.class);
        charEncodingFilterReg.setInitParameter("encoding", "UTF-8");
        charEncodingFilterReg.setInitParameter("forceEncoding", "true");
        charEncodingFilterReg.addMappingForUrlPatterns(null, false, "/*");
        
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {SecurityConfig.class, WebMvcConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {AppConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}