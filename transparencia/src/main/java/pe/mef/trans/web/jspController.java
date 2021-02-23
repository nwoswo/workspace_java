package pe.mef.trans.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pe.mef.trans.repo.mapper.UsuarioMapper;

@Controller
public class jspController {

	@Autowired
	public UsuarioMapper usuarioMapper;

	
	@RequestMapping("logeoUsuario")
	public String logeoUsuario( ModelMap model,HttpServletRequest request, HttpServletResponse response) throws Exception { 

	System.out.println("logeoUsuario");
			
		
		System.out.println("jsp controller4"+usuarioMapper.findAll());
				
		
		  return "welcome";
	    
	   
	}
	
	
	 
}
