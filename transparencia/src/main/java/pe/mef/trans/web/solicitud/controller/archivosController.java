package pe.mef.trans.web.solicitud.controller;





import java.io.ByteArrayOutputStream;

import java.io.InputStream;
import java.net.URL;
import java.sql.Timestamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.fasterxml.jackson.databind.SerializationFeature;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import net.sf.jasperreports.engine.export.JRPdfExporter;
import pe.mef.trans.repo.mapper.ArchivoMapper;
import pe.mef.trans.repo.mapper.SolicitudMapper;
import pe.mef.trans.web.config.Transaccion;

import pe.mef.trans.web.solicitud.vo.datosAcuse;
import pe.mef.trans.web.solicitud.vo.tsoDArchivosVo;

import org.springframework.core.io.ByteArrayResource;






@RestController
//@CrossOrigin("*")
@RequestMapping("/rest/archivos")
public class archivosController {

	@Autowired
	public ArchivoMapper archivoMapper;
	@Autowired
	public SolicitudMapper solicitudMapper;
	/*
	@Inject
	private ServletContext servletContext;
	 */
	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	public String getHealthCheck() 
	{
		//System.out.println("id archivo ="+ archivoMapper.getIdFile());
		
		return "{ \"todoOk\" : true }";
		
	}

	
	@DeleteMapping(path="/delete/{arcCArchivo}")
	public Transaccion deleteArchivo(@PathVariable("arcCArchivo") Integer arcCArchivo) {
		
		
		System.out.println("deleteeeeeeeeeeeee");
		
		Transaccion tx = new Transaccion();
		int i=3;
		try {
			i=archivoMapper.deleteByid(arcCArchivo+"");
		//tx = facturacionService.deleteServicio(servicio);
			
			System.out.println("delete suprimir "+i);
			
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
		return tx;
	}
	
	
	@PostMapping(path = "/acuse")
	public Transaccion registrar(@RequestBody datosAcuse soli) {
		// TODO Auto-generated method stub

		System.out.println("--acuse- -");
		
		
		Transaccion tx = new Transaccion();
		
		com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	
		
		
		
		String trama;
		
		try {
			
			
			String json = mapper.writeValueAsString(soli);
			System.out.println(json);
		
		//---------------------------------------------------------------------------------------------------------------------
		
		 
		 
		JRPdfExporter exporter = new JRPdfExporter();
		
		 
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		 //PathManager pm = pathManager.getValue();
		ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
		
		JasperReport jasperReport = JasperCompileManager.compileReport(    contextClassLoader.getResourceAsStream("/reportes/report4.jrxml")  );
        
        final Map<String, Object> parameters = new HashMap();

        
        parameters.put("pNombre",soli.getpNombre().replace("null", "").trim());
        parameters.put("pDireccion",soli.getpDireccion().replace("null", "").trim());
        parameters.put("pUbigeo",soli.getpUbigeo());
        parameters.put("pOficio",soli.getpOficio());
        parameters.put("pHojaruta",soli.getpHojaruta().trim());
        
        System.out.println("soli.getpFecha()="+soli.getpFecha());
        
        parameters.put("pFecha","Lima "+soli.getpFecha());
        parameters.put("pImage",contextClassLoader.getResourceAsStream("/reportes/escudo-peru.jpg"));
        
        System.out.println(soli.getpHojaruta().trim().substring(0,4) +  soli.getpHojaruta().trim().substring(5,8));
        
        parameters.put("pBarcode",soli.getpHojaruta().trim().substring(0,4) +  soli.getpHojaruta().trim().substring(5,8));
        
        
        
        JRDataSource dataSource = new JREmptyDataSource();
        
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);
        
        
        
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);   
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
        exporter.exportReport();
        
        /*
        FileOutputStream fos = null; 
        
        byte[] bytes= outputStream.toByteArray();
        
        System.out.println("bytes.length"+bytes.length);
        if(bytes.length>1){
            File someFile = new File("D:/Temp/testReport.pdf");
            fos = new FileOutputStream(someFile);
            fos.write(bytes);
            
            
            
            fos.flush();
            fos.close();
            System.out.println("<<<<<<<<<<<<Report Created>>>>>>>>");
        }
        
     
        File outputFile;
        outputFile = File.createTempFile("simple_report", ".pdf");
        byte[] reportBin = JasperExportManager.exportReportToPdf(jasperPrint);
        
        FileUtils.writeByteArrayToFile(outputFile, outputStream.toByteArray());

		
        //---------------------------------------------------------------------------------------------------------------------
		
        
       
        System.out.println("timestamp="+timestamp.getTime());
        byte[] fileContent = Files.readAllBytes(outputFile.toPath());
        
           */
        
        tsoDArchivosVo t = new tsoDArchivosVo();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		t.setArcBFile( outputStream.toByteArray());
		t.setArcDContentype("application/pdf");
		t.setArcDArchivo(timestamp.getTime()+".pdf" );
		t.setArcDNombre("DOCUMENTO ACUSE");

		t.setArcCTipo(4);
		t.setSolCDocumento(soli.getSolCDocumento());
		t.setAreCArea(soli.getAreCArea());
		t.setUsuCUsuario(soli.getUsuCUsuario());

		//ID
		t.setArcCArchivo(archivoMapper.getIdFile());
		
		archivoMapper.insert(t);
		
		//Actualiza Estado
		
	
		
		tx.setTraDatos(soli.getSolCDocumento()+"|"+"4|"+soli.getUsuCUsuario());
		
		solicitudMapper.call_pkg_spTsoUestado(tx);
		
		//Registramos fecha de generacion acuse -> respuesta
		solicitudMapper.updateFRespuesta(soli.getSolCDocumento());
		
		
		
		//---------------------------------------------------------------------------------------------------------------------
		
			tx.setResult(t.getArcCArchivo());
			
			System.out.println(mapper.writeValueAsString(tx));

		} catch (Exception e) {
			tx.setsCOD("0001");
			tx.setsDESCOD(e.getMessage());

			System.out.println(e.getMessage());
		}

		return tx;
	}
	
	
	
	@GetMapping("/listxSol")
	public List<tsoDArchivosVo> getlistxSol(@RequestParam("solCDocumento") int solCDocumento,@RequestParam("arcCTipo") int arcCTipo) {

		
		tsoDArchivosVo data =  new tsoDArchivosVo();
		
		data.setSolCDocumento(solCDocumento);
		data.setArcCTipo(arcCTipo);
		
		
		return archivoMapper.getListFile(data);

	}
	
	@GetMapping("/listxReq")
	public List<tsoDArchivosVo> getlistxReq(@RequestParam("rinCRequerimiento") int rinCRequerimiento,@RequestParam("arcCTipo") int arcCTipo) {

	
		tsoDArchivosVo data =  new tsoDArchivosVo();
		data.setRinCRequerimiento(rinCRequerimiento);
		data.setArcCTipo(arcCTipo);
		
		
		return archivoMapper.getListFile(data);

	}


	
	
	 @GetMapping("/downloadFile/{id}")
	    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable int id) {
	        // Load file from database
		 
	
		  tsoDArchivosVo t = new tsoDArchivosVo();
		  
		   tsoDArchivosVo t2 = new tsoDArchivosVo();
		   t.setArcCArchivo(id);
		   
		   t2=archivoMapper.getFile(t);
				   
		   System.out.println(t2.getArcDNombre());

	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(t2.getArcDContentype()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + t2.getArcDArchivo() + "\"")
	                .body(new ByteArrayResource(t2.getFileDataBytes()));
	    }
	 
	 
	
	 
	 
	@PostMapping("/upload")
	public Transaccion uploadData(
			@RequestParam("avatar") MultipartFile file,
			
			@RequestParam("solCDocumento") int solCDocumento,
			@RequestParam("arcCTipo") int arcCTipo,
			@RequestParam("usuCUsuario") int usuCUsuario,
			@RequestParam("areCArea") int areCArea,
			@RequestParam("mynamefile") String mynamefile ) throws Exception {
		System.out.println("-------------upload----------------");
	
		System.out.println("mynamefile="+mynamefile);
		
		
		Transaccion tx = new Transaccion();
		if (file == null) {
			
			return tx;
			
			//throw new RuntimeException("You must select the a file for uploading");
		}

		InputStream inputStream = file.getInputStream();
		String originalName = file.getOriginalFilename();
		String nameFile = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();
		
		/*
		System.out.println("inputStream: " + inputStream);
		System.out.println("originalName: " + originalName);
		System.out.println("name: " + nameFile);
		System.out.println("contentType: " + contentType);
		System.out.println("size: " + size);
		*/
		
		
		
		tsoDArchivosVo t = new tsoDArchivosVo();
		
		t.setArcBFile(file.getBytes());
		t.setArcDContentype(file.getContentType());
		
		t.setArcDArchivo(originalName);
		
		t.setArcDNombre(mynamefile.replace("Ã±", "Ñ").toUpperCase());
		t.setArcCTipo(arcCTipo);
		t.setUsuCUsuario(usuCUsuario);
		t.setAreCArea(areCArea);
		
		t.setSolCDocumento(solCDocumento);
		

		System.out.println("binary="+ t.getArcBFile());
		
		try {

			//ID
			t.setArcCArchivo(archivoMapper.getIdFile());
			archivoMapper.insert(t);
			tx.setsCOD("0000");
			tx.setsDESCOD("Resultado ok");

		} catch (Exception e) {
			tx.setsCOD("0001");
			tx.setsDESCOD(e.getMessage());

			System.out.println(e.getMessage());
		}
		
		
	
		return tx;
	}
	
	
	@PostMapping("/uploadReq")
	public Transaccion uploadReq(
			
			@RequestParam("avatar") MultipartFile file,
			
			@RequestParam("solCDocumento") int solCDocumento,
			@RequestParam("rinCRequerimiento") int rinCRequerimiento,
			@RequestParam("arcCTipo") int arcCTipo,
			@RequestParam("usuCUsuario") int usuCUsuario,
			@RequestParam("areCArea") int areCArea,
			@RequestParam("mynamefile") String  mynamefile ) throws Exception {

		
		System.out.println("-------------uploadReq----------------");
		System.out.println("mynamefile="+mynamefile);
		Transaccion tx = new Transaccion();
		if (file == null) {
			
			return tx;
			
			//throw new RuntimeException("You must select the a file for uploading");
		}

		InputStream inputStream = file.getInputStream();
		String originalName = file.getOriginalFilename();
		String nameFile = file.getName();
		String contentType = file.getContentType();
		long size = file.getSize();
		
	
		
		
		tsoDArchivosVo t = new tsoDArchivosVo();
		
		t.setArcBFile(file.getBytes());
		t.setArcDContentype(file.getContentType());
		
		t.setArcDArchivo(originalName);
		
		t.setArcDNombre(mynamefile.replace("Ã±", "Ñ").toUpperCase());
		t.setArcCTipo(arcCTipo);
		t.setUsuCUsuario(usuCUsuario);
		t.setSolCDocumento(solCDocumento);
		t.setAreCArea(areCArea);
		t.setRinCRequerimiento(rinCRequerimiento);

		System.out.println("binary="+ t.getArcBFile());
		
		try {

			//ID
			t.setArcCArchivo(archivoMapper.getIdFile());
			archivoMapper.insert(t);
			tx.setsCOD("0000");
			tx.setsDESCOD("Resultado ok");

		} catch (Exception e) {
			tx.setsCOD("0001");
			tx.setsDESCOD(e.getMessage());

			System.out.println(e.getMessage());
		}
		
		
	
		return tx;
	}
	
	
	
}
