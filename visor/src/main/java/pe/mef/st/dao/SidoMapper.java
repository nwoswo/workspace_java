package pe.mef.st.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pe.mef.st.beans.DocumentoBean;

public interface SidoMapper {

	
	
	String test();
	List<DocumentoBean> findDNI(
		@Param("param1 ") String param1, 
		@Param("param2") String param2,
		@Param("param3") String param3
	);
	
	
}
