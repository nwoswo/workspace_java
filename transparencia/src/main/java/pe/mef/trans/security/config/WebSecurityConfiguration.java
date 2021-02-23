package pe.mef.trans.security.config;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import static org.springframework.http.HttpHeaders.*;
import static org.springframework.http.HttpMethod.*;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableTransactionManagement
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired    
    private JwtAuthenticationEntryPoint unauthorizedHandler;

   
    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }
    /*
    
    @Override
	public void configure(WebSecurity web) throws Exception {
 
		web.ignoring()
				// ignoring the "/", "/index.html", "/app/**", "/register",
				// "/favicon.ico"
				.antMatchers("/**", "/index.html");
	}
    */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	
    	 http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/data/**").permitAll()
                .antMatchers("/rest/archivos/downloadFile/**").permitAll()
                .antMatchers("/logeoUsuario").permitAll()
                .antMatchers("/rest/solicitud/list").permitAll()
                .anyRequest().authenticated()
                .and()
                
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and() 

                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        
        http
                .addFilterBefore(authenticationTokenFilterBean(), ExceptionTranslationFilter.class);
                //.addFilterAfter(corsConfigurationSource(), ExceptionTranslationFilter.class);
      
    }
    

    
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
       /*
        
        configuration.setAllowedOrigins(Arrays.asList("/*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        source.registerCorsConfiguration("/**", configuration);
        */
        
        /*
        
        configuration.setAllowedOrigins(Arrays.asList("/*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        
        source.registerCorsConfiguration("/**", configuration);
        
        */
        /*
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"));
        configuration.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PATCH", "PUT"));
        
        source.registerCorsConfiguration("/**", configuration);
        */
        
        //configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("*"));
        //configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"));
        
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("*"));
        
        source.registerCorsConfiguration("/**", configuration);
        
        
        return source;
    }
    

}
