package pe.mef.st.services.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.mef.st.bean.RsdhArchivo;
import pe.mef.st.dao.ArchivoMapper;
import pe.mef.st.services.ArchivoService;

@Service
public class ArchivoServiceImpl implements ArchivoService {
	
	@Autowired
	ArchivoMapper archivoMapper;

	@Override
	public int guardarArchivos(MultipartFile[] archivos, RsdhArchivo data) throws IOException {
		
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(mapper.writeValueAsString(data));
		
		RsdhArchivo rsdhArchivo;
		
		for (MultipartFile mf : archivos) {
			
			rsdhArchivo = new RsdhArchivo();
			
			rsdhArchivo.setExpCExpediente(data.getExpCExpediente());
			rsdhArchivo.setExpCUnidadOrigen(data.getExpCUnidadOrigen());
			rsdhArchivo.setAchBFile(mf.getBytes());
			rsdhArchivo.setAchDContentype(mf.getContentType());
			rsdhArchivo.setAchDArchivo(mf.getOriginalFilename());
						
			 archivoMapper.insert(rsdhArchivo);
			
		}

		return 1;
	}

}
