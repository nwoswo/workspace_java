package pe.mef.trans.web.solicitud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import pe.mef.trans.repo.mapper.ArchivoMapper;
import pe.mef.trans.repo.mapper.ReqinfMapper;
import pe.mef.trans.repo.mapper.SolicitudMapper;
import pe.mef.trans.web.config.Transaccion;
import pe.mef.trans.web.solicitud.vo.tsoDReqinf;




@RestController
//@CrossOrigin("*")
@RequestMapping("/rest/reqinf")
public class reqinfController {

	
	@Autowired
	public ReqinfMapper reqinfMapper;
	
	@Autowired
	public SolicitudMapper solicitudMapper;
	
	@GetMapping(value = "/healthcheck", produces = "application/json; charset=utf-8")
	public String getHealthCheck() 
	{
		return "{ \"todoOk\" : true }";
	}
	
	
	@GetMapping("/list/{solCDocumento}")
	public List<tsoDReqinf> findAllRequerimientos(@PathVariable int solCDocumento) {
		
		System.out.println("------findAllRequerimientos--------"+solCDocumento);
		return reqinfMapper.findAllRequerimientos(solCDocumento);

	}
	
	@GetMapping("/listBA")
	public List<tsoDReqinf> findAllRequerimientosbyArea(@RequestParam("areCArea") int areCArea, @RequestParam("rinEstado") int rinEstado) {
		
		System.out.println("------findAllRequerimientosbyArea--------"+areCArea);
		System.out.println("------rinEstado--------"+rinEstado);	
		
		tsoDReqinf datos = new tsoDReqinf();
		datos.setAreCArea(areCArea);
		datos.setRinEstado(rinEstado);
		
		return reqinfMapper.findAllRequerimientosBA(datos);

	}
	
	@PutMapping(path = "/respuesta")
	public Transaccion respuesta(@RequestBody tsoDReqinf datos) {
		// TODO Auto-generated method stub

		
		
		
		Transaccion tx = new Transaccion();
		try {

			reqinfMapper.updateRespuesta(datos);
			tx.setsCOD("0000");
			tx.setsDESCOD("Resultado ok");

		} catch (Exception e) {
			tx.setsCOD("0001");
			tx.setsDESCOD(e.getMessage());

			System.out.println(e.getMessage());
		}

		return tx;
	}
	
	
	
	@PostMapping(path = "/registrar")
	public Transaccion registrar(@RequestBody tsoDReqinf datos) {
		// TODO Auto-generated method stub

		System.out.println("--registrar--" + datos.getSolCDocumento());
		
		
		ArrayList<Integer> lst=null;
		if(datos.getAreCAreas().length()>0) {
			lst = new ArrayList<Integer>();
		for (String field : datos.getAreCAreas().split(","))
			
		    lst.add(Integer.parseInt(field));
		
		}
		
		System.out.println("lst=+"+lst);
		Transaccion tx = new Transaccion();
		
		for(int areCArea : lst) {
			
			tsoDReqinf data=datos;
			data.setAreCArea(areCArea);
			
			 
		    System.out.println("data.getAreCArea()="+data.getAreCArea());
		    System.out.println("data.getSolCDocumento()="+data.getSolCDocumento());
		    System.out.println("data.getRinDEtalle()="+data.getRinDEtalle());
		    
		    
			try {

				reqinfMapper.insertReqInf(data);
				tx.setsCOD("0000");
				tx.setsDESCOD("Resultado ok");

			} catch (Exception e) {
				tx.setsCOD("0001");
				tx.setsDESCOD(e.getMessage());

				System.out.println(e.getMessage());
			}
			
			
		    
		}
		
		
		
		
	

		return tx;
	}
	
	@PutMapping(path = "/updatePregunta")
	public Transaccion updatePregunta(@RequestBody tsoDReqinf datos) {
		// TODO Auto-generated method stub

		System.out.println("--updatePregunta--" + datos.getRinCRequerimiento());
		
		
		Transaccion tx = new Transaccion();
		try {

			reqinfMapper.updatePregunta(datos);
			tx.setsCOD("0000");
			tx.setsDESCOD("Resultado ok");

		} catch (Exception e) {
			tx.setsCOD("0001");
			tx.setsDESCOD(e.getMessage());

			System.out.println(e.getMessage());
		}

		return tx;
	}
	
	
	
	@DeleteMapping(path = "/delReqInf/{rinCRequerimiento}")
	public Transaccion delReqInf(@PathVariable("rinCRequerimiento") int rinCRequerimiento) {

		System.out.println("delReqInf="+rinCRequerimiento);
		Transaccion tx = new Transaccion();
		
		

		tx.setTraDatos(rinCRequerimiento+"");


		try {
			 solicitudMapper.call_pkg_tsoDelReq(tx);

			
			
		} catch (Exception e) {
			tx.setsCOD("0001");
			tx.setsDESCOD(e.getMessage());

			System.out.println(e.getMessage());
		}

		return tx;
	}
	
}
