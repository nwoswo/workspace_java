package pe.mef.st.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.mef.st.dao.TestMapper;




@RestController
@RequestMapping("/api")
public class StartController {
	
	@Autowired
	   public TestMapper testMapper;
	
	 @GetMapping("/inicio")
	 public String inicio() {
	  
	  return testMapper.dual();	
	  
	 }

}
