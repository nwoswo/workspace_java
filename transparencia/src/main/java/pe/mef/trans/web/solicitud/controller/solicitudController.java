package pe.mef.trans.web.solicitud.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;

import pe.mef.trans.repo.mapper.SolicitudMapper;
import pe.mef.trans.web.config.Transaccion;
import pe.mef.trans.web.solicitud.vo.TsocSolicitudVo;
import pe.mef.trans.web.solicitud.vo.reniecVO;
import pe.mef.trans.web.solicitud.vo.tsoDReqinf;
import pe.mef.trans.web.usuario.vo.GsecUsuario;

@RestController
//@CrossOrigin("*")
@RequestMapping("/rest/solicitud")
public class solicitudController {

	@Autowired
	public SolicitudMapper solicitudMapper;


	
	@GetMapping("/findDNI")
	public Transaccion findDNI(
			@RequestParam("param1") String param1,
			@RequestParam("param2") String param2
			
			) {

		
		System.out.println("param1="+param1);
		System.out.println("param2="+param2);
		
		Transaccion tx = new Transaccion();
		
		String tipodoc="";
		
		//----------------------------------------------------------
		
		
		
		if(param1.contentEquals("DNI"))
		{
			
			tipodoc="01";
		}else if(param1.equals("RU.C")) {
			
		}else if(param1.equals("LE")) {
			
			tipodoc="04";
		}
		//----------------------------------------------------------
		
		tx.setsCOD("0001");
		
		
		
		reniecVO data=null;
		List l= solicitudMapper.findDNI(tipodoc,param2);
		System.out.println("");
		if(l.size()>0)
			data= (reniecVO) l.get(0);
		
		com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
		String json;
		try {
			if(data!=null)
			{
			json = mapper.writeValueAsString(data);
			tx.setsCOD("0000");
			tx.setsDESCOD("Resultado ok");
			tx.setResult(data);
			System.out.println(json);
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return tx;

	}
	
	
	@GetMapping("/list")
	public List<TsocSolicitudVo> getsolESolicitud(
			@RequestParam("param1") String param1,
			@RequestParam("param2") String param2
			
			) {
	
		
		System.out.println("param1="+param1);
		System.out.println("param2="+param2);
		
		ArrayList<Integer> lst=null;
		if(param1.length()>0) {
			lst = new ArrayList<Integer>();
		for (String field : param1.split(","))
			
		    lst.add(Integer.parseInt(field));
		
		}
		
		System.out.println("lst=+"+lst);
		
		System.out.println(solicitudMapper.findAll(lst,param2));
		
		
		return solicitudMapper.findAll(lst,param2);

	}
	
	

	@PostMapping(path = "/registrar")
	public Transaccion registrar(@RequestBody TsocSolicitudVo soli) {
		// TODO Auto-generated method stub

		System.out.println("--registrar--" + soli.getPerCTipodoc());
		Transaccion tx = new Transaccion();
		String trama;
		soli.tInsertTrama();

		trama = soli.getTrama();
		System.out.println(soli.getTrama());

		tx.setTraDatos(trama);

		try {

			solicitudMapper.call_pkg_tsoRsolicitud(tx);
			
			//System.out.println(tx.getsCOD());
			//System.out.println(tx.getsDESCOD());
			
			//tx.setsCOD("0000");
			//tx.setsDESCOD("Resultado ok");

		} catch (Exception e) {
			tx.setsCOD("0001");
			tx.setsDESCOD(e.getMessage());

			System.out.println(e.getMessage());
		}

		return tx;
	}

	@PutMapping(path = "/updateDatosSol")
	public Transaccion updateDatosSol(@RequestBody TsocSolicitudVo soli) {
		// TODO Auto-generated method stub

		System.out.println("--registrar--" + soli.getPerCTipodoc());
		Transaccion tx = new Transaccion();
		String trama;
		soli.tUpdateSol();

		trama = soli.getTrama();
		System.out.println(soli.getTrama());

		tx.setTraDatos(trama);

		try {

			solicitudMapper.call_pkg_tsoUsolicitud(tx);
			//tx.setsCOD("0000");
			//tx.setsDESCOD("Resultado ok");

		} catch (Exception e) {
			tx.setsCOD("0001");
			tx.setsDESCOD(e.getMessage());

			System.out.println(e.getMessage());
		}

		return tx;
	}
	
	
	@PutMapping(path = "/updateFEntrega")
	public Transaccion updateFEntrega(@RequestBody TsocSolicitudVo soli) {
		// TODO Auto-generated method stub

		System.out.println("updateFEntrega=solCDocumento="+soli.getSolCDocumento());
		Transaccion tx = new Transaccion();

		
		try {

			solicitudMapper.updateFEntrega(soli.getSolCDocumento());
			tx.setsCOD("0000");
			tx.setsDESCOD("Resultado ok");

		} catch (Exception e) {
			tx.setsCOD("0001");
			tx.setsDESCOD(e.getMessage());

			System.out.println(e.getMessage());
		}

		return tx;
	}
	

	@PutMapping(path = "/updateEstado")
	public Transaccion updateEstado(@RequestBody TsocSolicitudVo soli) {

		System.out.println("actualizar");
		Transaccion tx = new Transaccion();
		
		tx.setTraDatos(soli.getSolCDocumento()+"|"+soli.getSolESolicitud()+"|"+soli.getUsuCUsuario());




		try {
			 solicitudMapper.call_pkg_spTsoUestado(tx);

			
			
		} catch (Exception e) {
			tx.setsCOD("0001");
			tx.setsDESCOD(e.getMessage());

			System.out.println(e.getMessage());
		}

		return tx;
	}
	
	
	

}
