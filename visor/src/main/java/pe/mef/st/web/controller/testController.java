package pe.mef.st.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import pe.mef.st.beans.DocumentoBean;
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
	
	@GetMapping("/dni")
	 public ResponseEntity<?> inicio(
		 @RequestParam("param1") String param1, 
		 @RequestParam("param2") String param2,
		 @RequestParam("param3") String param3){
	  
		System.out.println("param1"+ param1);
		System.out.println("param2"+ param2);
		System.out.println("param3"+ param3);
		
		List<DocumentoBean> l = this.vService.findDNI(param1.trim(), param2.trim(), param3.trim());
			
		return new ResponseEntity<List>(l, HttpStatus.OK);
		 
	}

}
