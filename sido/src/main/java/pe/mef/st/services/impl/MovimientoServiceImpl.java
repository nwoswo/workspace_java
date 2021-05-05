package pe.mef.st.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import pe.mef.st.bean.RsdcExpediente;
import pe.mef.st.bean.RsdhCopia;
import pe.mef.st.bean.RsdhMovimiento;
import pe.mef.st.dao.CopiaMapper;
import pe.mef.st.dao.ExpedienteMapper;
import pe.mef.st.dao.MovimientoMapper;
import pe.mef.st.services.MovimientoService;

@Service
public class MovimientoServiceImpl implements MovimientoService{

	@Autowired
	MovimientoMapper movimientoMapper;
	
	@Autowired
	CopiaMapper copiaMapper;
	
	@Autowired
	ExpedienteMapper expedienteMapper;
	
	
	@Override
	public int newExpedienteMov(RsdcExpediente rsdcExpediente) {
		
		RsdhMovimiento rsdhMovimiento = new RsdhMovimiento();
		
			
			rsdhMovimiento.setExpCExpediente(rsdcExpediente.getExpCExpediente());
			rsdhMovimiento.setExpCUnidadOrigen(rsdcExpediente.getExpCUnidadOrigen());
			
			rsdhMovimiento.setExpCEstado(1L);
			rsdhMovimiento.setMovEEstado(1L);
				
				
				
		return movimientoMapper.insert(rsdhMovimiento);
	}

	@Override
	public int derivarExpediente(RsdhMovimiento rsdhMovimiento) {
		//TODO probar transaccion
		
		rsdhMovimiento.setExpCEstado(3L); //3- Enviado
		rsdhMovimiento.setMovEEstado(1L); //1 :Activo
		
		RsdcExpediente rsdcExpediente = new RsdcExpediente();
			rsdcExpediente.setExpCEstado(rsdhMovimiento.getExpCEstado());
			rsdcExpediente.setExpCUnidadOrigen(rsdhMovimiento.getExpCUnidadDestino());
			rsdcExpediente.setExpCExpediente(rsdhMovimiento.getExpCExpediente());
		
		expedienteMapper.updateExpMov(rsdcExpediente);
		
//		rsdhCopia.setExpCExpediente(rsdhMovimiento.getExpCExpediente());
//		rsdhCopia.setExpCUnidadOrigen(rsdhMovimiento.getExpCUnidadOrigen());
//		rsdhCopia.setExpCUnidadDestino(rsdhMovimiento.getExpCUnidadDestino());
//		rsdhCopia.setCopEestado(1L);
		
		for (RsdhCopia rsdhCopia : rsdhMovimiento.getRsdhCopia() ) {
			rsdhCopia.setCopEestado(1L);
			copiaMapper.insert(rsdhCopia);
		}
		
		
		return movimientoMapper.insert(rsdhMovimiento);
	}

}
