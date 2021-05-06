package pe.mef.st.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.mef.st.dao.SidoMapper;
import pe.mef.st.services.VisorService;


@Service
public class VisorServiceImpl implements VisorService {

	@Autowired
	SidoMapper sidoMapper;

	public String test() {
		
		return sidoMapper.test();
	}
	
	
}
