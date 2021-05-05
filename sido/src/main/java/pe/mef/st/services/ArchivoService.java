package pe.mef.st.services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import pe.mef.st.bean.RsdhArchivo;

public interface ArchivoService {
	
	int guardarArchivos(MultipartFile[] archivos, RsdhArchivo data) throws IOException;

}
