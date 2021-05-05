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
import pe.mef.st.bean.RsdhMovimiento;
import pe.mef.st.services.ArchivoService;
import pe.mef.st.services.MovimientoService;
import pe.mef.st.web.handlerError.ResponseMessage;

@RestController
@RequestMapping("/api/mov")
public class MovimientoController {
	
	@Autowired
	public MovimientoService movimientoService;
	
	@PostMapping("/derivar")
	public ResponseEntity<?> derivar(
			@RequestBody RsdhMovimiento rsdhMovimiento 
		) throws  java.io.IOException{
		
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println(mapper.writeValueAsString(rsdhMovimiento));
		
			
		
		movimientoService.derivarExpediente(rsdhMovimiento);
		
		return new ResponseEntity<>(new ResponseMessage("Ok"), HttpStatus.OK);
	}

}
