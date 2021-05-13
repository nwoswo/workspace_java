package pe.mef.st.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	
	private Logger logger = Logger.getLogger(testController.class);
	
	@Autowired
	VisorService vService;
	
	@GetMapping("/test")
	public ResponseEntity<?> inicio() {
	  
		String test =vService.test();
			
		return new ResponseEntity<String>(test, HttpStatus.OK);
		 
	}
	

	@GetMapping("/file")
	public ResponseEntity<?> file(@RequestParam("fileName") String fileName ) throws IOException {
		
		
		String tempFileName = ruta(fileName);
		
		if(tempFileName == null ) {
			return ResponseEntity
		            .status(HttpStatus.NOT_FOUND)
		            .body("Error Message");
		}
		 
		
		
		File file = new File(tempFileName);
		
		
		InputStreamResource resource = new InputStreamResource(new FileInputStream(tempFileName));
		//Path path = Paths.get(file.getAbsolutePath());
	    //ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));
	    
		
		System.out.println(resource);
		
		HttpHeaders headers = new HttpHeaders(); 
		headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename="+fileName);
			
		return ResponseEntity.ok()
        .headers(headers)
        .contentLength(file.length())
        .contentType(MediaType.APPLICATION_PDF)
        .body(resource);
		 
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/findjuridica")
	 public ResponseEntity<?> inicio(
		 @RequestParam("numero") String numero, 
		 @RequestParam("razonsocial") String razonsocial,
		 @RequestParam("documento") String documento,
		 @RequestParam("page") String page){
		
		List<?> l;
		
		logger.info("This is an info log entry");
        logger.error("This is an error log entry");
        
        if( (numero ==null || numero == "") && (razonsocial ==null || razonsocial == "") && (documento ==null || documento == "") ) {
        	l = new ArrayList<>();
        }else {
        	
        	l = this.vService.findDocRuc(numero, razonsocial, documento, page);
        }
        	
        
			
		return new ResponseEntity<List>(l, HttpStatus.OK);
		 
	}
	
	
	String ruta(String fileName) {
		File root = new File("/home");
		
        
        try {
            boolean recursive = true;

            Collection files = FileUtils.listFiles(root, null, recursive);

            for (Iterator iterator = files.iterator(); iterator.hasNext();) {
                File file = (File) iterator.next();
                if (file.getName().equals(fileName)) {
                	System.out.println(file.getAbsolutePath());
                	return file.getAbsolutePath();
                }
               
                    
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
	}
	

	

}
