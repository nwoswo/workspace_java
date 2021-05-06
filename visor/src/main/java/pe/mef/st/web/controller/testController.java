package pe.mef.st.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import pe.mef.st.services.VisorService;

@RestController
@RequestMapping("/api")
public class testController {
	
	@Autowired
	VisorService vService;
	
	@GetMapping("/test")
	public ResponseEntity<?> inicio() {
	  
		String test =vService.test();
			
		return new ResponseEntity<String>(test, HttpStatus.OK);
		 
	}

}
