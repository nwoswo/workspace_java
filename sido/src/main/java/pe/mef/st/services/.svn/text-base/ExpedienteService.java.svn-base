package pe.mef.st.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;

import pe.mef.st.bean.RsdcExpediente;


public interface ExpedienteService {
	
	public JsonNode getExpediente(String expCTexpediente);
	
	public RsdcExpediente nuevoExpediente(RsdcExpediente rsdcExpediente);
	public RsdcExpediente updateExpediente(RsdcExpediente rsdcExpediente);
	
	public RsdcExpediente nuevoExpInterno(RsdcExpediente rsdcExpediente);
	
	public String generateHojaRuta(Long idExpediente); 
	
	public List<RsdcExpediente> listarExpedientes();
	
	public int deleteExpediente(String param1);
	
	//Listar Tipo Documento para Expediente ( acta, comunicado

}
