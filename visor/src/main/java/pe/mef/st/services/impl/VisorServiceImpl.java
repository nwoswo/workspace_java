package pe.mef.st.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.mef.st.beans.DocumentoBean;
import pe.mef.st.dao.SidoMapper;
import pe.mef.st.services.VisorService;


@Service
public class VisorServiceImpl implements VisorService {

	@Autowired
	SidoMapper sidoMapper;
	@Override
	public String test() {
		
		return sidoMapper.test();
	}

	@Override
	public List<DocumentoBean> findDNI(String numero, String razonsocial, String documento, String page) {
		
		return this.sidoMapper.findDNI(numero, razonsocial, documento, page);
	}
	
	@Override
	public List<DocumentoBean> findDocRuc(String numero, String razonsocial, String documento, String page) {
		
		return this.sidoMapper.findDocRuc(numero, razonsocial, documento, page);
	}
	
	
}
