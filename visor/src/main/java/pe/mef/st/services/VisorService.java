package pe.mef.st.services;

import java.util.List;

import pe.mef.st.beans.DocumentoBean;

public interface VisorService {
	
	String test();
	List<DocumentoBean> findDNI(String numero, String razonsocial, String documento, String page);
	List<DocumentoBean> findDocRuc(String numero, String razonsocial, String documento, String page);

}
