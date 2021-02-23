package pe.mef.trans.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by LynAs on 20-Jan-16
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "pe.mef.trans.web","pe.mef.trans.security" })
public class WebConfig
 extends WebMvcConfigurerAdapter  
{
	
	@Autowired
    Environment env;
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{
		registry.addResourceHandler("**").addResourceLocations("/");
	//	registry.addResourceHandler("views/static/**").addResourceLocations("/WEB-INF/views/static/");
	}
	
	/*
	 @Override
	    public void addCorsMappings(CorsRegistry corsRegistry) {
	        corsRegistry.addMapping( "/**" )
			.allowedMethods("POST", "GET", "PUT", "DELETE", "HEAD")
			 .allowedHeaders("Content-Type", "Date", "Total-Count", "loginInfo","Authorization")
			 .exposedHeaders("Content-Type", "Date", "Total-Count", "loginInfo", "Authorization")
			.allowedOrigins("*")
			.allowCredentials(false); 
	    }
	 */
	

}
