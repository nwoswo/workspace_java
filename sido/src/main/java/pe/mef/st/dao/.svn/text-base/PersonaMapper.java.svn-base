package pe.mef.st.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.mef.st.bean.RsdcPersona;

public interface PersonaMapper {

	
	List<RsdcPersona> findDNI(  @Param("param1 ") String param1, @Param("param2") String param2);
	
	Long getIdPersona();
	Integer insert(RsdcPersona rsdcPersona); 
	Integer updatePersona(RsdcPersona rsdcPersona);
	
}
