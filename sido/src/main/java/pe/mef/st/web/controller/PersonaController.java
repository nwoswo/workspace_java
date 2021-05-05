package pe.mef.st.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import pe.mef.st.bean.RsdcPersona;
import pe.mef.st.dao.PersonaMapper;
import pe.mef.st.web.handlerError.RecursoNotFoundException;


@RestController
@RequestMapping("/api")
public class PersonaController {
	
	@Autowired
	public PersonaMapper personaMapper;
	
	 @GetMapping("/dni")
	 public ResponseEntity<?> inicio(
			 @RequestParam("param1") String param1, 
			 @RequestParam("param2") String param2) {
	  
		  List<RsdcPersona> ldni = personaMapper.findDNI(param1, param2);
		   
		  if(ldni.size() == 0) {
			  
			 throw  new  RecursoNotFoundException("Dni no encontrado " + param2);
		  }
			 
		  return new ResponseEntity<RsdcPersona>(ldni.get(0), HttpStatus.OK);
		 
	 }

}
