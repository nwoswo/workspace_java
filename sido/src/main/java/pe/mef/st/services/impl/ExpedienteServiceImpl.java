package pe.mef.st.services.impl;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.swing.tree.ExpandVetoException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import pe.mef.st.bean.MixIn;
import pe.mef.st.bean.RsdcExpediente;
import pe.mef.st.bean.RsdcPersona;
import pe.mef.st.bean.RsdhMovimiento;
import pe.mef.st.dao.ExpedienteMapper;
import pe.mef.st.dao.MovimientoMapper;
import pe.mef.st.dao.PersonaMapper;
import pe.mef.st.services.ExpedienteService;
import pe.mef.st.services.MovimientoService;

@Service
public class ExpedienteServiceImpl implements ExpedienteService {
	
	RsdhMovimiento rsdhMovimiento;

	@Autowired
	private PersonaMapper personaMapper;
	
	@Autowired
	private ExpedienteMapper expedienteMapper;
	
	@Autowired
	private MovimientoMapper movimientoMapper;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	@Autowired
	private MovimientoService movimientoService;
	
	@Override
	public RsdcExpediente nuevoExpInterno(RsdcExpediente rsdcExpediente) {
		
		TransactionStatus txStatus =
		        transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			
			
						
			Long expCExpediente = expedienteMapper.getIdExpediente();
				rsdcExpediente.setExpCExpediente(expCExpediente);
				rsdcExpediente.setExpDNroHoja(this.generateHojaRuta(expCExpediente));
				rsdcExpediente.setExpCEstado(1L);
				rsdcExpediente.setExpCTexpediente(2L);
				
			
			expedienteMapper.insert(rsdcExpediente);
			
			//TODO Probar el transacction manager			
			movimientoService.newExpedienteMov(rsdcExpediente);
			

//			rsdhMovimiento = new RsdhMovimiento(
//					expCExpediente,
//					rsdcExpediente.getExpCUnidadOrigen(),
//					null, //area destino
//					1L, //1 Creado
//					1L, // 1 Vigente
//					null, //observacion
//					null // instruccion
//					);
//					movimientoMapper.insert(rsdhMovimiento);
					
			transactionManager.commit(txStatus);
				
		    } catch (Exception e) {
		      transactionManager.rollback(txStatus);
		      throw e;
		    }
		
		
		
		
		
		return rsdcExpediente;
	}
	
	
	@Override
	public RsdcExpediente nuevoExpediente(RsdcExpediente rsdcExpediente) {
		
		
		
		TransactionStatus txStatus =
		        transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			
			Long perCPersona = personaMapper.getIdPersona();
			rsdcExpediente.getRsdcPersona().setPerCPersona(perCPersona);
				personaMapper.insert(rsdcExpediente.getRsdcPersona());
						
			Long expCExpediente = expedienteMapper.getIdExpediente();
			rsdcExpediente.setExpCExpediente(expCExpediente);
			rsdcExpediente.setExpDNroHoja(this.generateHojaRuta(expCExpediente));
			rsdcExpediente.setExpCEstado(1L);
			rsdcExpediente.setExpCTexpediente(1L);
				expedienteMapper.insert(rsdcExpediente);
			
			rsdhMovimiento = new RsdhMovimiento();
				rsdhMovimiento.setExpCExpediente(expCExpediente);
				rsdhMovimiento.setExpCUnidadOrigen(rsdcExpediente.getExpCUnidadOrigen());
				rsdhMovimiento.setExpCEstado(1L);
				rsdhMovimiento.setMovEEstado(1L);
			
			movimientoMapper.insert(rsdhMovimiento);
					
			transactionManager.commit(txStatus);
				
		    } catch (Exception e) {
		      transactionManager.rollback(txStatus);
		      throw e;
		    }
		
		
		
		
		
		return rsdcExpediente;
	}
	
	@Override
	public RsdcExpediente updateExpediente(RsdcExpediente rsdcExpediente) {
		
		TransactionStatus txStatus =
		        transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			personaMapper.updatePersona(rsdcExpediente.getRsdcPersona());
			expedienteMapper.updateExpediente(rsdcExpediente);
		
			transactionManager.commit(txStatus);
				
		    } catch (Exception e) {
		      transactionManager.rollback(txStatus);
		      throw e;
		    }
		
		return rsdcExpediente;
	}

	@Override
	public String generateHojaRuta(Long idExpediente) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		
		String hojaruta = year+"";
		hojaruta = "E-"+StringUtils.leftPad(idExpediente+"", 6, "0")+"-"+hojaruta;
		
				
		return hojaruta;
	}

	@Override
	public List<RsdcExpediente> listarExpedientes() {
		return expedienteMapper.listarExpedientes();
	}

	@Override
	public JsonNode getExpediente(String expCTexpediente) {
		
		SimpleBeanPropertyFilter theFilter = SimpleBeanPropertyFilter
				  .serializeAllExcept(
						  
						  
						  
						  "expCEstado",
						  "expDEstado",
						  "expEEstado",
						  "expDNroHoja",
						  "expFTermino",
						  
						  "nrofiles",
						  
						  
						  "rtdcUnidadOrganica"
				);
				FilterProvider filters = new SimpleFilterProvider()
				  .addFilter("myFilter", theFilter);
				
		  
		  
		  ObjectMapper mapper = new ObjectMapper();
		  mapper.addMixIn(RsdcExpediente.class, MixIn.class);
		  mapper.addMixIn(RsdcPersona.class, MixIn.class);
		  mapper.setFilterProvider(filters);
		  
		  
		  
		  RsdcExpediente item = expedienteMapper.getExpediente(expCTexpediente);
		  
		  JsonNode  json = mapper.valueToTree(item);
		  
		return json;
	}


	@Override
	public int deleteExpediente(String param1) {
		
		return expedienteMapper.deleteExpediente(param1);
	}

	


	
	
	

}
