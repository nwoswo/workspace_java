package pe.mef.st.web.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.mef.st.bean.RsdcExpediente;
import pe.mef.st.bean.RsdhArchivo;

import pe.mef.st.services.ArchivoService;

import pe.mef.st.web.handlerError.ResponseMessage;

@RestController
@RequestMapping("/api/file")
public class ArchivoController {
	
	@Autowired
	public ArchivoService archivoService;
	
	@PostMapping("/save")
	public ResponseEntity<?> uploadsbd(
			@RequestParam("archivo") MultipartFile[] archivos,
			@RequestParam("data") String data
		) throws  java.io.IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println(mapper.writeValueAsString(data));
		
		RsdhArchivo rsdhArchivo = mapper.readValue(data, RsdhArchivo.class);	
		
		archivoService.guardarArchivos(archivos, rsdhArchivo);
		
		return new ResponseEntity<>(new ResponseMessage("Ok"), HttpStatus.OK);
	}

}
