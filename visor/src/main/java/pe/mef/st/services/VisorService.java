package pe.mef.st.services;

import java.util.List;

import pe.mef.st.beans.DocumentoBean;

public interface VisorService {
	
	String test();
	List<DocumentoBean> findDNI(String param1, String param2, String param3);

}
