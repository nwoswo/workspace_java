package pe.mef.st.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.google.gson.Gson;

import pe.mef.st.bean.MixIn;
import pe.mef.st.bean.RsdcExpediente;
import pe.mef.st.bean.RsdcPersona;
import pe.mef.st.bean.RsdhArchivo;
import pe.mef.st.dao.ArchivoMapper;
import pe.mef.st.dao.PersonaMapper;
import pe.mef.st.services.ExpedienteService;
import pe.mef.st.web.handlerError.RecursoNotFoundException;
import pe.mef.st.web.handlerError.ResponseMessage;

@RestController
//@CrossOrigin( origins = "*" )
@RequestMapping("/api/expediente")
public class ExpedienteController {
	
	@Autowired
	public ExpedienteService expedienteService;
	
	@Autowired
	public ArchivoMapper archivoMapper;
	
	
	@PostMapping("/saveInterno")
	public ResponseEntity<?> saveInterno(
			@RequestParam(value ="archivo", required = false) MultipartFile[] archivos,
			@RequestParam("data") String data
		) throws IOException {
		

		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(data));
		
		
		RsdcExpediente expediente = mapper.readValue(data, RsdcExpediente.class);	
					
		expediente = expedienteService.nuevoExpInterno(expediente);
		
		
		RsdhArchivo blob;
		for (MultipartFile mf : archivos) {
			
			blob = new RsdhArchivo();
			
			blob.setExpCExpediente(expediente.getExpCExpediente());
			blob.setExpCUnidadOrigen(expediente.getExpCUnidadOrigen());
			blob.setAchBFile(mf.getBytes());
			blob.setAchDContentype(mf.getContentType());
			blob.setAchDArchivo(mf.getOriginalFilename());
						
			archivoMapper.insert(blob);
			
		}	
		return new ResponseEntity<>(new ResponseMessage("Ok"), HttpStatus.OK);

	}
	
	
	@PostMapping("/guardar")
	public ResponseEntity<?> save(
			@RequestParam(value ="archivo", required = false) MultipartFile[] archivos
			,@RequestParam("data") String data
		) throws IOException {
		

		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(data));
		
		Gson gson = new Gson();
		
		
		System.out.println(gson.toJson(data));
		
		RsdcExpediente expediente = mapper.readValue(data, RsdcExpediente.class);	
					
		expediente = expedienteService.nuevoExpediente(expediente);
		
		
		RsdhArchivo blob;
		for (MultipartFile mf : archivos) {
			
			blob = new RsdhArchivo();
			
			blob.setExpCExpediente(expediente.getExpCExpediente());
			blob.setExpCUnidadOrigen(expediente.getExpCUnidadOrigen());
			blob.setAchBFile(mf.getBytes());
			blob.setAchDContentype(mf.getContentType());
			blob.setAchDArchivo(mf.getOriginalFilename());
						
			archivoMapper.insert(blob);
			
		}	
		return new ResponseEntity<>(new ResponseMessage("Ok"), HttpStatus.OK);

	}
	
	@PutMapping("/update") 
	public ResponseEntity<?> update(@RequestBody RsdcExpediente expediente ) throws IOException {
		

		expediente = expedienteService.updateExpediente(expediente);

		return new ResponseEntity<>(new ResponseMessage("Ok"), HttpStatus.OK);

	}
	
	@DeleteMapping("/{expCTexpediente}") 
	public ResponseEntity<?> deleteExpediente(@PathVariable String expCTexpediente) throws IOException {
		

		System.out.println("expCTexpediente: "+expCTexpediente);
		
		expedienteService.deleteExpediente(expCTexpediente);
		

		return new ResponseEntity<>(new ResponseMessage("Ok"), HttpStatus.OK);

	}
	
	
	@GetMapping("/listar")
	 public ResponseEntity<?> inicio() {
	  
		  List<RsdcExpediente> lexpediente = expedienteService.listarExpedientes();
			 
		  return new ResponseEntity<List<RsdcExpediente>>(lexpediente, HttpStatus.OK);
		 
	 }
	
	@GetMapping("/listar/{expCTexpediente}")
	 public ResponseEntity<?> getExpediente(@PathVariable String expCTexpediente) throws JsonProcessingException {
	  
		  System.out.println("expCTexpediente: "+expCTexpediente);
		  	
		  JsonNode data = expedienteService.getExpediente(expCTexpediente);
		  if(data ==null ) {
			  throw  new  RecursoNotFoundException("No Existe ");
		  }
		  return new ResponseEntity(expedienteService.getExpediente(expCTexpediente), HttpStatus.OK);
		  
		 
	 }
	
//	@PostMapping("/upload")
//	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo) throws IOException{
//		Map<String, Object> response = new HashMap<>();
//		
//		if(!archivo.isEmpty()) {
//			String nombreArchivo = archivo.getOriginalFilename();
//			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
//			
//			Files.copy(archivo.getInputStream(),  rutaArchivo);
//					
//		}
//		
//		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
//	}
//	
//	@PostMapping("/uploads")
//	public ResponseEntity<?> uploads(@RequestParam("archivo") MultipartFile[] archivos) throws IOException{
//		Map<String, Object> response = new HashMap<>();
//		for (MultipartFile mf : archivos) {
//			String nombreArchivo = mf.getOriginalFilename();
//			Path rutaArchivo = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
//			
//			Files.copy(mf.getInputStream(),  rutaArchivo);
//		}
//		
//		
//		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
//	}
//	
//	@PostMapping("/uploadbd")
//	public ResponseEntity<?> uploadbd(@RequestParam("archivo") MultipartFile archivo) throws IOException{
//		Map<String, Object> response = new HashMap<>();
//		
//		if(!archivo.isEmpty()) {
//			
//					
//			RsdhArchivo blob = new RsdhArchivo();
//			
//			blob.setExpCExpediente(15L);
//			blob.setAreCArea(14L);
//			blob.setAchBFile(archivo.getBytes());
//			blob.setAchDContentype(archivo.getContentType());
//			blob.setAchDArchivo(archivo.getOriginalFilename());
//						
//			archivoMapper.insert(blob);
//		}
//		
//		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
//	}
//	
//	@PostMapping("/uploadsbd")
//	public ResponseEntity<?> uploadsbd(@RequestParam("archivo") MultipartFile[] archivos) throws IOException{
//		Map<String, Object> response = new HashMap<>();
//		System.out.println("archivos: "+archivos.length);
//		
//		RsdhArchivo blob;
//		for (MultipartFile mf : archivos) {
//			
//			blob = new RsdhArchivo();
//			
//			blob.setExpCExpediente(15L);
//			blob.setAchBFile(mf.getBytes());
//			blob.setAchDContentype(mf.getContentType());
//			blob.setAchDArchivo(mf.getOriginalFilename());
//						
//			archivoMapper.insert(blob);
//			
//		}
//		
//		
//		return new ResponseEntity<Map<String, Object>> (response, HttpStatus.CREATED);
//	}

}
