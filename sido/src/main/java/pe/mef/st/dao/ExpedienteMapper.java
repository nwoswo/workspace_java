package pe.mef.st.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.mef.st.bean.RsdcExpediente;

public interface ExpedienteMapper {
	Long getIdExpediente();
	
	Integer insert(RsdcExpediente rsdcExpediente);
	Integer updateExpediente(RsdcExpediente rsdcExpediente);
	Integer updateExpMov(RsdcExpediente rsdcExpediente);
	
	RsdcExpediente getExpediente(@Param("expCTexpediente") String expCTexpediente);
	
	List<RsdcExpediente> listarExpedientes();
	
	Integer deleteExpediente(@Param("param1") String param1);
	
}
