package com.sky.biz.sseries;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.primefaces.util.Constants;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class ConfigureJSFContextParameters implements ServletContextInitializer {

	
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		servletContext.setInitParameter("javax.faces.DEFAULT_SUFFIX",
                ".xhtml");
        servletContext.setInitParameter(
                "javax.faces.PARTIAL_STATE_SAVING_METHOD", "true");
        servletContext.setInitParameter("javax.faces.PROJECT_STAGE",
                "Development");
        servletContext.setInitParameter("facelets.DEVELOPMENT", "true");
        servletContext.setInitParameter(
                "javax.faces.FACELETS_REFRESH_PERIOD", "1");
        servletContext.setInitParameter(Constants.ContextParams.THEME, "bootstrap");
        servletContext.setInitParameter(Constants.ContextParams.FONT_AWESOME, "true");
	}

}
