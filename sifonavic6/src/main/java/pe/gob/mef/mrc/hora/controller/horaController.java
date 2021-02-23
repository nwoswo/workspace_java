package pe.gob.mef.mrc.hora.controller;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;

import pe.gob.mef.mrc.common.domain.GralDatosSend;
import pe.gob.mef.mrc.hora.domain.entity.GmrcTrabajador;
import pe.gob.mef.mrc.hora.domain.mapper.MarcHoraMapper;





@Controller
public class horaController {
	
	
	
	@Autowired
	   public MarcHoraMapper marcHoraMapper;
	
	

	@RequestMapping(value = "/files")
	public void getFile(HttpServletRequest request, HttpServletResponse response) {
		

		 response.setHeader("Content-Disposition", "attachment; filename=Accepted.txt");
		 
		 List<GmrcTrabajador> ltxt = marcHoraMapper.listTxt(request.getParameter("fechaini"),request.getParameter("fechafin"));
		 GmrcTrabajador tra;
	
		 File file = new File("hola"+".txt");
		 
		 BufferedWriter bw = null;
	     FileWriter fw = null;
	     String ln = System.getProperty("line.separator");
	        
//		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
	     try {
            
	    	fw = new FileWriter(file);
	        bw = new BufferedWriter(fw);
	        
	        bw.write("TARJETA   HORA                  FECHA      RELOJ "+ln);
//	        bw.newLine(); 
            
            for (GmrcTrabajador temp : ltxt) {
            	
            	bw.write(temp.getMrcNFotocheck().length() == 8?temp.getMrcNFotocheck():temp.getMrcNFotocheck()+' ' );
            	bw.write(' ');
            	bw.write(temp.getMrcFTimestramp());
            	bw.write(' ');
            	bw.write(temp.getMrcFFechamarc());
            	bw.write(' ');
            	bw.write(temp.getMrcCReloj()+"     "+ln);
//            	bw.newLine();
            	
            }

            
          
	        
//            writer.write("TARJETA   HORA                  FECHA      RELOJ ");
//            writer.newLine(); 
//            
//            for (GmrcTrabajador temp : ltxt) {
//            	
//            	writer.write(temp.getMrcNFotocheck().length() == 8?temp.getMrcNFotocheck():temp.getMrcNFotocheck()+' ' );
//            	writer.write(' ');
//            	writer.write(temp.getMrcFTimestramp());
//            	writer.write(' ');
//            	writer.write(temp.getMrcFFechamarc());
//            	writer.write(' ');
//            	writer.write(temp.getMrcCReloj()+"");
//            	writer.newLine(); 
//            }
//
//            
//            writer.flush();
//            writer.close();
          
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
	            try {
	                if (bw != null)
	                    bw.close();

	                if (fw != null)
	                    fw.close();
	            } catch (IOException ex) {
	                System.err.format("IOException: %s%n", ex);
	            }
	        }
		
		
	    try { 
	    	
	    	

	    	 InputStream targetStream = new FileInputStream(file);
	    	 
	    	 IOUtils.copy(targetStream, response.getOutputStream());
	    	 response.flushBuffer();
	         targetStream.close();
	             
	    } catch (IOException ex) {
	     System.out.println(ex.getStackTrace());
	      throw new RuntimeException("IOError writing file to output stream");
	    }
	    
	  
	      

	}
	
	
//	
	@RequestMapping(value = "existeTrabajador", method = RequestMethod.POST)
	public @ResponseBody GralDatosSend existeTrabajador(ModelMap model,HttpServletRequest request) throws Exception {
		
		System.out.println("--------------existeTrabajador------------");
		GralDatosSend datos=new GralDatosSend();
		Gson gson = new Gson();
		
		System.out.println("mrcCDni"+request.getParameter("mrcCDni"));
		
		
					
	
		try {
			
			
			
			
			int mrcCDni = Integer.parseInt(request.getParameter("mrcCDni"));
			List l = marcHoraMapper.existeTrabajador(mrcCDni+"");
			
			System.out.println("l.size"+l.size());
			
			if(l.size()==0) {
				datos.setCodRpta("002");
				datos.setMsjRpta("El trabajador no Existe");
				return datos;
			}
			
			GmrcTrabajador gmrcTrabajador = (GmrcTrabajador)l.get(0);
			gmrcTrabajador.setUscCUsucre("3213");
			gmrcTrabajador.setMrcCReloj(1);
			
			System.out.println("mrcNFotocheck="+gmrcTrabajador.getMrcNFotocheck());
			
			System.out.println(marcHoraMapper.insertMarcacion(gmrcTrabajador));
			
			
			
			
			
			datos.setCodRpta("001");
			datos.setGson( gson.toJson(l.get(0)) );
			return datos;
			
		} catch (Exception e) {
			datos.setCodRpta("000");
			datos.setMsjRpta(e.getMessage());
			e.printStackTrace();
			return datos;
			
			// TODO: handle exception
		}
		
		
		
		
		
		
		
	}
	
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public class ForbiddenException extends RuntimeException {}

	
	@RequestMapping("index")
	public String logout( ModelMap model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("Start");
		
		
		
		try {
			System.out.println(marcHoraMapper.horaOracle());
			model.addAttribute("hora", marcHoraMapper.horaOracle());
			return "inicio";
		} catch (Exception e) {
			throw new ForbiddenException();
		}
	
		
	}
	
	
	@RequestMapping("formulario")
	public String formulario( ModelMap model,HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("formulario");
		
		
		
		return "formulario";
	}
	
	
	
	
	
	
	 

}
