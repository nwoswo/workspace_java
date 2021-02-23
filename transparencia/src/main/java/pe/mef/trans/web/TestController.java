package pe.mef.trans.web;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import pe.mef.trans.web.config.Transaccion;

@RestController
@CrossOrigin("*")
@RequestMapping("/test")
public class TestController {
 
	 
	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	public String getHealthCheck() 
	{
		return "{ \"todoOk\" : true }";
	}

	 
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/plataforma", produces = "application/json; charset=utf-8")
	public String plataforma() 
			throws Exception {

		return "{ \"todoOk\" : ROLE_ADMIN employee  }";
	}
	
	
	
	@PostMapping("/upload")
	public Transaccion uploadData(@RequestParam("uploadedFile") MultipartFile file) throws Exception {

		Transaccion tx = new Transaccion();
		if (file == null) {
			throw new RuntimeException("You must select the a file for uploading");
		}

		InputStream inputStream = file.getInputStream();
		String originalName = file.getOriginalFilename();
		String name = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();
		
		System.out.println("inputStream: " + inputStream);
		System.out.println("originalName: " + originalName);
		System.out.println("name: " + name);
		System.out.println("contentType: " + contentType);
		System.out.println("size: " + size);
		
		// saveUploadedFiles(Arrays.asList(file));
		 

		// Do processing with uploaded file data in Service layer

		return tx;
	}

}
