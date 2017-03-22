package com.sky.biz.sseries;

import java.util.Collections;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.faces.application.ProjectStage;
import org.primefaces.util.Constants;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SseriesApplication.class);
	}
	

//	@Bean
//	public static CustomScopeConfigurer customScopeConfigurer() {
//		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
//        configurer.setScopes(Collections.<String, Object>singletonMap(
//                FacesViewScope.NAME, new FacesViewScope()));
//		return configurer;
//	}
	
	@Bean
	public ServletContextInitializer servletContextCustomizer() {
	    return new ServletContextInitializer() {
            @Override
            public void onStartup(ServletContext sc) throws ServletException {
                sc.setInitParameter(Constants.ContextParams.THEME, "bootstrap");
                sc.setInitParameter(Constants.ContextParams.FONT_AWESOME, "true");
                sc.setInitParameter(ProjectStage.PROJECT_STAGE_PARAM_NAME, ProjectStage.Development.name());
            }
	    };
	}

}
