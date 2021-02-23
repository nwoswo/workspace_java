package pe.mef.trans.security.config;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;




import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static pe.mef.trans.security.model.Constants.*;

import java.io.IOException;
import java.util.Arrays;




public class JwtAuthenticationFilter extends OncePerRequestFilter {
/*
    @Autowired
    private UserDetailsService userDetailsService;*/

    @Autowired
    private TokenUtils jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
    	
    	
    	System.out.println("doFilterInternal");
    	/*
    	jwtTokenUtil = WebApplicationContextUtils
                 .getRequiredWebApplicationContext(this.getServletContext())
                 .getBean(TokenUtils.class);
    	
    	userDetailsService = WebApplicationContextUtils
                .getRequiredWebApplicationContext(this.getServletContext())
                .getBean(UserDetailsService.class);
    	
    	 */
    	
    
        
    
          System.out.println(req);
    
    	
        String header = req.getHeader(HEADER_STRING);
        
        
        String username = null;
        
    

    	// ((HttpServletResponse) res).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Authorization header.");
        String authToken = null;
        
        

    	System.out.println("header="+header);
        
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
        	
        	
            authToken = header.replace(TOKEN_PREFIX,"");
            username = this.jwtTokenUtil.getUsernameFromToken(authToken);

     


      
        	
            //UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            
            System.out.println("username="+username);
            //System.out.println("SecurityContextHolder.getContext().getAuthentication()="+SecurityContextHolder.getContext().getAuthentication());
            
            if (username != null ) {
            //if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, null, Arrays.asList(new SimpleGrantedAuthority("asdf")));
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
            
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        

       
    }
        
     
        chain.doFilter(req, res);
    }
}